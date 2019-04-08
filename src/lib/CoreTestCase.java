package lib;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import junit.framework.TestCase;
import lib.ui.GDPRPageObject;
import lib.ui.LoginPageObject;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;
import java.time.Duration;

public class CoreTestCase extends TestCase {
    protected AppiumDriver driver;
    private static String AppiumURL = "http://0.0.0.0:4723/wd/hub";

    @Override
    protected  void setUp() throws Exception{
        super.setUp();
        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("platformName","Android");
        capabilities.setCapability("deviceName","AndroidTestDevice");
//        capabilities.setCapability("platformVersion","8.0");
        capabilities.setCapability("platformVersion","6.0.1"); // Xiaomi Redmi Note 3 (Android 6.0.1)
        capabilities.setCapability("automationName","Appium");
        capabilities.setCapability("appPackage","ru.aeroflot.afltest");
        capabilities.setCapability("appActivity","ru.aeroflot.SplashScreenActivity");
        capabilities.setCapability("unicodeKeyboard","true");
//        capabilities.setCapability("app","E:/Dev/AutoTest/Aeroflot/apks/app-afltest-x86-release.apk");

        driver = new AndroidDriver(new URL(AppiumURL),capabilities);
        this.skipToMenu();
    }

    @Override
    protected  void tearDown() throws Exception{
        driver.quit();
        super.tearDown();
    }
    protected void backgroungApp (int seconds) {driver.runAppInBackground(Duration.ofSeconds(seconds));}

    private void skipToMenu(){
        GDPRPageObject GDPRPageObject = new GDPRPageObject(driver);
        GDPRPageObject.confirmGDPR();
    }
}
