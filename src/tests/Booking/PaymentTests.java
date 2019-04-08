package tests.Booking;

import lib.CoreTestCase;
import lib.ui.Booking.PaymentPageObject;
import org.junit.Test;

public class PaymentTests extends CoreTestCase {

    @Test
    public void testSelectGiftCertificate(){
        PaymentPageObject PaymentPageObject = new PaymentPageObject(driver);
        PaymentPageObject.goToPaymentScreen("Москва","Минск",true);
        PaymentPageObject.selectGiftCertificateToPay();
    }

    @Test
    public void testPayForBooking(){
        PaymentPageObject PaymentPageObject = new PaymentPageObject(driver);
        PaymentPageObject.goToPaymentScreen("Москва","Минск",true);
        PaymentPageObject.fillCardPaymentData("5555555555555599","1219","123");
        PaymentPageObject.pressPayButton();
    }

    @Test
    public void testPayForBookingWithEss(){
        PaymentPageObject PaymentPageObject = new PaymentPageObject(driver);
        PaymentPageObject.goToPaymentScreenWithEss("Москва","Минск",true);
        PaymentPageObject.fillCardPaymentData("5555555555555599","1219","123");
        PaymentPageObject.pressPayButton();
    }
}
