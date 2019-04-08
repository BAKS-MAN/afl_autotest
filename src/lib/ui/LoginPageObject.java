package lib.ui;

import io.appium.java_client.AppiumDriver;

public class LoginPageObject extends MainPageObject{
    public LoginPageObject(AppiumDriver driver){super(driver);}

    private static final String
        USER_NAME = "id:user-data",
        USER_NAME_INPUT = "xpath://android.view.View[1]/android.view.View[1]/android.view.View[2]",
        USER_PASSWORD = "id:password",
        USER_PASSWORD_INPUT = "xpath://android.view.View[1]/android.view.View[2]/android.view.View[2]",
        LOGIN_BUTTON = "xpath://*[@class = 'android.widget.Button'][@text = 'Вход']";


    public void skipLoginWindow(){
        this.waitForElementPresent(USER_NAME,"Экран авторизации не отобразился",20);
//        this.waitForElementPresent("id:ru.aeroflot.afltest:id/auth_username","Экран авторизации не отобразился",15); //Экран авторизации до v3.16
//        try {Thread.sleep(10000);} catch (Exception e) {}
        driver.navigate().back();
    }
    public void loginIntoAccount(String login, String password){
        waitForElementPresent(USER_NAME,"Экран авторизации не отобразился",20);
        waitForElementAndSendKeys(USER_NAME_INPUT,login,"Не удалось ввести имя пользователя",5);
        waitForElementAndSendKeys(USER_PASSWORD_INPUT,password,"Не удалось ввести пароль", 5);
        if (getElementValue(LOGIN_BUTTON,"clickable").equals("true")){
            waitForElementAndClick(LOGIN_BUTTON,"Не удалось нажать на кнопку авторизации",5);
        } else {
            throw new AssertionError("После ввода логина и пароля кнопка входа осталась неактивной");
        }

    }
}
