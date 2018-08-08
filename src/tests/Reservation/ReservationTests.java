package tests.Reservation;

import lib.CoreTestCase;
import lib.ui.Reservation.ReservationPageObject;
import org.junit.Test;

public class ReservationTests extends CoreTestCase {

    @Test
    public void testDraft(){
        ReservationPageObject ReservationPageObject = new ReservationPageObject(driver);
        ReservationPageObject.searchForReservation("NHJJTI","Test");
    }
}
