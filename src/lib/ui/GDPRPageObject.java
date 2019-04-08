package lib.ui;

import io.appium.java_client.AppiumDriver;

public class GDPRPageObject extends MainPageObject {
    public GDPRPageObject(AppiumDriver driver){super(driver);}

    private static final String
            SPLASH_SCREEN = "xpath:/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout",
            SYSTEM_PERMISSION = "id:com.android.packageinstaller:id/permission_message",
            ALLOW_BUTTON = "id:com.android.packageinstaller:id/permission_allow_button",
            GDPR_COUNTRY_SPINNER = "id:spinnerCountries",
            GDPR_COUNTRY = "id:countryTitle",
            GDPR_TEXT = "id:textViewGDPR",
            GDPR_CANCEL_BUTTON = "id:buttonCancel",
            GDPR_AGREE_BUTTON = "id:buttonAgree";

    public void confirmGDPR(){
        this.waitForElementNotPresent(SPLASH_SCREEN,"Экран с лого отображался более 15 сек.",15);
        if (this.isElementPresent(SYSTEM_PERMISSION)){
            this.waitForElementAndClick(ALLOW_BUTTON,"Кнопка согласия на доступ МП к геолокации не найдена",3);
        }
        this.waitForElementPresent(GDPR_COUNTRY_SPINNER,"Поле выбора страны в окне GDPR не найдено",10);
        this.waitForElementPresent(GDPR_COUNTRY,"Поле c выбранной страной в окне GDPR не найдено",2);
        this.waitForElementPresent(GDPR_TEXT,"Текст GDPR не найден",2);
        this.waitForElementPresent(GDPR_CANCEL_BUTTON,"Кнопка `Отказаться` в окне GDPR не найдена",2);
        this.waitForElementAndClick(GDPR_AGREE_BUTTON,"Кнопка `Разрешить` в окне GDPR не найдена",2);
    }
}
