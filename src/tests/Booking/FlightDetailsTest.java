package tests.Booking;

import lib.CoreTestCase;
import lib.ui.Booking.FlightDetailsPageObject;
import org.junit.Test;

public class FlightDetailsTest extends CoreTestCase {


    @Test
    public void testSelectOneWayFare(){
        FlightDetailsPageObject FlightDetailsPageObject = new FlightDetailsPageObject(driver);

        FlightDetailsPageObject.searchFlights("Москва","Берлин",true);
        FlightDetailsPageObject.selectSeatsClassAndFareType("Эконом","Премиум");
    }

    @Test
    public void testSelectRoundTripFare(){
        FlightDetailsPageObject FlightDetailsPageObject = new FlightDetailsPageObject(driver);

        FlightDetailsPageObject.searchFlights("Москва","Берлин",false);
        FlightDetailsPageObject.selectSeatsClassAndFareType("Эконом","Премиум");
        FlightDetailsPageObject.selectSeatsClassAndFareType("Эконом","Премиум");
    }
}
