package lib.ui;

import io.appium.java_client.AppiumDriver;
import lib.ui.Booking.BookingPageObject;

public class MenuPageObject extends MainPageObject{
    public MenuPageObject (AppiumDriver driver){super(driver);}

    protected static final String
            MENU_BUTTON = "xpath://android.widget.ImageButton[@content-desc='close']",
            MAIN_MENU = "id:navigation_view",
            MENU_ITEM_BY_NAME_TPL = "xpath://android.widget.CheckedTextView[@text='{MENU_ITEM_NAME}']";


    /*TEMPLATES METHODS */
    private static String getMenuItemByName(String menu_item_name){
        return MENU_ITEM_BY_NAME_TPL.replace("{MENU_ITEM_NAME}", menu_item_name);
    }
    /*TEMPLATES METHODS */


    public void clickMenuButton(){
        this.waitForElementAndClick(MENU_BUTTON,"Не обнаружена кнопка меню",5);
        this.waitForElementPresent(MAIN_MENU,"",5);
    }

    public void clickMenuItemByName(String menu_item_name){
        String menu_item_xpath = getMenuItemByName(menu_item_name);
        this.waitForElementAndClick(menu_item_xpath,"Пункт меню '"+menu_item_name+"' не найден",5);
    }
}
