package lib.ui.Booking;

import io.appium.java_client.AppiumDriver;
import lib.ui.MainPageObject;

public class ResultsPageObject extends MainPageObject {
    public ResultsPageObject (AppiumDriver driver){super(driver);}

    protected static final String
            SEARCH_RESULTS_LIST = "id:rvSearchResults",
            RESULT_ORIGIN_CITY_NAME = "id:tvCitySource",
            RESULT_DESTINATION_CITY_NAME = "id:tvCityDest",
            RESULT_DESTINATION_CITY_CODE_TPL = "xpath://*[contains(@resource-id,'tvAirportCode')][@text = '{DESTINATION_CITY}']",
            ECONOMY_CLASS_BUTTON = "id:btnEconom",
            COMFORT_CLASS_BUTTON = "id:btnComfort",
            BUSINESS_CLASS_BUTTON = "id:btnBusiness",
            FLIGHT_DURATION = "id:tvDuration",
            FLIGHT_NUMBER = "id:tvAirline",
            FLIGHT_DEPARTURE_TIME = "id:tvTimeSource",
            FLIGHT_ARRIVAL_TIME = "id:tvTimeDest",
            NO_SEARCH_RESULTS = "id:empty",
            SEARCH_ALTERNATIVES_BUTTON = "id:btnSearchAlternatives",
            ALTERNATIVES_RESULTS = "id:rvSearchAlternativeResults",
            ALTERNATIVES_RESULT_CITY_CODE = "id:tvCityCode",
            CHANGE_ROUTE_ALERT = "xpath://*[contains(@resource-id,'tvTitle')][contains(@text,'Маршрут будет изменен')]",
            CHANGE_ROUTE_DESTINATION_CITY_TPL = "xpath://*[contains(@resource-id,'tvDescription')][contains(@text,'{DESTINATION_CITY}')]",
            CHANGE_ROUTE_CANCEL_BUTTON = "id:btnCancel",
            CHANGE_ROUTE_CONTINUE_BUTTON = "id:btnContinue",
            PRICE_CALENDAR_BUTTON = "id:priceCalendar",
            PRICE_CALENDAR_MONTH = "id:month",
            PRICE_CALENDAR_NEXT_BUTTON = "btnNext";



    /*TEMPLATES METHODS */
     private static String getDestinationCityByCode(String new_destination){
        return RESULT_DESTINATION_CITY_CODE_TPL.replace("{DESTINATION_CITY}", new_destination);
    }
    private static String getAlternativeDestinationCityByCode(String new_destination){
        return CHANGE_ROUTE_DESTINATION_CITY_TPL.replace("{DESTINATION_CITY}", new_destination);
    }
    /*TEMPLATES METHODS */

    //Поиск в одну сторону

    public void checkSearchResults(){
        this.waitForElementPresent(SEARCH_RESULTS_LIST,"Блок с результатами поиска не найден",7);
        this.waitForElementPresent(PRICE_CALENDAR_BUTTON,"Не найдена кнопка 'Цены на месяц'",7);
        this.waitForElementPresent(RESULT_ORIGIN_CITY_NAME,"В результатах поиска отсутствует название города вылета",5);
        this.waitForElementPresent(RESULT_DESTINATION_CITY_NAME,"В результатах поиска отсутствует название города прилета",5);
        this.waitForElementPresent(ECONOMY_CLASS_BUTTON,"В результатах поиска отсутствует кнопка выбора эконом класса",5);
        this.waitForElementPresent(COMFORT_CLASS_BUTTON,"В результатах поиска отсутствует кнопка выбора комфорт класса",5);
        this.waitForElementPresent(BUSINESS_CLASS_BUTTON,"В результатах поиска отсутствует кнопка выбора бизнес класса",5);
        this.waitForElementPresent(FLIGHT_DURATION,"В результатах поиска отсутствует информация о продолжительности полета",5);
        this.waitForElementPresent(FLIGHT_NUMBER,"В результатах поиска отсутствует информация о номере рейса",5);
        this.waitForElementPresent(FLIGHT_DEPARTURE_TIME,"В результатах поиска отсутствует информация о времени вылета",5);
        this.waitForElementPresent(FLIGHT_ARRIVAL_TIME,"В результатах поиска отсутствует информация о времени прилета",5);
    }

    public void makeSearchWithoutResults(String origin_city, String destination_city,Boolean OneWay){
        BookingPageObject BookingPageObject = new BookingPageObject(driver);
        BookingPageObject.makeSimpleSearch(origin_city,destination_city,OneWay);
        this.waitForElementPresent(NO_SEARCH_RESULTS,"Информация об отсутствии результатов поиска не обнаружена",7);
    }

    public void makeSearchToAlternativeDestination(String origin_city, String destination_city,Boolean OneWay){
        BookingPageObject BookingPageObject = new BookingPageObject(driver);
        BookingPageObject.makeSimpleSearch(origin_city,destination_city,OneWay);
        this.waitForElementAndClick(SEARCH_ALTERNATIVES_BUTTON, "Кнопка поиска альтернативных рейсов не найдена", 7);
        this.waitForElementPresent(ALTERNATIVES_RESULTS, "Альтернативные маршурты не найдены", 7);
        this.waitForElementAndClick(ALTERNATIVES_RESULT_CITY_CODE, "Не удалось найти альтернативный маршрут для выбора", 7);
        this.waitForElementPresent(CHANGE_ROUTE_ALERT, "Окно изменения маршрута не обнаружено", 5);
        this.waitForElementAndClick(CHANGE_ROUTE_CANCEL_BUTTON,"Кнопка отмены не найдена",3);
        String new_destination = getElementText(ALTERNATIVES_RESULT_CITY_CODE);
        String alt_destination_xpath = getAlternativeDestinationCityByCode(new_destination);
        this.waitForElementAndClick(ALTERNATIVES_RESULT_CITY_CODE, "Не удалось выбрать альтернативный маршрут", 7);
        this.waitForElementPresent(alt_destination_xpath,"В окне подтверждения код города прилета не совпадает с выбранным: '"+new_destination+"'",3);
        this.waitForElementAndClick(CHANGE_ROUTE_CONTINUE_BUTTON,"Кнопка подтверждения изменения маршрута не найдена",3);
        this.waitForElementPresent(SEARCH_RESULTS_LIST,"Блок с результатами поиска не найден",7);
        String destination_xpath = getDestinationCityByCode(new_destination);
        this.waitForElementPresent(destination_xpath,"Код города прилета не совпадает с выбранным: '"+new_destination+"'",3);
    }

}
