package lib.ui.Booking;

import io.appium.java_client.AppiumDriver;
import lib.ui.MainPageObject;

public class PaymentPageObject extends MainPageObject {
    public PaymentPageObject(AppiumDriver driver){super(driver);}

    protected static final String
            ALERT_TITLE = "id:android:id/alertTitle",
            ALERT_OK_BUTTON = "id:android:id/button1",
            PAYMENT_SCREEN_CONTENT = "id:payment_fragment_container",
            FLIGHT_LAYOUT = "id:booking_payment_flights_layout",
            FLIGHT_DATE = "id:tvFlightDate",
            FLIGHT_DEPARTURE_CITY = "id:tvFlightFrom",
            FLIGHT_ARRIVAL_CITY = "id:tvFlightTo",
            FLIGHT_DEPARTURE_TIME = "id:tvFlightTime",
            FLIGHT_INFO_DEPARTURE_TIME = "id:tvTimeSource",
            FLIGHT_INFO_DEPARTURE_CITY = "id:tvCitySource",
            FLIGHT_INFO_DEPARTURE_DATE = "id:tvDateSource",
            FLIGHT_INFO_ARRIVAL_TIME= "id:tvTimeDest",
            FLIGHT_INFO_ARRIVAL_CITY = "id:tvCityDest",
            FLIGHT_INFO_ARRIVAL_DATE = "id:tvDateDest",
            FLIGHT_INFO_DURATION = "id:tvDuration",
            SUMMARY_LAYOUT = "id:booking_summary_fare_card_layout",
            TOTAL_PRICE = "id:tvTotalPrice",
            BASE_PRICE = "id:tvBasePrice",
            TAXES_CHARGES = "id:tvAdditional",
            BOOKING_CODE = "id:tvBookingCode",
            GOOGLE_PAY_BUTTON = "id:btnGooglePay",
            PAYMENT_SELECTOR = "id:payment_instruments_spinner",
            PAYMENT_SELECTOR_TPL = "xpath://*[contains(@resource-id,'text1')][@text = '{PAYMENT_METHOD}']",
            CARD_NUMBER_FIELD = "id:payment_pan_input",
            CARD_HOLDER_FIELD = "id:payment_cardholder_input",
            CARD_EXPIRY_FIELD = "id:payment_expiry_input",
            CARD_CVC_FIELD = "id:payment_cvc_input",
            VGC_NUMBER_FIELD = "id:payment_vgc_number",
            VGC_CODE_FIELD = "id:payment_vgc_code",
            VGC_CHECK_BUTTON = "id:payment_vgc_btn_check",
            VGC_RESET_BUTTON = "id:payment_vgc_btn_reset",
            GO_TO_SITE_BUTTON = "id:tvPaymentButtonsGoToSite",
            PAY_BUTTON = "id:payment_pay_btn";

    /*TEMPLATES METHODS */
    private static String getPaymentMethod(String payment_method){
        return PAYMENT_SELECTOR_TPL.replace("{PAYMENT_METHOD}", payment_method);
    }
    /*TEMPLATES METHODS */

    public void checkAlertAndClose(String alert_title){
        waitForElementPresent(ALERT_TITLE,"Алерт с результатом выполнения операции не отобразился",60);
        if (this.getElementValue(ALERT_TITLE,"text").equals(alert_title)){
            this.waitForElementAndClick(ALERT_OK_BUTTON,"Кнопка закрытия алерта не найдена",40);
        } else {
            throw new AssertionError("Алерт '"+alert_title+"' не был отображен");
        }
    }
    public void checkPaymentScreen(){
        checkAlertAndClose("Бронирование успешно произведено");
        waitForElementPresent(PAYMENT_SCREEN_CONTENT,"Суммарная информация о бронировании не обнаружена",50);
        waitForElementPresent(FLIGHT_LAYOUT,"Блок с информацией о перелете не найден",3);
        waitForElementPresent(FLIGHT_DATE,"Отсутствует информация о дате вылета",3);
        waitForElementPresent(FLIGHT_DEPARTURE_CITY,"Отсутствует информация о городе вылета",3);
        waitForElementPresent(FLIGHT_ARRIVAL_CITY,"Отсутствует информация о городе прилета",3);
        waitForElementPresent(FLIGHT_DEPARTURE_TIME,"Отсутствует информация о времени вылета",3);
        waitForElementAndClick(FLIGHT_LAYOUT,"Не удалось раскрыть блок с информацией о перелете",2);
        waitForElementPresent(FLIGHT_INFO_DEPARTURE_TIME,"Отсутствует информация о времени вылета",3);
        waitForElementPresent(FLIGHT_INFO_DEPARTURE_CITY,"Отсутствует информация о городе вылета",3);
        waitForElementPresent(FLIGHT_INFO_DEPARTURE_DATE,"Отсутствует информация о дате вылета",3);
        waitForElementPresent(FLIGHT_INFO_ARRIVAL_TIME,"Отсутствует информация о времени прилета",3);
        waitForElementPresent(FLIGHT_INFO_ARRIVAL_CITY,"Отсутствует информация о городе прилета",3);
        waitForElementPresent(FLIGHT_INFO_ARRIVAL_DATE,"Отсутствует информация о дате прилета",3);
        waitForElementPresent(FLIGHT_INFO_DURATION,"Отсутствует информация о продолжительности полета",3);
        waitForElementPresent(SUMMARY_LAYOUT,"Блок с информацией об итоговой стоимости не найден",3);
        waitForElementPresent(TOTAL_PRICE,"Отсутствует информация об итоговой стоимости",3);
        swipeUpToFindElement(BASE_PRICE,"Отсутствует информация о базовом тарифе",3);
        waitForElementPresent(TAXES_CHARGES,"Отсутствует информация о таксах и сборах",3);
        waitForElementPresent(BOOKING_CODE,"Отсутствует информация о полученном коде бронирования",3);
        waitForElementPresent(GOOGLE_PAY_BUTTON,"Кнопка оплаты с помощью Google Pay не найдена",3);
        swipeUpToFindElement(PAYMENT_SELECTOR,"Отсутствует поле выбора способа оплаты",3);
        waitForElementPresent(CARD_NUMBER_FIELD,"Отсутствует поле ввода номера карты",3);
        waitForElementPresent(CARD_HOLDER_FIELD,"Отсутствует поле ввода владельца карты",3);
        waitForElementPresent(CARD_EXPIRY_FIELD,"Отсутствует поле ввода срока действия карты",3);
        waitForElementPresent(CARD_CVC_FIELD,"Отсутствует поле ввода CVC кода карты",3);
        waitForElementPresent(GO_TO_SITE_BUTTON,"Отсутствует ссылка на другой способ оплаты",3);
        swipeUpQuick();
        waitForElementPresent(PAY_BUTTON,"Не найдена кнопка оплаты бронирования",3);
    }
    public void goToPaymentScreen(String origin_city, String destination_city, Boolean OneWay){
        EssPageObject EssPageObject = new EssPageObject(driver);

        EssPageObject.goToEssScreen(origin_city,destination_city,OneWay);
        EssPageObject.pressPayButton();
        this.checkPaymentScreen();
    }

    public void goToPaymentScreenWithEss(String origin_city, String destination_city, Boolean OneWay){
        EssPageObject EssPageObject = new EssPageObject(driver);

        EssPageObject.goToEssScreen(origin_city,destination_city,OneWay);
        EssPageObject.selectAllEss();
        EssPageObject.pressPayButton();
        this.checkPaymentScreen();
    }

    public void selectGiftCertificateToPay(){
        this.waitForElementAndClick(PAYMENT_SELECTOR,"Отсутствует поле выбора способа оплаты",5);
        String payment_method = "Подарочный сертификат";
        String payment_method_xpath = getPaymentMethod(payment_method);
        this.waitForElementAndClick(payment_method_xpath,"Способ оплаты '"+payment_method+"' не найден",5);
        this.waitForElementPresent(VGC_NUMBER_FIELD,"Не найдено поле ввода номера ВПС",3);
        this.waitForElementPresent(VGC_CODE_FIELD,"Не найдено поле ввода кода ВПС",3);
        this.waitForElementPresent(VGC_CHECK_BUTTON,"Не найдена кнопка валидации ВПС",3);
        this.waitForElementPresent(VGC_RESET_BUTTON,"Не найдена сброса ВПС",3);
    }
    public void selectCardToPay(){
        this.waitForElementAndClick(PAYMENT_SELECTOR,"Отсутствует поле выбора способа оплаты",5);
        String payment_method = "Банковской картой";
        String payment_method_xpath = getPaymentMethod(payment_method);
        this.waitForElementAndClick(payment_method_xpath,"Способ оплаты '"+payment_method+"' не найден",5);
        this.waitForElementPresent(CARD_NUMBER_FIELD,"Отсутствует поле ввода номера карты",5);
    }
    public void fillCardPaymentData(String card_number, String expiry_date, String CVC){
        this.swipeUpToFindElement(PAYMENT_SELECTOR,"Не удалось пролистать до блока ввода платежных данных",5);
        waitForElementAndSendKeys(CARD_NUMBER_FIELD,card_number,"Отсутствует поле ввода номера карты",3);
        waitForElementAndSendKeys(CARD_HOLDER_FIELD,"Test Testov","Отсутствует поле ввода владельца карты",3);
        waitForElementAndSendKeys(CARD_EXPIRY_FIELD,expiry_date,"Отсутствует поле ввода срока действия карты",3);
        waitForElementAndSendKeys(CARD_CVC_FIELD,CVC,"Отсутствует поле ввода CVC кода карты",3);
        waitForElementAndClick(CARD_EXPIRY_FIELD,"Смена фокуса на другое поле не удалась",3);
    }

    public void pressPayButton(){
        waitForElementAndClick(PAY_BUTTON,"Не найдена кнопка оплаты бронирования",3);
        checkAlertAndClose("Оплата успешно произведена");
    }
}
