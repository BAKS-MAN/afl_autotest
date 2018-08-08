package lib.ui.Booking;

import io.appium.java_client.AppiumDriver;
import lib.ui.MainPageObject;
import lib.ui.MenuPageObject;

public class SummaryPageObject extends MainPageObject {
    public SummaryPageObject (AppiumDriver driver){super(driver);}

    protected static final String
            BOOKING_SUMMARY_CONTENT = "id:llBookingSummary",
            FLIGHT_LAYOUT = "id:tvFlightDirection",
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
            PASSENGER_TYPE = "id:tvPassengerHeader",
            PASSENGER_NAME = "id:tvPassengerName",
            PASSENGER_BIRTH_DATE = "id:tvPassengerBirthDate",
            PASSENGER_PASSPORT_NUMBER = "id:tvPassportNumber",
            BOOKING_PHONE = "id:tvPhone",
            BOOKING_EMAIL = "id:tvEmail",
            SUMMARY_LAYOUT = "id:booking_summary_fare_card_layout",
            TOTAL_PRICE = "id:tvTotalPrice",
            BASE_PRICE = "id:tvBasePrice",
            TAXES_CHARGES = "id:tvAdditional",
            BOOK_BUTTON = "id:btnBook";

    /*TEMPLATES METHODS */

    /*TEMPLATES METHODS */

    public void checkBookingSummaryScreen(){
        waitForElementPresent(BOOKING_SUMMARY_CONTENT,"Суммарная информация о бронировании не обнаружена",3);
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
        this.swipeUpToFindElement(PASSENGER_TYPE,"Не удалось добраться до информации о пассажире",5);
        waitForElementPresent(PASSENGER_TYPE,"Отсутствует информация о типе пассажира",3);
        waitForElementPresent(PASSENGER_NAME,"Отсутствует информация об имени пассажира",3);
        waitForElementPresent(PASSENGER_BIRTH_DATE,"Отсутствует информация о дате рождения пассажира",3);
        waitForElementAndClick(PASSENGER_TYPE,"Не удалось раскрыть блок с информацией о пассажире",3);
        waitForElementPresent(PASSENGER_PASSPORT_NUMBER,"Отсутствует информация о номере паспорта",3);
        waitForElementPresent(BOOKING_PHONE,"Отсутствует информация о номере телефона",3);
        waitForElementPresent(BOOKING_EMAIL,"Отсутствует информация об e-mail",3);
        this.swipeUpToFindElement(SUMMARY_LAYOUT,"Не удалось добраться до информации об итоговой стоимости брони",5);
        waitForElementPresent(SUMMARY_LAYOUT,"Блок с информацией об итоговой стоимости не найден",3);
        waitForElementPresent(TOTAL_PRICE,"Отсутствует информация об итоговой стоимости",3);
        swipeUpToFindElement(BASE_PRICE,"Отсутствует информация о базовом тарифе",3);
        waitForElementPresent(TAXES_CHARGES,"Отсутствует информация о таксах и сборах",3);
        this.swipeUpQuick();
        waitForElementPresent(BOOK_BUTTON,"Не найдена кнопка бронирования",3);
    }
    public void goToSummaryScreen(String origin_city, String destination_city, Boolean OneWay){
        PassengersPageObject PassengersPageObject = new PassengersPageObject(driver);

        PassengersPageObject.searchWithOnePassenger(origin_city,destination_city,OneWay);
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
        this.checkBookingSummaryScreen();
    }

    public void pressBookButton(){
        waitForElementAndClick(BOOK_BUTTON,"Кнопка перехода к экрану оплаты не найдена",2);
    }

}
