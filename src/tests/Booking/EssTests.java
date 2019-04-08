package tests.Booking;

import lib.CoreTestCase;
import lib.ui.Booking.EssPageObject;
import org.junit.Test;

public class EssTests extends CoreTestCase {
    @Test
    public void testCheckEssScreen(){
        EssPageObject EssPageObject = new EssPageObject(driver);
        EssPageObject.goToEssScreen("Москва","Минск",true);
    }
}
