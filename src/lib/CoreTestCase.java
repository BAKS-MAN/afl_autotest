package lib;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import junit.framework.TestCase;
import lib.ui.MainPageObject;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;

public class CoreTestCase extends TestCase {
    protected AppiumDriver driver;
    private static String AppiumURL = "http://127.0.0.1:4723/wd/hub";

    @Override
    protected  void setUp() throws Exception{
        super.setUp();
        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("platformName","Android");
        capabilities.setCapability("deviceName","AndroidTestDevice");
        capabilities.setCapability("platformVersion","8.0");
//        capabilities.setCapability("platformVersion","6.0.1"); // Xiaomi Redmi Note 3 (Android 6.0.1)
        capabilities.setCapability("automationName","Appium");
        capabilities.setCapability("appPackage","ru.aeroflot.afltest");
        capabilities.setCapability("appActivity","ru.aeroflot.SplashScreenActivity");
        capabilities.setCapability("unicodeKeyboard","true");
        capabilities.setCapability("app","E:/Dev/AutoTest/Aeroflot/apks/app-afltest-x86-release.apk");
//        capabilities.setCapability("app","D:/AutoTest/Aeroflot/apks/app-afltest-x86-release.apk");

        driver = new AndroidDriver(new URL(AppiumURL),capabilities);
        this.skipLoginWindow();
    }

    @Override
    protected  void tearDown() throws Exception{
        driver.quit();
        super.tearDown();
    }
    protected void backgroungApp (int seconds) {driver.runAppInBackground(seconds);}

    private void skipLoginWindow(){
        MainPageObject MainPageObject = new MainPageObject(driver);
        MainPageObject.waitForElementPresent("id:ru.aeroflot.afltest:id/auth_username","Экран авторизации не отобразился",15);
//        try {Thread.sleep(10000);} catch (Exception e) {}
        driver.navigate().back();
    }
}
