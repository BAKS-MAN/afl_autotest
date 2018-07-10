package lib.ui;

import io.appium.java_client.AppiumDriver;

public class LoginPageObject extends MainPageObject{
    public LoginPageObject(AppiumDriver driver){super(driver);}

    private static String
        TEST = "id:ru.aeroflot.afltest:id/auth_username";

    public void clickBack(){
        driver.navigate().back();
    }
}
