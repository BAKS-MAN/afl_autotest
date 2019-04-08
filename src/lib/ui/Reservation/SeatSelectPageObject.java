package lib.ui.Reservation;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import lib.ui.MainPageObject;

import java.util.List;

public class SeatSelectPageObject extends MainPageObject {
    public SeatSelectPageObject(AppiumDriver driver){super(driver);}

    protected static final String
            SEATS_SCREEN = "id:lvSeatList",
            SELECT_MEAL_ARROW = "xpath://android.widget.LinearLayout[2]/android.widget.ImageView",
            SEATS_MAP = "id:rvSeats",
            SEAT_PLACE = "id:cbSeat",
            OK_BUTTON = "id:btnOk";

    public void findSeatAndConfirm() {
        waitForElementPresent(SEATS_SCREEN,"Экран выбора места для пассажиров не отобразился",50);
        waitForElementAndClick(SELECT_MEAL_ARROW,"Не найдена кнопка перехода к выбору места",3);
        waitForElementPresent(SEATS_MAP,"Карта выбора мест не отобразилась",3);
        List<MobileElement> seats = driver.findElements(getLocatorByString(SEAT_PLACE));
            for (MobileElement seat : seats) {
                if (seat.getAttribute("clickable").equals("true")) {
                    seat.click();
                    waitForElementAndClick(OK_BUTTON, "Не удалось нажать на кнопку 'OK' на карте выбора мест", 3);
                    waitForElementPresent(SEATS_SCREEN,"После выбора места не произошел возврат на экран выбора мест",5);
                    return;
                }
            } throw new AssertionError("Не удалось выбрать место, т.к нет свободных мест");
    }
}
