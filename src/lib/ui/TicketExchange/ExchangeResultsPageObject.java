package lib.ui.TicketExchange;

import io.appium.java_client.AppiumDriver;
import lib.ui.MainPageObject;

import java.util.ArrayList;

public class ExchangeResultsPageObject extends MainPageObject {
    ExchangeResultsPageObject(AppiumDriver driver){super(driver);}

    protected static final String
            SEARCH_RESULTS_LIST = "id:exchange_flights_list",
            RESULTS_LAYOUT = "id:refund_fragment_container",
            NO_RESULTS_TEXT = "id:exchange_variants_placeholder",
            FLIGHT_NUMBER = "id:tvAirline",
            FLIGHT_DEPARTURE_TIME = "id:tvTimeSource",
            FLIGHT_ARRIVAL_TIME = "id:tvTimeDest",
            ORIGIN_CITY = "id:tvCitySource",
            DESTINATION_CITY = "id:tvCityDest",
            DEPARTURE_DATE = "id:tvDateSource",
            FLIGHT_DURATION = "id:tvDuration",
            ECONOMY_CLASS_BUTTON = "id:btnEconom",
            COMFORT_CLASS_BUTTON = "id:btnComfort",
            BUSINESS_CLASS_BUTTON = "id:btnBusiness";

    private void checkExchangeSearchResults(){
        waitForElementPresent(RESULTS_LAYOUT,"Не отобразился экран с результатом поиска рейсов к обмену",10);
        if (isElementPresent(NO_RESULTS_TEXT)){
            throw new AssertionError("Невозможно завершить тест: "+getElementValue(NO_RESULTS_TEXT,"text"));
        } else {
            this.waitForElementPresent(SEARCH_RESULTS_LIST, "Блок с результатами поиска не найден", 20);
            this.waitForElementPresent(FLIGHT_NUMBER, "В результатах поиска отсутствует информация о номере рейса", 5);
            this.waitForElementPresent(ORIGIN_CITY, "В результатах поиска отсутствует название города вылета", 3);
            this.waitForElementPresent(DESTINATION_CITY, "В результатах поиска отсутствует название города прилета", 3);
            this.waitForElementPresent(FLIGHT_DEPARTURE_TIME, "В результатах поиска отсутствует информация о времени вылета", 3);
            this.waitForElementPresent(FLIGHT_ARRIVAL_TIME, "В результатах поиска отсутствует информация о времени прилета", 3);
            this.waitForElementPresent(DEPARTURE_DATE, "В результатах поиска отсутствует информация о дате вылета", 5);
            this.waitForElementPresent(FLIGHT_DURATION, "В результатах поиска отсутствует информация о продолжительности полета", 3);
        }
    }

    private void checkClassAndSelectResult(){
        ExchangeRoutePageObject ExchangeRoutePageObject = new ExchangeRoutePageObject(driver);
        ArrayList exchangeParameters = ExchangeRoutePageObject.saveParameters();
        System.out.println(exchangeParameters.get(3));

//        switch (ExchangeRoutePageObject.saveParameters().get(3)){
//            case "Эконом" : waitForElementAndClick(ECONOMY_CLASS_BUTTON, "В результатах поиска отсутствует кнопка выбора эконом класса", 3);
//                        break;
//            case "Комфорт" : waitForElementAndClick(COMFORT_CLASS_BUTTON, "В результатах поиска отсутствует кнопка выбора комфорт класса", 3);
//                break;
//            case "Бизнес" : waitForElementAndClick(BUSINESS_CLASS_BUTTON, "В результатах поиска отсутствует кнопка выбора бизнес класса", 3);
//                break;
//        }
    }

    public void selectResult(){
        checkExchangeSearchResults();
        checkClassAndSelectResult();
    }

}
