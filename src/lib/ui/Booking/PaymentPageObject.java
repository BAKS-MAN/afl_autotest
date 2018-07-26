package lib.ui.Booking;

import io.appium.java_client.AppiumDriver;
import lib.ui.MainPageObject;
import lib.ui.MenuPageObject;

public class PaymentPageObject extends MainPageObject {
    public PaymentPageObject(AppiumDriver driver){super(driver);}

    protected static final String
            ALERT_TITLE = "id:android:id/alertTitle",
            ALERT_OK_BUTTON = "id:android:id/button1",
            PAYMENT_SCREEN_CONTENT = "id:ru.aeroflot.afltest:id/payment_fragment_container",
            FLIGHT_LAYOUT = "id:ru.aeroflot.afltest:id/booking_payment_flights_layout",
            FLIGHT_DATE = "id:ru.aeroflot.afltest:id/tvFlightDate",
            FLIGHT_DEPARTURE_CITY = "id:ru.aeroflot.afltest:id/tvFlightFrom",
            FLIGHT_ARRIVAL_CITY = "id:ru.aeroflot.afltest:id/tvFlightTo",
            FLIGHT_DEPARTURE_TIME = "id:ru.aeroflot.afltest:id/tvFlightTime",
            FLIGHT_INFO_DEPARTURE_TIME = "id:ru.aeroflot.afltest:id/tvTimeSource",
            FLIGHT_INFO_DEPARTURE_CITY = "id:ru.aeroflot.afltest:id/tvCitySource",
            FLIGHT_INFO_DEPARTURE_DATE = "id:ru.aeroflot.afltest:id/tvDateSource",
            FLIGHT_INFO_ARRIVAL_TIME= "id:ru.aeroflot.afltest:id/tvTimeDest",
            FLIGHT_INFO_ARRIVAL_CITY = "id:ru.aeroflot.afltest:id/tvCityDest",
            FLIGHT_INFO_ARRIVAL_DATE = "id:ru.aeroflot.afltest:id/tvDateDest",
            FLIGHT_INFO_DURATION = "id:ru.aeroflot.afltest:id/tvDuration",
            SUMMARY_LAYOUT = "id:ru.aeroflot.afltest:id/booking_summary_fare_card_layout",
            TOTAL_PRICE = "id:ru.aeroflot.afltest:id/tvTotalPrice",
            BASE_PRICE = "id:ru.aeroflot.afltest:id/tvBasePrice",
            TAXES_CHARGES = "id:ru.aeroflot.afltest:id/tvAdditional",
            BOOKING_CODE = "id:ru.aeroflot.afltest:id/tvBookingCode",  //Text = Код бронирования: LKJPDE
            INSURANCE_LAYOUT = "id:ru.aeroflot.afltest:id/llInsurance",
            INSURANCE_DESCRIPTION_BUTTON = "id:ru.aeroflot.afltest:id/btnInsuranceDescription",
            INSURANCE_COST = "id:ru.aeroflot.afltest:id/tvInsuranceCost",
            INSURANCE_SWITCH = "id:ru.aeroflot.afltest:id/swInsuranceInOrder",
            INSURANCE_CONDITIONS_LINK = "id:ru.aeroflot.afltest:id/tvInsuranceConditions",
            INSURANCE_RULES_LINK = "id:ru.aeroflot.afltest:id/tvInsuranceRules",
            PAYMENT_SELECTOR = "id:ru.aeroflot.afltest:id/payment_instruments_spinner",
            PAYMENT_SELECTOR_TPL = "xpath://*[@resource-id = 'ru.aeroflot.afltest:id/text1'][@text = '{PAYMENT_METHOD}']",
            CARD_NUMBER_FIELD = "id:ru.aeroflot.afltest:id/payment_pan_input",
            CARD_HOLDER_FIELD = "id:ru.aeroflot.afltest:id/payment_cardholder_input",
            CARD_EXPIRY_FIELD = "id:ru.aeroflot.afltest:id/payment_expiry_input",
            CARD_CVC_FIELD = "id:ru.aeroflot.afltest:id/payment_cvc_input",
            VGC_NUMBER_FIELD = "id:ru.aeroflot.afltest:id/payment_vgc_number",
            VGC_CODE_FIELD = "id:ru.aeroflot.afltest:id/payment_vgc_code",
            VGC_CHECK_BUTTON = "id:ru.aeroflot.afltest:id/payment_vgc_btn_check",
            VGC_RESET_BUTTON = "id:ru.aeroflot.afltest:id/payment_vgc_btn_reset",
            GO_TO_SITE_BUTTON = "id:ru.aeroflot.afltest:id/tvPaymentButtonsGoToSite",
            PAY_BUTTON = "id:ru.aeroflot.afltest:id/payment_pay_btn";

    /*TEMPLATES METHODS */
    private static String getPaymentMethod(String payment_method){
        return PAYMENT_SELECTOR_TPL.replace("{PAYMENT_METHOD}", payment_method);
    }
    /*TEMPLATES METHODS */

    public void checkAlertAndClose(String alert_title){
        waitForElementPresent(ALERT_TITLE,"Алерт с результатом выполнения операции не отобразился",60);
        if (this.getElementText(ALERT_TITLE).equals(alert_title)){
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
        waitForElementPresent(BASE_PRICE,"Отсутствует информация о базовом тарифе",3);
        waitForElementPresent(TAXES_CHARGES,"Отсутствует информация о таксах и сборах",3);
        waitForElementPresent(BOOKING_CODE,"Отсутствует информация о полученном коде бронирования",3);
        waitForElementPresent(INSURANCE_LAYOUT,"Отсутствует информация о полетной страховке",3);
        waitForElementPresent(INSURANCE_DESCRIPTION_BUTTON,"Отсутствует кнопка перехода к подробностям полетной страховки",3);
        waitForElementPresent(INSURANCE_COST,"Отсутствует информация о цене полетной страховки",3);
        swipeUpToFindElement(INSURANCE_SWITCH,"Не найден переключатель страховки в заказе",3);
        waitForElementPresent(INSURANCE_CONDITIONS_LINK,"Отсутствует ссылка на покрытия и условия полетной страховки",3);
        waitForElementPresent(INSURANCE_RULES_LINK,"Отсутствует ссылка на подробные правила страхования",3);
        waitForElementPresent(PAYMENT_SELECTOR,"Отсутствует поле выбора способа оплаты",3);
        waitForElementPresent(CARD_NUMBER_FIELD,"Отсутствует поле ввода номера карты",3);
        waitForElementPresent(CARD_HOLDER_FIELD,"Отсутствует поле ввода владельца карты",3);
        waitForElementPresent(CARD_EXPIRY_FIELD,"Отсутствует поле ввода срока действия карты",3);
        waitForElementPresent(CARD_CVC_FIELD,"Отсутствует поле ввода CVC кода карты",3);
        waitForElementPresent(GO_TO_SITE_BUTTON,"Отсутствует ссылка на другой способ оплаты",3);
        swipeUpQuick();
        waitForElementPresent(PAY_BUTTON,"Не найдена кнопка оплаты бронирования",3);
    }
    public void goToPaymentScreen(String origin_city, String destination_city, Boolean OneWay){
        MenuPageObject MenuPageObject = new MenuPageObject(driver);
        BookingPageObject BookingPageObject = new BookingPageObject(driver);
        FlightDetailsPageObject FlightDetailsPageObject = new FlightDetailsPageObject(driver);
        PassengersPageObject PassengersPageObject = new PassengersPageObject(driver);
        SummaryPageObject SummaryPageObject = new SummaryPageObject(driver);

        MenuPageObject.openBookingScreen();
        BookingPageObject.typeOriginCityAndSelect(origin_city);
        BookingPageObject.typeDestinationCityAndSelect(destination_city);
        if (OneWay){
            BookingPageObject.setOneWayDate();
        } else {
            BookingPageObject.setDateFromAndTo();
        }
        BookingPageObject.swipeUpQuick();
        BookingPageObject.startSearch();
        FlightDetailsPageObject.selectSeatsClassAndFareType("Эконом","Премиум");
        if (!OneWay){
            FlightDetailsPageObject.selectSeatsClassAndFareType("Эконом","Премиум");
        }
        PassengersPageObject.checkEditOnePassengerScreen();
        PassengersPageObject.editPassengerName("Petr");
        PassengersPageObject.editPassengerLastName("Test");
        PassengersPageObject.editPassengerBirthDate("1987");
        PassengersPageObject.editPassengerSex("Мужской");
        PassengersPageObject.selectCitizenCountry("Россия");
        PassengersPageObject.selectPassportType("Заграничный паспорт");
        PassengersPageObject.selectPassportCountry("Россия");
        PassengersPageObject.editPassportNumber("5004698547");
        PassengersPageObject.editPassportIssueDate("2022");
        PassengersPageObject.editPhoneNumber("790412365789");
        PassengersPageObject.editEmailAddress("test@test.com");
        PassengersPageObject.pressNextButton();
        SummaryPageObject.checkBookingSummaryScreen();
        SummaryPageObject.pressBookButton();
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
