package lib.ui.TicketReturn;

import io.appium.java_client.AppiumDriver;
import lib.ui.MainPageObject;

public class TicketReturnPageObject extends MainPageObject {
    public TicketReturnPageObject(AppiumDriver driver){super(driver);}

    protected static final String
            RETURN_TICKET_SCREEN = "id:refund_fragment_container",
            PASSENGER_TYPE = "id:pax_number_and_type",
            PASSENGER_NAME= "id:pax_name",
            PASSENGER_SWITCH= "id:pax_switch",
            CONFIRM_BUTTON = "id:commit_btn",
            PASSENGER_SELECT_DIALOG = "id:message",
            DIALOG_OK_BUTTON = "id:button1",
            DIALOG_CANCEL_BUTTON = "id:button2",
            REFUND_DETAILS_BASE = "id:refund_details_base",
            REFUND_DETAILS_TAXES = "id:refund_details_taxes",
            REFUND_DETAILS_FEE = "id:refund_details_fee",
            REFUND_DETAILS_TOTAL = "id:refund_details_total",
            REFUND_BUTTON = "id:refund_btn",
            REFUND_MESSAGE = "xpath://*[@resource-id = 'android:id/message'][@text = 'Бронь успешно отменена. Денежные средства поступят вам на счет в течение 40 дней.']";

    public void ticketRefund(){
        waitForElementPresent(RETURN_TICKET_SCREEN,"Экран выбора пассажиров к возврату не отобразился",10);
        waitForElementPresent(PASSENGER_TYPE,"Не найдена информация о типе пассажира",3);
        waitForElementPresent(PASSENGER_NAME,"Не найдена информация об имени пассажира",3);
        waitForElementPresent(PASSENGER_SWITCH,"Не найден переключатель выбора пассажира",3);
        waitForElementAndClick(CONFIRM_BUTTON,"Не найдена кнопка подтверждения пассажиров",3);
        waitForElementPresent(PASSENGER_SELECT_DIALOG,"Диалоговое окно с подтверждением выбранных пассажиров не отобразилось",3);
        waitForElementPresent(DIALOG_CANCEL_BUTTON,"Не найдена кнопка отмены выбора пассажиров",3);
        waitForElementAndClick(DIALOG_OK_BUTTON,"Не найдена кнопка подтверждения выбора пассажиров",3);
        waitForElementPresent(REFUND_DETAILS_BASE,"Не найдена информация о базовом тарифе",3);
        waitForElementPresent(REFUND_DETAILS_TAXES,"Не найдена информация о таксах и сборах",3);
        waitForElementPresent(REFUND_DETAILS_FEE,"Не найдена информация о штрафе за возврат",3);
        waitForElementPresent(REFUND_DETAILS_TOTAL,"Не найдена информация о сумме возврата",3);
        waitForElementAndClick(REFUND_BUTTON,"Не найдена кнопка подтверждения возврата",3);
        waitForElementPresent(REFUND_MESSAGE,"Сообщение об успешном возврате в не отобразилось",20);
        waitForElementAndClick(DIALOG_OK_BUTTON,"Не найдена кнопка закрытия сообщения об успешном возврате",3);
        waitForElementNotPresent(REFUND_DETAILS_BASE,"Экран возврата продолжил отображаться после возврата билета",3);
    }

}
