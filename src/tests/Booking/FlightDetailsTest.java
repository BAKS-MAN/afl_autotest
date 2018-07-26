package tests.Booking;

import lib.CoreTestCase;
import lib.ui.Booking.FlightDetailsPageObject;
import lib.ui.Booking.ResultsPageObject;
import org.junit.Test;

public class FlightDetailsTest extends CoreTestCase {


    @Test
    public void testSelectOneWayFare(){
        ResultsPageObject ResultsPageObject = new ResultsPageObject(driver);
        FlightDetailsPageObject FlightDetailsPageObject = new FlightDetailsPageObject(driver);

        ResultsPageObject.makeSearch("Москва","Берлин",true);
        FlightDetailsPageObject.selectSeatsClassAndFareType("Эконом","Премиум");
    }

    @Test
    public void testSelectRoundTripFare(){
        FlightDetailsPageObject FlightDetailsPageObject = new FlightDetailsPageObject(driver);
        ResultsPageObject ResultsPageObject = new ResultsPageObject(driver);

        ResultsPageObject.makeSearch("Москва","Берлин",false);
        FlightDetailsPageObject.selectSeatsClassAndFareType("Эконом","Премиум");
        FlightDetailsPageObject.selectSeatsClassAndFareType("Эконом","Премиум");
    }
}
