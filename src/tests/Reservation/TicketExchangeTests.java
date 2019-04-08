package tests.Reservation;

import lib.CoreTestCase;
import lib.ui.Reservation.ReservationPageObject;
import lib.ui.TicketExchange.TicketExchangePageObject;
import org.junit.Test;

public class TicketExchangeTests extends CoreTestCase {

    @Test
    public void testExchangeDefault(){
        ReservationPageObject ReservationPageObject= new ReservationPageObject(driver);
        TicketExchangePageObject TicketExchangePageObject = new TicketExchangePageObject(driver);

        ReservationPageObject.searchForReservation("UPRRFZ","Test");
        TicketExchangePageObject.exchangeDefault();
    }

    @Test
    public void testExchangeWithDateChange(){
        ReservationPageObject ReservationPageObject= new ReservationPageObject(driver);
        TicketExchangePageObject TicketExchangePageObject = new TicketExchangePageObject(driver);

        ReservationPageObject.searchForReservation("UPRRFZ","Test");
        TicketExchangePageObject.exchangeWithDateChange();
    }

    @Test
    public void testExchangeWithOriginCityChange(){
        ReservationPageObject ReservationPageObject= new ReservationPageObject(driver);
        TicketExchangePageObject TicketExchangePageObject = new TicketExchangePageObject(driver);

        ReservationPageObject.searchForReservation("UPRRFZ","Test");
        TicketExchangePageObject.exchangeWithOriginCityChange();
    }

    @Test
    public void testExchangeWithDestinationCityChange(){
        ReservationPageObject ReservationPageObject= new ReservationPageObject(driver);
        TicketExchangePageObject TicketExchangePageObject = new TicketExchangePageObject(driver);

        ReservationPageObject.searchForReservation("UPRRFZ","Test");
        TicketExchangePageObject.exchangeWithDestinationCityChange();
    }

    @Test
    public void testExchangeWithoutSecondSegment(){
        ReservationPageObject ReservationPageObject= new ReservationPageObject(driver);
        TicketExchangePageObject TicketExchangePageObject = new TicketExchangePageObject(driver);

        ReservationPageObject.searchForReservation("UPRRFZ","Test");
        TicketExchangePageObject.exchangeWithoutSecondSegment();
    }
}
