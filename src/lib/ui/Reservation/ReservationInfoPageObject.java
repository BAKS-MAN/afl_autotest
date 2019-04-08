package lib.ui.Reservation;

import io.appium.java_client.AppiumDriver;
import lib.ui.LoginPageObject;
import lib.ui.MainPageObject;
import lib.ui.TicketExchange.ExchangePaxSelectPageObject;
import lib.ui.TicketReturn.TicketReturnPageObject;

public class ReservationInfoPageObject extends MainPageObject {
    public ReservationInfoPageObject(AppiumDriver driver){super(driver);}

    protected static final String
            ADD_TO_WALLET_BUTTON = "id:layoutWallet",
            FLIGHT_LAYOUT = "id:tvFlightDirection",
            FLIGHT_DATE = "id:tvFlightDate",
            FLIGHT_DEPARTURE_CITY = "id:tvFlightFrom",
            FLIGHT_ARRIVAL_CITY = "id:tvFlightTo",
            FLIGHT_DEPARTURE_TIME = "id:tvFlightTime",
            FLIGHT_NUMBER = "id:tvFlightNumber",
            FLIGHT_MODEL = "id:tvAirplane",
            FLIGHT_INFO_DEPARTURE_TIME = "id:tvTimeSource",
            FLIGHT_INFO_DEPARTURE_CITY = "id:tvCitySource",
            FLIGHT_INFO_DEPARTURE_AIRPORT = "id:tvAirportSource",
            FLIGHT_INFO_DEPARTURE_DATE = "id:tvDateSource",
            FLIGHT_INFO_ARRIVAL_TIME= "id:tvTimeDest",
            FLIGHT_INFO_ARRIVAL_CITY = "id:tvCityDest",
            FLIGHT_INFO_ARRIVAL_AIRPORT = "id:tvAirportDest",
            FLIGHT_INFO_ARRIVAL_DATE = "id:tvDateDest",
            FLIGHT_INFO_DURATION = "id:tvDuration",
            TICKETS_INFO = "id:llTickets",
            PASSENGER_TYPE = "id:tvPassengerHeader",
            PASSENGER_NAME = "id:tvPassengerName",
            PASSENGER_BIRTH_DATE = "id:tvPassengerBirthDate",
            BOOKING_PHONE = "id:tvPhone",
            BOOKING_EMAIL = "id:tvEmail",
            SERVICE_CLASS_LAYOUT = "xpath://*[@class = 'android.widget.TextView'][@text = 'Информация о классе обслуживания']",
            ECONOMY_CLASS_BUTTON= "id:tvEconomy",
            COMFORT_CLASS_BUTTON = "id:tvComfort",
            BUSINESS_CLASS_BUTTON = "id:tvBusiness",
            ESS_INFO = "id:tvEssSummary",
            WEATHER_INFO = "id:llWeatherCard",
            RESERVATION_MENU_BUTTON = "xpath://*[contains(@resource-id,'btnMenu')]/*[@class = 'android.widget.ImageButton']",
            SELECT_MEAL_BUTTON = "id:menu_meal",
            SELECT_SEAT_BUTTON = "id:menu_seat",
            RETURN_TICKET_BUTTON = "id:menu_return_ticket",
            EXCHANGE_TICKET_BUTTON = "id:menu_change_ticket",
            UPGRADE_BY_MILES_BUTTON = "id:menu_upgrade_by_miles",
            UPGRADE_BY_VOUCHER_BUTTON = "id:menu_upgrade_by_voucher",
            CHECK_POSSIBILITY_BUTTON = "id:menu_check_the_possibility_of_increasing";

    /*TEMPLATES METHODS */

    /*TEMPLATES METHODS */

    public void checkReservationInfoScreen() {
        waitForElementPresent(ADD_TO_WALLET_BUTTON,"Кнопка добавления в Pass2U не найдена",35);
        waitForElementPresent(FLIGHT_LAYOUT,"Блок с информацией о перелете не найден",3);
        waitForElementPresent(FLIGHT_DATE,"Отсутствует информация о дате вылета",3);
        waitForElementPresent(FLIGHT_DEPARTURE_CITY,"Отсутствует информация о городе вылета",3);
        waitForElementPresent(FLIGHT_ARRIVAL_CITY,"Отсутствует информация о городе прилета",3);
        waitForElementPresent(FLIGHT_DEPARTURE_TIME,"Отсутствует информация о времени вылета",3);
        waitForElementAndClick(FLIGHT_LAYOUT,"Не удалось раскрыть блок с информацией о перелете",2);
        waitForElementPresent(FLIGHT_NUMBER,"Информация о номере рейса не найдена",5);
        waitForElementPresent(FLIGHT_MODEL,"Информация о модели борта не найдена",3);
        waitForElementPresent(FLIGHT_INFO_DEPARTURE_TIME,"Отсутствует информация о времени вылета",3);
        waitForElementPresent(FLIGHT_INFO_DEPARTURE_CITY,"Отсутствует информация о городе вылета",3);
        waitForElementPresent(FLIGHT_INFO_DEPARTURE_AIRPORT,"Информация об аэропорте вылета не найдена",2);
        waitForElementPresent(FLIGHT_INFO_DEPARTURE_DATE,"Отсутствует информация о дате вылета",3);
        waitForElementPresent(FLIGHT_INFO_ARRIVAL_TIME,"Отсутствует информация о времени прилета",3);
        waitForElementPresent(FLIGHT_INFO_ARRIVAL_CITY,"Отсутствует информация о городе прилета",3);
        waitForElementPresent(FLIGHT_INFO_ARRIVAL_AIRPORT,"Информация об аэропорте прилета не найдена",2);
        waitForElementPresent(FLIGHT_INFO_ARRIVAL_DATE,"Отсутствует информация о дате прилета",3);
        waitForElementPresent(FLIGHT_INFO_DURATION,"Отсутствует информация о продолжительности полета",3);
        waitForElementPresent(TICKETS_INFO,"Информация о номере билета не найдена",2);
        waitForElementPresent(PASSENGER_TYPE,"Отсутствует информация о типе пассажира",3);
        waitForElementPresent(PASSENGER_NAME,"Отсутствует информация об имени пассажира",3);
        waitForElementPresent(PASSENGER_BIRTH_DATE,"Отсутствует информация о дате рождения пассажира",3);
        swipeUpToFindElement(SERVICE_CLASS_LAYOUT,"Не удалось найти блок с информацией о классах обслуживания",3);
        waitForElementAndClick(SERVICE_CLASS_LAYOUT,"Не удалось раскрыть блок с информацией о классах обслуживания",2);
        swipeUpToFindElement(ECONOMY_CLASS_BUTTON, "Кнопка выбора эконом класса не найдена", 5);
        waitForElementPresent(COMFORT_CLASS_BUTTON,"Кнопка выбора комфорт класса не найдена",5);
        waitForElementPresent(BUSINESS_CLASS_BUTTON,"Кнопка выбора бизнес класса не найдена",5);
        swipeUpToFindElement(BOOKING_PHONE,"Отсутствует информация о номере телефона",3);
        waitForElementPresent(BOOKING_EMAIL,"Отсутствует информация об e-mail",3);
//        waitForElementPresent(ESS_INFO,"Отсутствует блок заказа дополнительых услуг",7);
//        swipeUpToFindElement(WEATHER_INFO,"Отсутствует информация о погоде",3);
        waitForElementPresent(RESERVATION_MENU_BUTTON,"Кнопка меню действий с бронированием не найдена",3);
    }

    public void selectMeal(){
        MealSelectPageObject MealSelectPageObject = new MealSelectPageObject(driver);
        waitForElementAndClick(RESERVATION_MENU_BUTTON,"Не удалось нажать на кнопку меню действий с бронированием",3);
        waitForElementAndClick(SELECT_MEAL_BUTTON,"Не найдена кнопка выбора питания",3);
        MealSelectPageObject.selectMealFromList();
    }

    public void selectSeat(){
        SeatSelectPageObject SeatSelectPageObject = new SeatSelectPageObject(driver);
        waitForElementAndClick(RESERVATION_MENU_BUTTON,"Не удалось нажать на кнопку меню действий с бронированием",3);
        waitForElementAndClick(SELECT_SEAT_BUTTON,"Не найдена кнопка выбора места",3);
        SeatSelectPageObject.findSeatAndConfirm();
    }

    public void returnTicket(){
        TicketReturnPageObject TicketReturnPageObject = new TicketReturnPageObject(driver);
        waitForElementAndClick(RESERVATION_MENU_BUTTON,"Не удалось нажать на кнопку меню действий с бронированием",3);
        waitForElementAndClick(RETURN_TICKET_BUTTON,"Не найдена кнопка возврата билета",3);
        TicketReturnPageObject.ticketRefund();
    }

    public void exchangeTicket(){
        waitForElementAndClick(RESERVATION_MENU_BUTTON,"Не удалось нажать на кнопку меню действий с бронированием",3);
        waitForElementAndClick(EXCHANGE_TICKET_BUTTON,"Не найдена кнопка обмена билета",3);
    }

    public void checkUpgradePossibility(){
        LoginPageObject LoginPageObject = new LoginPageObject(driver);

        waitForElementAndClick(RESERVATION_MENU_BUTTON,"Не удалось нажать на кнопку меню действий с бронированием",3);
        waitForElementAndClick(CHECK_POSSIBILITY_BUTTON,"Не найдена кнопка проверки возможности повышения",3);
        LoginPageObject.loginIntoAccount("1080010326", "Roger1101");
        waitForElementPresent(RESERVATION_MENU_BUTTON,"После авторизации не произошел возврат в подробности бронирования",15);
        waitForElementAndClick(RESERVATION_MENU_BUTTON,"Не удалось нажать на кнопку меню действий с бронированием",3);
        waitForElementNotPresent(CHECK_POSSIBILITY_BUTTON,"Кнопка проверки возможности повышения отображается после авторизации",3);
    }
}
