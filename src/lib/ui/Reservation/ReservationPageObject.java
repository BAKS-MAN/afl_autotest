package lib.ui.Reservation;

import io.appium.java_client.AppiumDriver;
import lib.ui.MainPageObject;
import lib.ui.MenuPageObject;

public class ReservationPageObject extends MainPageObject {
    public ReservationPageObject (AppiumDriver driver){super(driver);}

    protected static final String
            MY_BOOKING_LAYOUT = "id:my_booking_cardview",
            BOOKING_PNR_FIELD = "id:tilPnrNumber",
            BOOKING_LAST_NAME_FILED = "id:tilLastName",
            SEARCH_BUTTON = "id:fabSearch";

    /*TEMPLATES METHODS */

    /*TEMPLATES METHODS */

    public void searchForReservation(String pnr_number, String last_name){
        MenuPageObject MenuPageObject = new MenuPageObject(driver);
        MenuPageObject.openReservationSearchScreen();
        this.waitForElementPresent(MY_BOOKING_LAYOUT,"Не отобразилось содержимое экрана поиска бронирования",7);
        this.waitForElementAndSendKeys(BOOKING_PNR_FIELD,pnr_number,"Не удалось найти поле ввода номера PNR",5);
        this.waitForElementAndSendKeys(BOOKING_LAST_NAME_FILED,last_name,"Не удалось найти поле ввода фамилии",5);
        this.waitForElementAndClick(SEARCH_BUTTON,"Не удалось нажать по кнопке поиска бронирования",5);
    }

    public void makeOneWayOnePassengerReservation(){

    }
}
