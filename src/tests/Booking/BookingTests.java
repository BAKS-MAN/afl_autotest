package tests.Booking;

import lib.CoreTestCase;
import lib.ui.Booking.BookingPageObject;
import lib.ui.MenuPageObject;
import org.junit.Test;

public class BookingTests extends CoreTestCase {

    @Test
    public void testChangeOriginAndDestinationCity(){
        BookingPageObject BookingPageObject = new BookingPageObject(driver);
        BookingPageObject.openBookingScreen();
        BookingPageObject.typeOriginCityAndSelect("Минск");
        BookingPageObject.typeDestinationCityAndSelect("Краснодар");
        BookingPageObject.changeOriginCity("Сочи");
        BookingPageObject.changeDestinationCity("Мюнхен");
    }
    @Test
    public void testSwapCities(){
        BookingPageObject BookingPageObject = new BookingPageObject(driver);
        BookingPageObject.openBookingScreen();
        BookingPageObject.swapCities("Минск","Сочи");
    }
    @Test
    public void testSetSameCities(){
        BookingPageObject BookingPageObject = new BookingPageObject(driver);
        BookingPageObject.openBookingScreen();
        BookingPageObject.setSameCities("Пермь");
    }

    @Test
    public void testAddAndDeleteItinerarySegment(){
        BookingPageObject BookingPageObject = new BookingPageObject(driver);
        BookingPageObject.openBookingScreen();
        BookingPageObject.addItinerarySegment();
        BookingPageObject.deleteItinerarySegment();
    }
    @Test
    public void testOpenPassengersInfo(){
        BookingPageObject BookingPageObject = new BookingPageObject(driver);
        BookingPageObject.openBookingScreen();
        BookingPageObject.openPassengersInfo();
    }
    @Test
    public void testCheckMaxPassengersQuantity(){
        BookingPageObject BookingPageObject = new BookingPageObject(driver);
        BookingPageObject.openBookingScreen();
        BookingPageObject.swipeUpQuick();
        BookingPageObject.checkMaxPassengersQuantity();
    }
    @Test
    public void testOpenBookingRulesInfo(){
        BookingPageObject BookingPageObject = new BookingPageObject(driver);
        BookingPageObject.openBookingScreen();
        BookingPageObject.swipeUpQuick();
        BookingPageObject.openBookingRulesInfo();
    }
    @Test
    public void testSelectCountry(){
        BookingPageObject BookingPageObject = new BookingPageObject(driver);
        BookingPageObject.openBookingScreen();
        BookingPageObject.swipeUpQuick();
        BookingPageObject.selectCountry("Испания");
    }
}
