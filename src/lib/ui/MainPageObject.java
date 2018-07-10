package lib.ui;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.regex.Pattern;

public class MainPageObject {
    protected AppiumDriver driver;
    public MainPageObject (AppiumDriver driver) {this.driver = driver;}

    //Метод для определения типа локаторов
    private By getLocatorByString (String locator_with_type){
        String[] exploded_locator = locator_with_type.split(Pattern.quote(":"),2);
        String by_type = exploded_locator[0];
        String locator = exploded_locator[1];

        if (by_type.equals("xpath")){
            return By.xpath(locator);
        } else if (by_type.equals("id")){
            return By.id(locator);
        } else {
            throw new IllegalArgumentException("Cannot get type of locator. Locator: " +locator_with_type);
        }
    }

    //Метод для ожидания отображения элемента
    public WebElement waitForElementPresent (String locator, String error_message, long timeoutInSeconds){
        By by = this.getLocatorByString(locator);
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
        wait.withMessage(error_message + "\n");
        return wait.until(
                ExpectedConditions.presenceOfElementLocated(by)
        );
    }

    public WebElement waitForElementAndClick (String locator, String error_message, long timeoutInSeconds){
        WebElement element = waitForElementPresent(locator, error_message, timeoutInSeconds);
        element.click();
        return element;
    }

    public WebElement waitForElementAndSendKeys(String locator, String value, String error_message, long timeoutInSeconds){
        WebElement element = waitForElementPresent(locator,error_message,timeoutInSeconds);
        element.sendKeys(value);
        return element;
    }

    public boolean waitForElementNotPresent(String locator, String error_message, long timeoutInSeconds){
        By by = this.getLocatorByString(locator);
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
        wait.withMessage(error_message + "\n");
        return wait.until(
                ExpectedConditions.invisibilityOfElementLocated(by)
        );
    }

    public WebElement waitForElementAndClear(String locator, String value, String error_message, long timeoutInSeconds){
        WebElement element = waitForElementPresent(locator,error_message,timeoutInSeconds);
        element.clear();
        return element;
    }
    public void freeTap(){
        TouchAction action = new TouchAction(driver);
        action.press(10, 500).release().perform();
    }
    public void swipeDown (int timeOfSwipe){
        TouchAction action = new TouchAction(driver);
        Dimension size = driver.manage().window().getSize();
        int x = size.width/2;
        int start_y = (int) (size.height*0.6);
        int end_y = (int) (size.height*0.9);
        action.press(x, start_y).waitAction(timeOfSwipe).moveTo(x,end_y).release().perform();
    }
    public void swipeDownQuick(){
        swipeDown(100);
    }

    public void swipeUp (int timeOfSwipe){
        TouchAction action = new TouchAction(driver);
        Dimension size = driver.manage().window().getSize();
        int x = size.width/2;
        int start_y = (int) (size.height*0.8);
        int end_y = (int) (size.height*0.2);

        action.press(x, start_y).waitAction(timeOfSwipe).moveTo(x,end_y).release().perform();
    }

    public void swipeUpQuick(){
        swipeUp(200);
    }

    public void swipeUpToFindElement(String locator,String error_message, int max_swipes){
        By by = this.getLocatorByString(locator);
        int already_swiped = 0;
        while(driver.findElements(by).size()==0){
            if (already_swiped > max_swipes){
                waitForElementPresent(locator, "Cannot find element by swiping up. \n" + error_message, 0);
                return;
            }
            swipeUpQuick();
            ++already_swiped;
        }
    }

    public void swipeUpTillElementAppear(String locator, String error_message, int max_swipes){
        int already_swiped = 0;
        while (!this.isElementLocatedOnTheScreen(locator)){
            if (already_swiped > max_swipes){
                Assert.assertTrue(error_message, this.isElementLocatedOnTheScreen(locator));
            }
            swipeUpQuick();
            ++already_swiped;
        }
    }

    public boolean isElementLocatedOnTheScreen(String locator){
        int element_location_by_y = this.waitForElementPresent(locator,"Cannot find element by locator "+locator,1).getLocation().getY();
        int screen_size_by_y = driver.manage().window().getSize().getHeight();
        return element_location_by_y < screen_size_by_y;
    }

    public int getAmountOfElements(String locator){
        By by = this.getLocatorByString(locator);
        List elements = driver.findElements(by);
        return elements.size();
    }
    public void scrollToElementFromList (String locator, String keyword_locator){
        By by = this.getLocatorByString(locator);
        List <WebElement> list = driver.findElements(by);
        System.out.println(list);
        if (list != null && !list.isEmpty()) {
            WebElement startElement = list.get(0);
            WebElement endElement = list.get(list.size() - 1);
            TouchAction actions = new TouchAction(driver);
            actions.press(startElement).moveTo(endElement).release().perform();
        }
    }

    public void assertElementNotPresent(String locator, String error_message){
        int amount_of_elements = getAmountOfElements(locator);
        if (amount_of_elements > 0){
            String default_message = "An element '" + locator+ "' supposed to be not present";
            throw new AssertionError(default_message + " " + error_message);
        }
    }

    public void assertElementPresent(String locator,  String error_message){
        int amount_of_elements = getAmountOfElements(locator);
        if (amount_of_elements < 1){
            String default_message = "An element '" + locator+ "' was not present";
            throw new AssertionError(error_message + "\n" + default_message);
        }
    }
}
