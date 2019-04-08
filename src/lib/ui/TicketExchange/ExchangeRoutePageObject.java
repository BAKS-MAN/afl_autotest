package lib.ui.TicketExchange;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import lib.ui.MainPageObject;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class ExchangeRoutePageObject extends MainPageObject {
    public ExchangeRoutePageObject(AppiumDriver driver){super(driver);}

    protected static final String
            ROUTES_SCREEN = "id:exchange_routes_scroll",
            EDIT_SEGMENT = "id:leg_edit_layout",
            EDIT_SEGMENT_CANCEL = "id:leg_cancel_layout",
            DELETE_SEGMENT = "id:leg_disable_layout",
            EDIT_SEGMENT_DISABLED = "id:flDisabled",
            CITY_ORIGIN_FIELD = "id:tlAirportFrom",
            CITY_ORIGIN_FIELD_TEXT = "xpath://android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.TextView[1]",
            CITY_DESTINATION_FIELD = "id:tlAirportTo",
            CITY_DESTINATION_FIELD_TEXT = "xpath://android.widget.LinearLayout[3]/android.widget.LinearLayout/android.widget.TextView[1]",
            CITY_SEARCH_FIELD = "id:etSearch",
            CITY_SEARCH_RESULT_TPL = "xpath://*[@class = 'android.widget.TextView'][@text = '{CITY}']",
            DATE_FIELD = "id:tlDateFrom",
            SECOND_SEGMENT_EDIT = "xpath://android.widget.FrameLayout[2]//*[contains(@resource-id,'leg_edit_layout')]",
            SECOND_SEGMENT_EDIT_CANCEL = "xpath://android.widget.FrameLayout[2]//*[contains(@resource-id,'leg_cancel_layout')]",
            SECOND_SEGMENT_DELETE = "xpath://android.widget.FrameLayout[2]//*[contains(@resource-id,'leg_disable_layout')]",
            SECOND_SEGMENT_EDIT_DISABLED = "xpath://android.widget.FrameLayout[2]//*[contains(@resource-id,'flDisabled')]",
            SECOND_SEGMENT_CITY_ORIGIN_FIELD = "xpath://android.widget.FrameLayout[2]//*[contains(@resource-id,'tlAirportFrom')]",
            SECOND_SEGMENT_CITY_ORIGIN_FIELD_TEXT = "xpath://android.widget.FrameLayout[2]//android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.TextView[1]",
            SECOND_SEGMENT_CITY_DESTINATION_FIELD = "xpath://android.widget.FrameLayout[2]//*[contains(@resource-id,'tlAirportTo')]",
            SECOND_SEGMENT_CITY_DESTINATION_FIELD_TEXT = "xpath://android.widget.FrameLayout[2]//android.widget.LinearLayout[3]/android.widget.LinearLayout/android.widget.TextView[1]",
            SECOND_SEGMENT_DATE_FIELD = "xpath://android.widget.FrameLayout[2]//*[contains(@resource-id,'tlDateFrom')]",
            CALENDAR_WINDOW = "id:datePicker",
            CALENDAR_NEXT_MONTH_SELECT = "id:next",
            CALENDAR_DAY_TPL = "xpath://*[@class = 'android.view.View'][@text='{DAY}']",
            CALENDAR_OK_BUTTON = "id:button1",
            ADD_ITINERARY_SEGMENT_BUTTON = "id:btnAddItinerarySegment",
            ECONOMY_CLASS_BUTTON = "id:radio_class_econom",
            COMFORT_CLASS_BUTTON = "id:radio_class_comfort",
            BUSINESS_CLASS_BUTTON = "id:radio_class_business",
            CLASS_RADIO_BUTTON = "xpath://android.widget.RadioButton",
            SEARCH_BUTTON = "id:exchange_btn";

    /*TEMPLATES METHODS */
    private static String getOriginCityByName(String origin_city){
        return CITY_SEARCH_RESULT_TPL.replace("{CITY}", origin_city);
    }
    private static String getDestinationCityByName(String destination_city){
        return CITY_SEARCH_RESULT_TPL.replace("{CITY}", destination_city);
    }
    private static String getFlightDay(String flight_day){
        return CALENDAR_DAY_TPL.replace("{DAY}",flight_day);
    }
    /*TEMPLATES METHODS */

    private void checkExchangeRouteScreen(){
        waitForElementPresent(ROUTES_SCREEN,"Экран параметров маршрута к обмену не отобразился",15);
        waitForElementPresent(EDIT_SEGMENT,"Не найдена кнопка изменения сегмента",2);
        waitForElementPresent(DELETE_SEGMENT,"Не найдена кнопка удаления сегмента",2);
        waitForElementPresent(CITY_ORIGIN_FIELD,"Поле выбора города отправления не найдено",2);
        waitForElementPresent(CITY_DESTINATION_FIELD,"Поле выбора города прибытия не найдено",2);
        waitForElementPresent(DATE_FIELD,"Поле выбора даты вылета не обнаружено",2);
        swipeUpToFindElement(ADD_ITINERARY_SEGMENT_BUTTON,"Кнопка добавления сегмента не найдена",2);
        swipeUpToFindElement(ECONOMY_CLASS_BUTTON,"Кнопка выбора эконом класса не найдена",2);
        waitForElementPresent(COMFORT_CLASS_BUTTON,"Кнопка выбора комфорт класса не найдена",2);
        waitForElementPresent(BUSINESS_CLASS_BUTTON,"Кнопка выбора бизнес класса не найдена",2);
        waitForElementPresent(SEARCH_BUTTON,"Кнопка поиска не найдена",2);
        swipeDownQuick();
    }

    private void changeOriginCity(String origin_city){
        String origin_city_xpath = getOriginCityByName(origin_city);
        this.waitForElementAndClick(CITY_ORIGIN_FIELD,"Поле выбора города отправления не найдено",3);
        this.waitForElementAndSendKeys(CITY_SEARCH_FIELD, origin_city, "Поле ввода города отправления не найдено",5);
        this.waitForElementAndClick(origin_city_xpath,"В списке результатов отсутствует "+origin_city,3);
        this.waitForElementPresent(CITY_ORIGIN_FIELD_TEXT,"Выбранный город вылета не отобразился",3);
        String origin_city_actual = getElementValue(CITY_ORIGIN_FIELD_TEXT,"text");
        if (!origin_city_actual.equals(origin_city.toUpperCase())){
            throw new IllegalArgumentException("Город вылета '"+origin_city_actual+"' не соответствует выбранному: '"+origin_city.toUpperCase()+"'");
        }
    }
    private void changeDestinationCity(String destination_city, String destination_city_field_locator, String destination_city_field_text_locator){
        String destination_city_xpath = getDestinationCityByName(destination_city);
        this.waitForElementAndClick(destination_city_field_locator,"Поле выбора города прибытия не найдено",3);
        this.waitForElementAndSendKeys(destination_city_field_locator, destination_city, "Поле ввода города прибытия не найдено",5);
        this.waitForElementAndClick(destination_city_xpath,"В списке результатов отсутствует "+destination_city,3);
        this.waitForElementPresent(destination_city_field_text_locator,"Выбранный город прилета не отобразился",3);
        String destination_city_actual = getElementValue(destination_city_field_text_locator,"text");
        if (!destination_city_actual.equals(destination_city.toUpperCase())){
            throw new IllegalArgumentException("Город прилета '"+destination_city_actual+"' не соответствует выбранному: '"+destination_city.toUpperCase()+"'");
        }
    }

    private void changeFlightDay(String date_filed_locator){
        String flight_day = getElementValue(date_filed_locator,"text").split(Pattern.quote(" "),2)[0]; //Получаем изначальную дату вылета

        this.waitForElementAndClick(date_filed_locator,"Поле выбора даты вылета не найдено",3);
        this.waitForElementPresent(CALENDAR_WINDOW,"Календарь выбора даты не отображается",3);
        int new_flight_day = Integer.valueOf(flight_day)+ 3; //Задаем новую дату вылета равной дата в брони + 3
        String new_flight_day_xpath = getFlightDay(Integer.toString(new_flight_day));
        if (new_flight_day >27){   //Если новая дата более 27, то выбираем 5 число следующего месяца
            waitForElementAndClick(CALENDAR_NEXT_MONTH_SELECT,"Не найден элемент выбора следующего месяца",3);
            new_flight_day_xpath = getFlightDay("5");
            waitForElementAndClick(new_flight_day_xpath,"Не обнаружена дата для выбора",3);
        } else {
            waitForElementAndClick(new_flight_day_xpath,"Не обнаружена дата для выбора",3);
        }
        waitForElementAndClick(CALENDAR_OK_BUTTON,"Кнопка подтверждения даты не обнаружена",3);
        waitForElementPresent(ROUTES_SCREEN,"Экран параметров маршрута к обмену не отобразился после выбора даты",3);
        String flight_day_after_change = getElementValue(date_filed_locator,"text").split(Pattern.quote(" "),2)[0]; //Получаем дату вылета после изменений
        if (!flight_day.equals(flight_day_after_change)){
            throw new AssertionError("Дата вылета: "+flight_day_after_change+", не соответствует выбранной: "+new_flight_day);
        }
    }

    private void editFirstSegment(){
        checkExchangeRouteScreen();
        waitForElementAndClick(EDIT_SEGMENT,"Не удалось нажать на кнопку изменения сегмента",2);
        waitForElementPresent(EDIT_SEGMENT_CANCEL,"Не отобразилась кнопка отмены изменений сегмента",2);
        waitForElementNotPresent(EDIT_SEGMENT_DISABLED,"Сегмент недоступен для изменения в режиме редактирования",2);
    }

    private void editSecondSegment(){
        checkExchangeRouteScreen();
        waitForElementAndClick(SECOND_SEGMENT_EDIT,"Не удалось нажать на кнопку изменения второго сегмента",2);
        waitForElementPresent(SECOND_SEGMENT_EDIT_CANCEL,"Не отобразилась кнопка отмены изменений второго сегмента",2);
        waitForElementNotPresent(SECOND_SEGMENT_EDIT_DISABLED,"Второй сегмент недоступен для изменения в режиме редактирования",2);
    }

    private String getCurrentClass(){
        List<MobileElement> available_classes = driver.findElements(getLocatorByString(CLASS_RADIO_BUTTON));
        String checked_class_name = "";
        for (MobileElement checked_class : available_classes){
            if (checked_class.getAttribute("checked").equals("true")){
                checked_class_name = checked_class.getAttribute("text");
                break;
            }
        }
        return checked_class_name;
    }

    public ArrayList<String> saveParameters(){
        ArrayList<String> exchangeParameters = new ArrayList<>();
        exchangeParameters.add(firstLetterToUpperCase(getElementValue(CITY_ORIGIN_FIELD_TEXT,"text")));
        exchangeParameters.add(firstLetterToUpperCase(getElementValue(CITY_DESTINATION_FIELD_TEXT,"text")));
        exchangeParameters.add(getElementValue(DATE_FIELD,"text").split(Pattern.quote(" "),2)[0]);
        exchangeParameters.add(getCurrentClass());
        if (isElementPresent(SECOND_SEGMENT_EDIT)){
            exchangeParameters.add(getElementValue(SECOND_SEGMENT_CITY_ORIGIN_FIELD_TEXT,"text"));
            exchangeParameters.add(getElementValue(SECOND_SEGMENT_CITY_DESTINATION_FIELD_TEXT,"text"));
            exchangeParameters.add(getElementValue(SECOND_SEGMENT_DATE_FIELD,"text").split(Pattern.quote(" "),2)[0]);
        }
        return exchangeParameters;
    }


    //Тесты
    public void searchWithoutChanges(){
        checkExchangeRouteScreen();
        saveParameters();
        waitForElementAndClick(SEARCH_BUTTON,"Не удалось нажать на кнопку поиска рейсов",2);
//        this.waitForElementPresent("id:exchange_flights_list", "Блок с результатами поиска не найден", 20);
//        System.out.println(saveParameters().get(3));
//        switch (saveParameters().get(1)){
//            case "Эконом" : waitForElementAndClick(ECONOMY_CLASS_BUTTON, "В результатах поиска отсутствует кнопка выбора эконом класса", 3);
//                break;
//            case "Комфорт" : waitForElementAndClick(COMFORT_CLASS_BUTTON, "В результатах поиска отсутствует кнопка выбора комфорт класса", 3);
//                break;
//            case "Бизнес" : waitForElementAndClick(BUSINESS_CLASS_BUTTON, "В результатах поиска отсутствует кнопка выбора бизнес класса", 3);
//                break;
//        }
    }

    public void searchWithAnotherDate(){
        editFirstSegment();
        changeFlightDay(DATE_FIELD);
        if (isElementPresent(SECOND_SEGMENT_EDIT)){
            editSecondSegment();
            changeFlightDay(SECOND_SEGMENT_DATE_FIELD);
        }
        saveParameters();
        waitForElementAndClick(SEARCH_BUTTON,"Не удалось нажать на кнопку поиска рейсов",2);
    }

    public void searchWithAnotherOriginCity(String origin_city){
        editFirstSegment();
        changeOriginCity(origin_city);
        waitForElementAndClick(SEARCH_BUTTON,"Не удалось нажать на кнопку поиска рейсов",2);
    }

    public void searchWithAnotherDestinationCity(String destination_city){
        if (isElementPresent(SECOND_SEGMENT_EDIT)){
            editSecondSegment();
            changeDestinationCity(destination_city,SECOND_SEGMENT_CITY_DESTINATION_FIELD,SECOND_SEGMENT_CITY_DESTINATION_FIELD_TEXT);
        } else {
            editFirstSegment();
            changeDestinationCity(destination_city,CITY_DESTINATION_FIELD,CITY_DESTINATION_FIELD_TEXT);
        }
        waitForElementAndClick(SEARCH_BUTTON,"Не удалось нажать на кнопку поиска рейсов",2);
    }

    public void searchWithoutSecondSegment(){
        checkExchangeRouteScreen();
        waitForElementAndClick(SECOND_SEGMENT_DELETE,"Не удалось нажать на кнопку удаления второго сегмента",2);
        waitForElementPresent(SECOND_SEGMENT_EDIT_CANCEL,"Не отобразилась кнопка отмены удаления сегмента",2);
        waitForElementAndClick(SEARCH_BUTTON,"Не удалось нажать на кнопку поиска рейсов",2);
    }
}
