package lib.ui.Reservation;

import io.appium.java_client.AppiumDriver;
import lib.ui.MainPageObject;

public class ReservationInfoPageObject extends MainPageObject {
    ReservationInfoPageObject(AppiumDriver driver){super(driver);}

    protected static final String
            FLIGHT_LAYOUT = "id:tvFlightDirection",
            FLIGHT_NUMBER = "id:tvFlightNumber",
            FLIGHT_MODEL = "id:tvAirplane",
            FLIGHT_DATE = "id:tvFlightDate",
            FLIGHT_DEPARTURE_CITY = "id:tvFlightFrom",
            FLIGHT_ARRIVAL_CITY = "id:tvFlightTo",
            FLIGHT_DEPARTURE_TIME = "id:tvFlightTime",
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
            BOOKING_EMAIL = "id:rtvEmail",
            RESERVATION_MENU_BUTTON = "id:btnMenu";

    /*TEMPLATES METHODS */

    /*TEMPLATES METHODS */
}
