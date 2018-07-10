package lib.ui.Booking;

import io.appium.java_client.AppiumDriver;
import lib.ui.MainPageObject;
import org.openqa.selenium.By;
import java.util.Calendar;
import java.util.TimeZone;

public class BookingPageObject extends MainPageObject {
    public BookingPageObject (AppiumDriver driver){super(driver);}

    protected static final String
            BOOKING_SCREEN_TITLE = "xpath://*[@resource-id='ru.aeroflot.afltest:id/booking_toolbar']//*[@text='Купить билет']",
            REGULAR_SEARCH_TAB = "xpath://android.support.v7.app.ActionBar.Tab//*[@text='ОБЫЧНЫЙ ПОИСК']",
//            REGULAR_SEARCH_TAB = "xpath://android.support.v7.app.ActionBar.Tab//*[@text='Обычный поиск']",
            MILE_SEARCH_TAB = "xpath://android.support.v7.app.ActionBar.Tab//*[@text='ПОИСК ЗА МИЛИ']",
//            MILE_SEARCH_TAB = "xpath://android.support.v7.app.ActionBar.Tab//*[@text='Поиск за мили']",
            CITY_ORIGIN_FIELD = "id:ru.aeroflot.afltest:id/tlAirportFrom",
            CITY_ORIGIN_FIELD_TEXT = "//*[@resource-id = 'ru.aeroflot.afltest:id/tlAirportFrom']//*[@resource-id = 'ru.aeroflot.afltest:id/tvFirstLineText']",
            CITY_DESTINATION_FIELD = "id:ru.aeroflot.afltest:id/tlAirportTo",
            CITY_DESTINATION_FIELD_TEXT = "//*[@resource-id = 'ru.aeroflot.afltest:id/tlAirportTo']//*[@resource-id = 'ru.aeroflot.afltest:id/tvFirstLineText']",
            CITY_SEARCH_FIELD = "id:ru.aeroflot.afltest:id/etSearch",
            CITY_SEARCH_CLEAR = "id:ru.aeroflot.afltest:id/btnClear",
            CITY_SEARCH_RESULT_TPL = "xpath://*[@resource-id = 'ru.aeroflot.afltest:id/tvFirstLineText'][@text = '{CITY}']",
            SWAP_CITIES_BUTTON = "id:ru.aeroflot.afltest:id/btnSwapCities",
            DIRECT_FLIGHTS_SWITCH = "id:ru.aeroflot.afltest:id/swOnlyDirectFlights",
            DATE_FROM = "id:ru.aeroflot.afltest:id/rlDateFrom",
            DATE_TO = "id:ru.aeroflot.afltest:id/tlDateTo",
            CALENDAR_WINDOW = "xpath://com.prolificinteractive.materialcalendarview.CalendarPagerView[@content-desc='Calendar']",
            CALENDAR_NEXT_MONTH_SELECT = "xpath://android.widget.ImageView[@content-desc='Go to next']",
            CALENDAR_DAY_TPL = "xpath://com.prolificinteractive.materialcalendarview.CalendarPagerView[@content-desc='Calendar']//*[@text='{DAY}']",
            CALENDAR_ONE_WAY_SWITCH = "id:ru.aeroflot.afltest:id/chbOneWay",
            CALENDAR_SELECT_BUTTON = "id:ru.aeroflot.afltest:id/btnOk",
            ADD_ITINERARY_SEGMENT_BUTTON = "id:ru.aeroflot.afltest:id/btnAddItinerarySegment",
            DELETE_ITINERARY_SEGMENT_BUTTON = "id:ru.aeroflot.afltest:id/btnItineraryDelSegment",
            ADD_ANOTHER_ITINERARY_SEGMENT_BUTTON = "xpath://*[@resource-id = 'ru.aeroflot.afltest:id/btnAddItinerarySegment'][@text = 'ДОБАВИТЬ ПЕРЕЛЁТ']",
            PASSENGERS_INFO_BUTTON = "id:ru.aeroflot.afltest:id/btnPassengersInfo",
            PASSENGERS_INFO_ALERT = "xpath://*[@resource-id = 'android:id/alertTitle'][@text = 'Пассажиры']",
            SELECT_ADULT_PASSENGERS = "id:ru.aeroflot.afltest:id/btnAdult",
            SELECT_CHILD_PASSENGERS = "id:ru.aeroflot.afltest:id/btnChild",
            SELECT_INFANT_PASSENGERS = "id:ru.aeroflot.afltest:id/btnInfant",
            PASSENGERS_SELECTOR_TPL = "xpath://*[@resource-id = 'ru.aeroflot.afltest:id/spinnerTarget'][@text = '{QUANTITY}']",
            SELECT_COUNTRY_FIELD = "id:ru.aeroflot.afltest:id/spCountry",
            SELECT_COUNTRY_LIST = "xpath://android.widget.ListView",
            SELECT_COUNTRY_BY_NAME_TPL = "xpath://*[@resource-id = 'android:id/text1'][@text = '{COUNTRY}']",
            BOOKING_RULES_INFO_BUTTON = "id:ru.aeroflot.afltest:id/btnInfo",
            PERMISSION_ALLOW_WINDOW = "id:com.android.packageinstaller:id/perm_desc_root",
            PERMISSION_ALLOW_BUTTON = "id:com.android.packageinstaller:id/permission_allow_button",
            BOOKING_RULES_TITLE = "xpath://*[@resource-id = 'ru.aeroflot.afltest:id/toolbar']//*[@text = 'Правила бронирования']",
//            PAYLATE_BANNER = "id:ru.aeroflot.afltest:id/llPaylate",
            SEARCH_BUTTON = "id:ru.aeroflot.afltest:id/search",
            PRICE_CALENDAR_BUTTON = "id:ru.aeroflot.afltest:id/priceCalendar";


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
    private static String getPassengersQuantity(String quantity){
        return PASSENGERS_SELECTOR_TPL.replace("{QUANTITY}",quantity);
    }
    private static String getCountryByName (String country){
        return SELECT_COUNTRY_BY_NAME_TPL.replace("{COUNTRY}", country);
    }
    /*TEMPLATES METHODS */

    public void waitForBookingScreenTitle(){
        this.waitForElementPresent(BOOKING_SCREEN_TITLE, "Не обнаружен заголовок экрана покупки билета", 5);
    }

    public void initBookingScreen(){
        this.waitForElementPresent(REGULAR_SEARCH_TAB,"Вкладка обычного поиска не обнаружена",2);
        this.waitForElementPresent(MILE_SEARCH_TAB,"Вкладка мильного поиска не обнаружена",2);
        this.waitForElementPresent(CITY_ORIGIN_FIELD,"Вкладка мильного поиска не обнаружена",2);
        this.waitForElementPresent(CITY_DESTINATION_FIELD,"Вкладка мильного поиска не обнаружена",2);
        this.waitForElementPresent(SWAP_CITIES_BUTTON,"Кнопка смены направления не обнаружена",2);
        this.waitForElementPresent(DIRECT_FLIGHTS_SWITCH,"Переключатель напрвления в одну сторону не обнаружен",2);
        this.waitForElementPresent(DATE_FROM,"Поле выбора даты вылета не обнаружено",2);
        this.waitForElementPresent(DATE_TO,"Поле выбора даты прилета не обнаружено",2);
        this.waitForElementPresent(ADD_ITINERARY_SEGMENT_BUTTON,"Кнопка добавления сложного маршрута не обнаружена",2);
        this.swipeUpQuick();
        this.waitForElementPresent(PASSENGERS_INFO_BUTTON,"Кнопка информации о пассажирах не обнаружена",2);
        this.waitForElementPresent(SELECT_ADULT_PASSENGERS,"Поле выбора взрослого пассажира не обнаружено",2);
        this.waitForElementPresent(SELECT_CHILD_PASSENGERS,"Поле выбора пассажира ребенка не обнаружено",2);
        this.waitForElementPresent(SELECT_INFANT_PASSENGERS,"Поле выбора пассажира младенца не обнаружено",2);
        this.waitForElementPresent(SELECT_COUNTRY_FIELD,"Поле выбора страны не обнаружено",2);
        this.waitForElementPresent(BOOKING_RULES_INFO_BUTTON,"Кнопка информации о правилах бронирования не обнаружена",2);
//        this.waitForElementPresent(PAYLATE_BANNER,"Баннер приобретения билета в рассрочку не отображается",2);
        this.waitForElementPresent(SEARCH_BUTTON,"Кнопка поиска не обнаружена",2);
    }

    public void typeOriginCityAndSelect(String origin_city){
        String origin_city_xpath = getOriginCityByName(origin_city);
        this.waitForElementAndClick(CITY_ORIGIN_FIELD,"Поле выбора города отправления не найдено",3);
        this.waitForElementAndSendKeys(CITY_SEARCH_FIELD, origin_city, "Поле ввода города отправления не найдено",5);
        this.waitForElementAndClick(origin_city_xpath,"В списке результатов отсутствует "+origin_city,3);
        String origin_city_actual = driver.findElement(By.xpath(CITY_ORIGIN_FIELD_TEXT)).getText();
        if (!origin_city_actual.equals(origin_city.toUpperCase())){
            throw new IllegalArgumentException("Город вылета '"+origin_city_actual+"' не соответствует выбранному: '"+origin_city.toUpperCase()+"'");
        }
    }
    public void typeDestinationCityAndSelect(String destination_city){
        String destination_city_xpath = getDestinationCityByName(destination_city);
        this.waitForElementAndClick(CITY_DESTINATION_FIELD,"Поле выбора города прибытия не найдено",3);
        this.waitForElementAndSendKeys(CITY_SEARCH_FIELD, destination_city, "Поле ввода города прибытия не найдено",5);
        this.waitForElementAndClick(destination_city_xpath,"В списке результатов отсутствует "+destination_city,3);
        String destination_city_actual = driver.findElement(By.xpath(CITY_DESTINATION_FIELD_TEXT)).getText();
        if (!destination_city_actual.equals(destination_city.toUpperCase())){
            throw new IllegalArgumentException("Город вылета '"+destination_city_actual+"' не соответствует выбранному: '"+destination_city.toUpperCase()+"'");
        }
    }
    public void setSameCities(String origin_city){
        String origin_city_xpath = getOriginCityByName(origin_city);
        this.waitForElementAndClick(CITY_ORIGIN_FIELD,"Поле выбора города отправления не найдено",3);
        this.waitForElementAndSendKeys(CITY_SEARCH_FIELD, origin_city, "Поле ввода города отправления не найдено",5);
        this.waitForElementAndClick(origin_city_xpath,"В списке результатов отсутствует "+origin_city,3);
        this.waitForElementAndClick(CITY_DESTINATION_FIELD,"Поле выбора города прибытия не найдено",3);
        this.waitForElementAndSendKeys(CITY_SEARCH_FIELD, origin_city, "Поле ввода города прибытия не найдено",5);
        this.waitForElementAndClick(origin_city_xpath,"В списке результатов отсутствует "+origin_city,3);
        String origin_city_actual = driver.findElement(By.xpath(CITY_ORIGIN_FIELD_TEXT)).getText();
        String destination_city_actual = driver.findElement(By.xpath(CITY_DESTINATION_FIELD_TEXT)).getText();
        if (destination_city_actual.equals(origin_city_actual)){
            throw new IllegalArgumentException("Указан одинаковый город вылета и прилета");
        }
    }
    public void swapCities(String origin_city,String destination_city){
        this.typeOriginCityAndSelect(origin_city);
        this.typeDestinationCityAndSelect(destination_city);
        this.waitForElementAndClick(SWAP_CITIES_BUTTON,"Кнопка смены направлений не найдена",3);
    }
    public void changeOriginCity(String new_origin_city){
        String origin_city = new_origin_city;
        String origin_city_xpath = getOriginCityByName(origin_city);
        this.waitForElementAndClick(CITY_ORIGIN_FIELD,"Поле выбора города отправления не найдено",3);
        this.waitForElementAndClick(CITY_SEARCH_CLEAR,"Кнопка очистки строки поиска не найдена",3);
        this.waitForElementAndSendKeys(CITY_SEARCH_FIELD, new_origin_city, "Поле ввода города отправления не найдено",5);
        this.waitForElementAndClick(origin_city_xpath,"В списке результатов отсутствует "+origin_city,3);
    }
    public void changeDestinationCity(String new_destination_city){
        String destination_city = new_destination_city;
        String destination_city_xpath = getDestinationCityByName(destination_city);
        this.waitForElementAndClick(CITY_DESTINATION_FIELD,"Поле выбора города прибытия не найдено",3);
        this.waitForElementAndClick(CITY_SEARCH_CLEAR,"Кнопка очистки строки поиска не найдена",3);
        this.waitForElementAndSendKeys(CITY_SEARCH_FIELD, new_destination_city, "Поле ввода города отправления не найдено",5);
        this.waitForElementAndClick(destination_city_xpath,"В списке результатов отсутствует "+destination_city,3);
    }
    public void switchDirectFlight(){
        this.waitForElementAndClick(DIRECT_FLIGHTS_SWITCH,"Переключатель 'Только прямые рейсы' не найден",3);
    }
    public void selectFlightDay(Integer day){
        String flight_day = Integer.toString(day);
        String flight_day_xpath = getFlightDay(flight_day);
        if (day >28){
            this.waitForElementAndClick(CALENDAR_NEXT_MONTH_SELECT,"Не найден элемент выбора следующего месяца",3);
            flight_day = "5";
            flight_day_xpath = getFlightDay(flight_day);
            this.waitForElementAndClick(flight_day_xpath,"Не обнаружена дата для выбора",3);
        } else {
            this.waitForElementAndClick(flight_day_xpath,"Не обнаружена дата для выбора",3);
        }
    }
    public void setDateFromAndTo(){
        this.waitForElementAndClick(DATE_FROM,"Поле выбора даты вылета не найдено",3);
        this.waitForElementPresent(CALENDAR_WINDOW,"Календарь выбора даты не отображается",3);
        Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
        calendar.add(Calendar.DAY_OF_MONTH, 3);    //Задаем дату вылета равной текущая дата + 3
        Integer day = calendar.get(Calendar.DAY_OF_MONTH);
        this.selectFlightDay(day);
        day = day +3;         //Задаем дату возвращения
        this.selectFlightDay(day);
        this.waitForElementAndClick(CALENDAR_SELECT_BUTTON,"Кнопка выбора даты не обнаружена",3);
    }
    public void setOneWayDate(){
        this.waitForElementAndClick(DATE_FROM,"Поле выбора даты вылета не найдено",3);
        this.waitForElementPresent(CALENDAR_WINDOW,"Календарь выбора даты не отображается",3);
        Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
        calendar.add(Calendar.DAY_OF_MONTH, 3);    //Задаем дату вылета равной текущая дата + 3
        Integer day = calendar.get(Calendar.DAY_OF_MONTH);
        this.selectFlightDay(day);
        this.waitForElementAndClick(CALENDAR_ONE_WAY_SWITCH,"Переключатель напрвления в одну сторону не обнаружен",3);
        this.waitForElementAndClick(CALENDAR_SELECT_BUTTON,"Кнопка выбора даты не обнаружена",3);
    }
    public void addItinerarySegment(){
        this.waitForElementAndClick(ADD_ITINERARY_SEGMENT_BUTTON,"Кнопка добавления сложного перелета не найдена",2);
        this.swipeDownQuick();
        this.waitForElementPresent(DELETE_ITINERARY_SEGMENT_BUTTON,"Кнопка удаления дополнительного перелета не найдена",2);
        this.waitForElementPresent(ADD_ANOTHER_ITINERARY_SEGMENT_BUTTON,"Кнопка добавления дополнительного перелета не найдена",2);
    }
    public void deleteItinerarySegment(){
        this.swipeDownQuick();
        this.waitForElementAndClick(DELETE_ITINERARY_SEGMENT_BUTTON,"Кнопка удаления дополнительного перелета не найдена",2);
    }
    public void openPassengersInfo(){
        this.waitForElementAndClick(PASSENGERS_INFO_BUTTON,"Кнопка информации о пассажирах не найдена",2);
        this.waitForElementPresent(PASSENGERS_INFO_ALERT,"Информационное окно о пассажирах не обнаружено",2);
    }
    public void selectAdultPassengers(String quantity){
        this.waitForElementAndClick(SELECT_ADULT_PASSENGERS,"Поле выбора взрослых пассажиров не обнаружено",2);
        String passengers_quantity_xpath = getPassengersQuantity(quantity);
        this.waitForElementAndClick(passengers_quantity_xpath,"Элемент выбора количества пассажиров не обнаружен",2);
    }
    public void selectChildPassengers(String quantity){
        this.waitForElementAndClick(SELECT_CHILD_PASSENGERS,"Поле выбора пассажиров детей не обнаружено",2);
        String passengers_quantity_xpath = getPassengersQuantity(quantity);
        this.waitForElementAndClick(passengers_quantity_xpath,"Элемент выбора количества пассажиров не обнаружен",2);
    }
    public void selectInfantPassengers(String quantity){
        this.waitForElementAndClick(SELECT_INFANT_PASSENGERS,"Поле выбора пассажиров младенцев не обнаружено",2);
        String passengers_quantity_xpath = getPassengersQuantity(quantity);
        this.waitForElementAndClick(passengers_quantity_xpath,"Элемент выбора количества пассажиров не обнаружен",2);
    }
    public void checkMaxPassengersQuantity(){
        Integer max_quantity = 6;
        while (max_quantity >0){
            Integer adult_passengers_quantity = max_quantity;
            this.selectAdultPassengers(adult_passengers_quantity.toString());
            this.waitForElementAndClick(SELECT_CHILD_PASSENGERS,"Поле выбора пассажиров детей не обнаружено",2);
            Integer child_passengers_quantity = 6 - adult_passengers_quantity + 1;
            String passengers_quantity_xpath = getPassengersQuantity(child_passengers_quantity.toString());
            this.waitForElementNotPresent(passengers_quantity_xpath,"Возможно выбрать более 6 пассажиров",2);
            this.freeTap();
            --max_quantity;
        }
        max_quantity = 1;
        while ((max_quantity < 4) && (max_quantity >0)){
            Integer adult_passengers_quantity = max_quantity;
            this.selectAdultPassengers(adult_passengers_quantity.toString());
            this.waitForElementAndClick(SELECT_INFANT_PASSENGERS,"Поле выбора пассажиров младенцев не обнаружено",2);
            Integer infant_passengers_quantity = adult_passengers_quantity + 1;
            String passengers_quantity_xpath = getPassengersQuantity(infant_passengers_quantity.toString());
            this.waitForElementNotPresent(passengers_quantity_xpath,"Количество младенцев превышает количество взрослых",2);
            this.freeTap();
            ++max_quantity;
        }
    }
    public void selectCountry(String country){
        this.waitForElementAndClick(SELECT_COUNTRY_FIELD, "Поле выбора страны не обнаружено", 2);
        String country_xpath = getCountryByName(country);
        this.scrollToElementFromList(SELECT_COUNTRY_LIST,country_xpath);
        this.waitForElementAndClick(country_xpath, "Страна '"+country+"' не найдена в списке стран", 2);


    }

    public void openBookingRulesInfo() {
        this.waitForElementAndClick(BOOKING_RULES_INFO_BUTTON, "Кнопка информации о правилах бронирования", 2);
        if (this.isElementLocatedOnTheScreen(PERMISSION_ALLOW_WINDOW)) {
            this.waitForElementAndClick(PERMISSION_ALLOW_BUTTON, "Не обнаружена кнопка разрешения доступа к файлам на устройстве", 2);
        } this.waitForElementPresent(BOOKING_RULES_TITLE,"Экран с правилами бронирования не обнаружен",2);
    }
    public void startSearch(){
        this.waitForElementAndClick(SEARCH_BUTTON,"Кнопка поиска не найдена",2);
        this.waitForElementPresent(PRICE_CALENDAR_BUTTON,"Не осуществлен переход на экран с результатами поиска",5);
    }
}
