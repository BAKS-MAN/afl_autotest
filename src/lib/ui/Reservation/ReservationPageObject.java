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


    public void openReservationScreen(){
        MenuPageObject MenuPageObject = new MenuPageObject(driver);
        MenuPageObject.clickMenuButton();
        MenuPageObject.clickMenuItemByName("Поиск бронирования");
        this.checkReservationScreen();
    }

    public void checkReservationScreen() {
        this.waitForElementPresent(MY_BOOKING_LAYOUT,"Не отобразилось содержимое экрана поиска бронирования",7);
        this.waitForElementPresent(BOOKING_PNR_FIELD,"Не удалось найти поле ввода номера PNR",5);
        this.waitForElementPresent(BOOKING_LAST_NAME_FILED,"Не удалось найти поле ввода фамилии",5);
        this.waitForElementPresent(SEARCH_BUTTON,"Не найдена кнопка поиска бронирования",5);
    }

    public void searchForReservation(String pnr_number, String last_name){
        ReservationInfoPageObject ReservationInfoPageObject = new ReservationInfoPageObject(driver);

        openReservationScreen();
        this.waitForElementAndSendKeys(BOOKING_PNR_FIELD,pnr_number,"Не удалось ввести номер PNR",5);
        this.waitForElementAndSendKeys(BOOKING_LAST_NAME_FILED,last_name,"Не удалось ввести фамилию",5);
        this.waitForElementAndClick(SEARCH_BUTTON,"Не удалось нажать по кнопке поиска бронирования",5);
        ReservationInfoPageObject.checkReservationInfoScreen();
    }

    public void makeOneWayOnePassengerReservation(){

    }
}
