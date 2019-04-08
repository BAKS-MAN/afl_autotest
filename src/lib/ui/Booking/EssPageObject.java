package lib.ui.Booking;

import io.appium.java_client.AppiumDriver;
import lib.ui.MainPageObject;

public class EssPageObject extends MainPageObject {
    public EssPageObject (AppiumDriver driver){super(driver);}

    protected static final String
            INSURANCE_TOTAL_PRICE = "id:tvInsuranceTotalPrice",
            TRANSPORT_TOTAL_PRICE = "id:tvTransportTotalPrice",
            FLIGHT_INSURANCE_TITLE = "id:tvFlightInsuranceTitle",
            FLIGHT_INSURANCE_PRICE = "id:tvAllPassengersPrice",
            FLIGHT_INSURANCE_SELECT = "id:switchAllPassengers",
            FLIGHT_INSURANCE_CONDITIONS = "id:tvInsuranceConditions",
            FLIGHT_INSURANCE_RULES = "id:tvInsuranceRules",
            PASSENGER_SELECT_SWITCH = "id:switchPassenger",
            MEDICAL_INSURANCE_MENU = "id:llInsuranceMedical",
            MEDICAL_INSURANCE_DATE_FROM = "id:tlDateFrom",
            MEDICAL_INSURANCE_DATE_TO = "id:tlDateTo",
            MEDICAL_INSURANCE_SELECT_TYPE= "id:spinnerInsuranceType",
            MEDICAL_INSURANCE_PASSENGER_NAME = "id:passengerTitle",
            MEDICAL_INSURANCE_PASSENGER_PRICE = "id:tvPassengerPrice",
//            MEDICAL_INSURANCE_CONDITIONS = "id:tvMedicalInsuranceConditions",
            MEDICAL_INSURANCE_RULES = "id:tvMedicalInsuranceRules",
            SPORT_INSURANCE = "xpath://android.widget.ListView/android.widget.TextView[2]",
            AEROEXPRESS_MENU = "id:llAeroexpress",
            AEROEXPRESS_DIRECTION = "id:tvDirection",
            AEROEXPRESS_DATE= "id:tlDate",
            AEROEXPRESS_PASSENGER_NAME = "id:passengerTitle",
            AEROEXPRESS_PASSENGER_PRICE = "id:tvPassengerPrice",
            AEROEXPRESS_SCHEDULE = "id:tvTrainsSchedule",
            BOOKING_SUMMARY = "id:essSummaryFareCardLayout",
            SUMMARY_PRICE = "id:tvTotalPrice",
            SUMMARY_DETAILS = "id:llDetails",
            PAY_BUTTON = "id:btnPay";


    public void checkEssScreen() {
        waitForElementAndClick(INSURANCE_TOTAL_PRICE,"Блок выбора страховки не найден",40);
        waitForElementPresent(FLIGHT_INSURANCE_TITLE, "Информация о полетной страховке не отобразилась", 3);
        waitForElementPresent(FLIGHT_INSURANCE_PRICE, "Стоимость полетной страховки не отобразилась", 3);
        waitForElementPresent(FLIGHT_INSURANCE_SELECT, "Тумблер включения полетной страховки не найден", 3);
        waitForElementPresent(FLIGHT_INSURANCE_CONDITIONS, "Не найдена ссылка на условия полетной страховки", 3);
        waitForElementPresent(FLIGHT_INSURANCE_RULES, "Не найдена ссылка на правила страхования", 3);
        waitForElementPresent(MEDICAL_INSURANCE_MENU, "Информация о медицинской страховке не отобразилась", 3);
        waitForElementPresent(MEDICAL_INSURANCE_DATE_FROM, "Информация о дате начала медицинской страховки не отобразилась", 3);
        waitForElementPresent(MEDICAL_INSURANCE_DATE_TO, "Информация о дате окончания медицинской страховки не отобразилась", 3);
        waitForElementPresent(MEDICAL_INSURANCE_SELECT_TYPE, "Поле выбора типа медицинской страховки не отобразилось", 3);
        waitForElementPresent(MEDICAL_INSURANCE_PASSENGER_NAME, "Информация о пассажире для медицинской страховки не отобразилась", 3);
        waitForElementPresent(MEDICAL_INSURANCE_PASSENGER_PRICE, "Информация о цене медицинской страховки не отобразилась", 3);
        waitForElementPresent(PASSENGER_SELECT_SWITCH, "Тумблер добавления пассажира в медицинскую страховку не найден", 3);
        waitForElementPresent(MEDICAL_INSURANCE_RULES, "Не найдена ссылка на правила медицинского страхования", 3);
        waitForElementAndClick(INSURANCE_TOTAL_PRICE,"Не удалось закрыть блок выбора страховки",3);
        waitForElementAndClick(TRANSPORT_TOTAL_PRICE, "Не найден блок с транспортными услугами", 3);
        waitForElementPresent(AEROEXPRESS_MENU, "Информация об аэроэкспрессе не отобразилась", 3);
        waitForElementPresent(AEROEXPRESS_DIRECTION, "Информация о направлении аэроэкспресса не отобразилась", 3);
        waitForElementPresent(AEROEXPRESS_DATE, "Информация о дате поездки на аэроэкспрессе не отобразилась", 3);
        waitForElementPresent(AEROEXPRESS_PASSENGER_NAME, "Информация о пассажире аэроэкспресса отобразилась", 3);
        waitForElementPresent(AEROEXPRESS_PASSENGER_PRICE, "Информация о цене аэроэкспресса не отобразилась", 3);
        waitForElementPresent(PASSENGER_SELECT_SWITCH, "Тумблер добавления аэроэкспресса для пассажира не найден", 3);
        waitForElementPresent(AEROEXPRESS_SCHEDULE, "Информация о расписании движения аэроэкспресса не отобразилась", 3);
        waitForElementAndClick(TRANSPORT_TOTAL_PRICE, "Не удалось закрыть блок выбора транспортных услуг", 3);
        waitForElementPresent(PAY_BUTTON, "Кнопка перехода к оплате бронирования не найдена", 3);
    }

    public void goToEssScreen(String origin_city, String destination_city, Boolean OneWay){
        SummaryPageObject SummaryPageObject = new SummaryPageObject(driver);

        SummaryPageObject.goToSummaryScreen(origin_city,destination_city,OneWay);
        SummaryPageObject.pressBookButton();
        this.checkEssScreen();
    }

    public void selectAllInsurance(){
        waitForElementAndClick(INSURANCE_TOTAL_PRICE,"Не удалось раскрыть блок выбора страховки",40);
        waitForElementAndClick(FLIGHT_INSURANCE_SELECT, "Тумблер включения полетной страховки не найден", 3);
        waitForElementAndClick(MEDICAL_INSURANCE_SELECT_TYPE, "Поле выбора типа медицинской страховки не найдено", 3);
        waitForElementAndClick(SPORT_INSURANCE,"Не удалось выбрать спортивную страховку",2);
        waitForElementAndClick(PASSENGER_SELECT_SWITCH, "Тумблер добавления пассажира в медицинскую страховку не найден", 3);
        waitForElementAndClick(INSURANCE_TOTAL_PRICE,"Не удалось свернуть блок выбора страховки",40);
    }

    public void selectAeroexpress(){
        waitForElementAndClick(TRANSPORT_TOTAL_PRICE, "Не удалось раскрыть блок выбора транспортных услуг", 3);
        waitForElementAndClick(PASSENGER_SELECT_SWITCH, "Тумблер добавления аэроэкспресса для пассажира не найден", 3);
        waitForElementAndClick(TRANSPORT_TOTAL_PRICE, "Не удалось свернуть блок выбора транспортных услуг", 3);
    }

    public void selectAllEss() {
        selectAllInsurance();
        selectAeroexpress();
        waitForElementPresent(BOOKING_SUMMARY, "Блок с информацией о стоимости выбранных дополнительных услуг не найден", 3);
        waitForElementPresent(SUMMARY_PRICE, "Общая стоимость выбранных дополнительных услуг не отобразилась", 3);
        waitForElementPresent(SUMMARY_DETAILS, "Информация о выбранных дополнительных услугах не отобразилась", 3);

    }
        public void pressPayButton(){
        waitForElementAndClick(PAY_BUTTON,"Кнопка перехода к экрану оплаты не найдена",2);
    }

}
