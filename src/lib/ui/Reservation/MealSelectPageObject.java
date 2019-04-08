package lib.ui.Reservation;

import io.appium.java_client.AppiumDriver;
import lib.ui.MainPageObject;

public class MealSelectPageObject extends MainPageObject {
    public MealSelectPageObject(AppiumDriver driver){super(driver);}

    protected static final String
            MEAL_SCREEN = "id:lvSeatList",
            SELECT_MEAL_ARROW = "xpath://android.widget.LinearLayout[2]/android.widget.ImageView",
            SELECTED_DESCRIPTION = "id:text2",
            MEAL_LIST = "id:select_dialog_listview",
            MEAL_POSITION = "xpath://android.widget.CheckedTextView[7]";

    public void selectMealFromList() {
        waitForElementPresent(MEAL_SCREEN,"Экран выбора питания для пассажиров не отобразился",50);
        waitForElementAndClick(SELECT_MEAL_ARROW,"Не найдена кнопка перехода к выбору питания",3);
        waitForElementPresent(MEAL_LIST,"Список доступного питания не отобразился",20);
        String choice = getElementValue(MEAL_POSITION,"text");
        waitForElementAndClick(MEAL_POSITION,"Не удалось выбрать питание: '"+choice+"'",3);
        if (getElementValue(SELECTED_DESCRIPTION,"text").equals(choice)){
            driver.navigate().back();
        } else {
            throw new AssertionError("Выбранное питание не отобразилось для пассажира на экране выбора питания");
        }
    }
}
