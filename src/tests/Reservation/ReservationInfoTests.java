package tests.Reservation;

import lib.CoreTestCase;
import lib.ui.Reservation.ReservationInfoPageObject;
import lib.ui.Reservation.ReservationPageObject;
import org.junit.Test;

public class ReservationInfoTests extends CoreTestCase {

    @Test
    public void testSearchReservation(){
        ReservationPageObject ReservationPageObject = new ReservationPageObject(driver);
        ReservationPageObject.searchForReservation("UXHSNV","Test");
    }

    @Test
    public void testSelectSeat(){
        ReservationPageObject ReservationPageObject = new ReservationPageObject(driver);
        ReservationInfoPageObject ReservationInfoPageObject = new ReservationInfoPageObject(driver);

        ReservationPageObject.searchForReservation("UXHSNV","Test");
        ReservationInfoPageObject.selectSeat();
    }

    @Test
    public void testSelectMeal(){
        ReservationPageObject ReservationPageObject = new ReservationPageObject(driver);
        ReservationInfoPageObject ReservationInfoPageObject = new ReservationInfoPageObject(driver);

        ReservationPageObject.searchForReservation("PJIVRP","Test");
        ReservationInfoPageObject.selectMeal();
    }

    @Test
    public void testReturnTicket(){
        ReservationPageObject ReservationPageObject = new ReservationPageObject(driver);
        ReservationInfoPageObject ReservationInfoPageObject = new ReservationInfoPageObject(driver);

        ReservationPageObject.searchForReservation("","Test");
        ReservationInfoPageObject.returnTicket();
    }

    @Test
    public void testCheckPossibility(){
        ReservationPageObject ReservationPageObject = new ReservationPageObject(driver);
        ReservationInfoPageObject ReservationInfoPageObject = new ReservationInfoPageObject(driver);

        ReservationPageObject.searchForReservation("XLJMAM","Test");
        ReservationInfoPageObject.checkUpgradePossibility();
    }
}
