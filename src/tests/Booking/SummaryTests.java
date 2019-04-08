package tests.Booking;

import lib.CoreTestCase;
import lib.ui.Booking.SummaryPageObject;
import org.junit.Test;

public class SummaryTests extends CoreTestCase {
    @Test
    public void testCheckSummaryScreen(){
        SummaryPageObject SummaryPageObject = new SummaryPageObject(driver);
        SummaryPageObject.goToSummaryScreen("Москва","Минск",true);
    }
}
