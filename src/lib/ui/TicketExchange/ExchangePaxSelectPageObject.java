package lib.ui.TicketExchange;

import io.appium.java_client.AppiumDriver;
import lib.ui.MainPageObject;

public class ExchangePaxSelectPageObject extends MainPageObject {
    public ExchangePaxSelectPageObject(AppiumDriver driver){super(driver);}

    protected static final String
            ALERT_TXT = "xpath://*[@resource-id = 'android:id/message'][contains(@text,'дополнительных услуг не производится.')]",
            PASSENGER_LIST = "id:passengers_list",
            PASSENGER_TYPE = "id:pax_number_and_type",
            PASSENGER_NAME= "id:pax_name",
            PASSENGER_SWITCH= "id:pax_switch",
            CONFIRM_BUTTON = "id:commit_btn",
            PASSENGER_SELECT_DIALOG = "id:message",
            DIALOG_OK_BUTTON = "id:button1",
            DIALOG_CANCEL_BUTTON = "id:button2";

    public void confirmPassengers(){
        if (this.isElementPresent(ALERT_TXT)){
            this.waitForElementAndClick(DIALOG_OK_BUTTON,"Кнопка закрытия алерта не найдена",3);
        }
        waitForElementPresent(PASSENGER_LIST,"Экран выбора пассажиров к обмену не отобразился",10);
        waitForElementPresent(PASSENGER_TYPE,"Не найдена информация о типе пассажира",3);
        waitForElementPresent(PASSENGER_NAME,"Не найдена информация об имени пассажира",3);
        waitForElementPresent(PASSENGER_SWITCH,"Не найден переключатель выбора пассажира",3);
        waitForElementAndClick(CONFIRM_BUTTON,"Не найдена кнопка подтверждения пассажиров",3);
        waitForElementPresent(PASSENGER_SELECT_DIALOG,"Диалоговое окно с подтверждением выбранных пассажиров не отобразилось",3);
        waitForElementPresent(DIALOG_CANCEL_BUTTON,"Не найдена кнопка отмены выбора пассажиров",3);
        waitForElementAndClick(DIALOG_OK_BUTTON,"Не найдена кнопка подтверждения выбора пассажиров",3);
    }
}
