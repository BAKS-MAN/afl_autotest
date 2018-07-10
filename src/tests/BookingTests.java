package tests;

import lib.CoreTestCase;
import lib.ui.Booking.BookingPageObject;
import lib.ui.MenuPageObject;
import org.junit.Test;

public class BookingTests extends CoreTestCase {

    @Test
    public void testOpenBookingScreen(){
        MenuPageObject MenuPageObject = new MenuPageObject(driver);
        BookingPageObject BookingPageObject = new BookingPageObject(driver);
        MenuPageObject.clickMenuButton();
        MenuPageObject.clickMenuItemByName("Купить билет");
        BookingPageObject.waitForBookingScreenTitle();
    }

    @Test
    public void testBookingScreenInitialization(){
        this.testOpenBookingScreen();
        BookingPageObject BookingPageObject = new BookingPageObject(driver);
        BookingPageObject.initBookingScreen();
    }

    @Test
    public void testSelectOriginAndDestinationCity(){
        this.testOpenBookingScreen();
        BookingPageObject BookingPageObject = new BookingPageObject(driver);
        BookingPageObject.typeOriginCityAndSelect("Москва");
        BookingPageObject.typeDestinationCityAndSelect("Краснодар");
    }
    @Test
    public void testChangeOriginAndDestinationCity(){
        this.testOpenBookingScreen();
        BookingPageObject BookingPageObject = new BookingPageObject(driver);
        BookingPageObject.typeOriginCityAndSelect("Минск");
        BookingPageObject.typeDestinationCityAndSelect("Краснодар");
        BookingPageObject.changeOriginCity("Сочи");
        BookingPageObject.changeDestinationCity("Мюнхен");
    }
    @Test
    public void testSwapCities(){
        this.testOpenBookingScreen();
        BookingPageObject BookingPageObject = new BookingPageObject(driver);
        BookingPageObject.swapCities("Минск","Сочи");
    }
    @Test
    public void testSetSameCities(){
        this.testOpenBookingScreen();
        BookingPageObject BookingPageObject = new BookingPageObject(driver);
        BookingPageObject.setSameCities("Пермь");
    }
    @Test
    public void testSetDateFromAndTo(){
        this.testOpenBookingScreen();
        BookingPageObject BookingPageObject = new BookingPageObject(driver);
        BookingPageObject.setDateFromAndTo();
    }
    @Test
    public void testSetOneWayDate(){
        this.testOpenBookingScreen();
        BookingPageObject BookingPageObject = new BookingPageObject(driver);
        BookingPageObject.setOneWayDate();
    }
    @Test
    public void testAddAndDeleteItinerarySegment(){
        this.testOpenBookingScreen();
        BookingPageObject BookingPageObject = new BookingPageObject(driver);
        BookingPageObject.addItinerarySegment();
        BookingPageObject.deleteItinerarySegment();
    }
    @Test
    public void testOpenPassengersInfo(){
        this.testOpenBookingScreen();
        BookingPageObject BookingPageObject = new BookingPageObject(driver);
        BookingPageObject.openPassengersInfo();
    }
    @Test
    public void testCheckMaxPassengersQuantity(){
        this.testOpenBookingScreen();
        BookingPageObject BookingPageObject = new BookingPageObject(driver);
        BookingPageObject.swipeUpQuick();
        BookingPageObject.checkMaxPassengersQuantity();
    }
    @Test
    public void testSelectCountry(){
        this.testOpenBookingScreen();
        BookingPageObject BookingPageObject = new BookingPageObject(driver);
        BookingPageObject.swipeUpQuick();
        BookingPageObject.selectCountry("Мексика");
    }
    @Test
    public void testOpenBookingRulesInfo(){
        this.testOpenBookingScreen();
        BookingPageObject BookingPageObject = new BookingPageObject(driver);
        BookingPageObject.swipeUpQuick();
        BookingPageObject.openBookingRulesInfo();
    }
    @Test
    public void testSearchRoundTripFlightsWithTwoPassengers(){
        this.testOpenBookingScreen();
        BookingPageObject BookingPageObject = new BookingPageObject(driver);
        BookingPageObject.typeOriginCityAndSelect("Москва");
        BookingPageObject.typeDestinationCityAndSelect("Краснодар");
        BookingPageObject.setDateFromAndTo();
        BookingPageObject.swipeUpQuick();
        BookingPageObject.selectAdultPassengers("1");
        BookingPageObject.selectChildPassengers("1");
        BookingPageObject.startSearch();
    }
    @Test
    public void testSearchOneWayFlightWithOnePassenger(){
        this.testOpenBookingScreen();
        BookingPageObject BookingPageObject = new BookingPageObject(driver);
        BookingPageObject.typeOriginCityAndSelect("Москва");
        BookingPageObject.typeDestinationCityAndSelect("Краснодар");
        BookingPageObject.setOneWayDate();
        BookingPageObject.swipeUpQuick();
        BookingPageObject.startSearch();
    }
}
