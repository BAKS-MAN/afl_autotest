package lib.ui;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
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
    public By getLocatorByString (String locator_with_type){
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

//    // Метод для получения текстового содержимого элемента
//    public String getElementText (String locator){
//        By by = this.getLocatorByString(locator);
//        String element = driver.findElement(by).getText();
//        return element;
//    }

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
        action.press(PointOption.point(10, 500)).release().perform();
//        action.press(10, 500).release().perform();
    }

    public void swipeDown (int timeOfSwipe){
        TouchAction action = new TouchAction(driver);
        Dimension size = driver.manage().window().getSize();
        int x = size.width/2;
        int start_y = (int) (size.height*0.6);
        int end_y = (int) (size.height*0.9);
        action.press(PointOption.point(x, start_y)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(timeOfSwipe))).moveTo(PointOption.point(x,end_y)).release().perform();
//      action.press(x, start_y).waitAction(timeOfSwipe).moveTo(x,end_y).release().perform();
    }
    public void swipeDownQuick(){
        swipeDown(600);
    }

    public void swipeUp (int timeOfSwipe){
        TouchAction action = new TouchAction(driver);
        Dimension size = driver.manage().window().getSize();
        int x = size.width/2;
        int start_y = (int) (size.height*0.8);
        int end_y = (int) (size.height*0.2);
        action.press(PointOption.point(x, start_y)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(timeOfSwipe))).moveTo(PointOption.point(x,end_y)).release().perform();
    }

    public void swipeUpQuick(){
        swipeUp(600);
    }

    public void swipeUpToFindElement(String locator,String error_message, int max_swipes){
        By by = this.getLocatorByString(locator);
        int already_swiped = 0;
        while(driver.findElements(by).size()==0){
            if (already_swiped > max_swipes){
                waitForElementPresent(locator, "Cannot find element by swiping up. \n" + error_message, 0);
                return;
            }
            swipeUp(1000);
            ++already_swiped;
        }
    }

    public void swipeLeftToFindElement(String swipe_position,String locator, String error_message, int max_swipes){
        By by = this.getLocatorByString(swipe_position);
        int already_swiped = 0;
        while (!isElementPresent(locator)){
            if (already_swiped > max_swipes){
                Assert.assertTrue(error_message, isElementPresent(locator));
            }
            TouchAction action = new TouchAction(driver);
            WebElement element = driver.findElement(by);
            int left_x = element.getLocation().getX();
            int right_x = left_x + element.getSize().getWidth();
            int middle_y = element.getLocation().getY() + element.getSize().getHeight() / 2;
            action.press(PointOption.point(right_x, middle_y)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(500))).moveTo(PointOption.point(left_x, middle_y)).release().perform();
            //            action.press(right_x, middle_y).waitAction(500).moveTo(left_x, middle_y).release().perform();
            ++already_swiped;
        }
    }

    public void swipeElementToLeft(String locator,  String error_message){
        WebElement element = waitForElementPresent(locator, error_message, 10);
        int left_x = element.getLocation().getX();
        int right_x = left_x + element.getSize().getWidth();
        int upper_y = element.getLocation().getY();
        int lower_y = upper_y + element.getSize().getHeight();
        int middle_y = (upper_y + lower_y)/2;
        TouchAction action = new TouchAction(driver);
        action.press(PointOption.point(right_x, middle_y));
        action.waitAction(WaitOptions.waitOptions(Duration.ofMillis(100)));
        action.moveTo(PointOption.point(left_x, middle_y));
        action.release();
        action.perform();
    }

    public boolean isElementPresent(String locator){
        By by = this.getLocatorByString(locator);
        try {
            driver.findElement(by);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    // Метод для получения атрибута элемента
    public String getElementValue(String locator, String attribute){
        By by = this.getLocatorByString(locator);
        String element = driver.findElement(by).getAttribute(attribute);
        return element;
    }

    public int getAmountOfElements(String locator){
        By by = this.getLocatorByString(locator);
        List elements = driver.findElements(by);
        return elements.size();
    }
    public void scrollDownToElementFromList(String locator, String keyword_locator, int max_swipes){
        By by = this.getLocatorByString(locator);
        boolean element_found = false;
        int already_swiped = 0;
        while(!element_found) {
            if (this.isElementPresent(keyword_locator)){
                waitForElementAndClick(keyword_locator,"Не удалось выбрать найденное значение.",3);
                element_found = true;
            } else if (already_swiped > max_swipes){
                throw new AssertionError("Не удалось найти нужное значение в списке: "+keyword_locator);
            }
            else {
                TouchAction action = new TouchAction(driver);
                WebElement element = driver.findElement(by);
                int middleX = element.getLocation().getX() + element.getSize().getWidth() / 2;
                int upperY = element.getLocation().getY();
                int lowerY = upperY + element.getSize().getHeight() - 50;
                action.press(PointOption.point(middleX, lowerY)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(1200))).moveTo(PointOption.point(middleX, upperY)).release().perform();
                ++already_swiped;
                continue;
            }
        }
    }
    public void scrollUpToElementFromList(String locator, String keyword_locator, int max_swipes){
        By by = this.getLocatorByString(locator);
        boolean element_found = false;
        int already_swiped = 0;
        while(!element_found) {
            if (this.isElementPresent(keyword_locator)){
                waitForElementAndClick(keyword_locator,"Не удалось выбрать найденное значение.",3);
                element_found = true;
            } else if (already_swiped > max_swipes){
                throw new AssertionError("Не удалось найти нужное значение в списке: "+keyword_locator);
            }
            else {
                TouchAction action = new TouchAction(driver);
                WebElement element = driver.findElement(by);
                int middleX = element.getLocation().getX() + element.getSize().getWidth() / 2;
                int upperY = element.getLocation().getY();
                int lowerY = upperY + element.getSize().getHeight() - 50;
                action.press(PointOption.point(middleX, upperY)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(1100))).moveTo(PointOption.point(middleX, lowerY)).release().perform();
                ++already_swiped;
                continue;
            }
        }
    }

    public String firstLetterToUpperCase(String word){
        return word.toLowerCase().substring(0,1).toUpperCase()+word.toLowerCase().substring(1);
    }

    public void getDate (String date){
        String[] exploded_date = date.split(Pattern.quote("/"),3);
        String day = exploded_date[0];
        String month = exploded_date[1];
        String year = exploded_date[2];
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
