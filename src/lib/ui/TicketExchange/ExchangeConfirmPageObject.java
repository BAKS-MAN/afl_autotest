package lib.ui.TicketExchange;

import io.appium.java_client.AppiumDriver;
import lib.ui.MainPageObject;

public class ExchangeConfirmPageObject extends MainPageObject {
    ExchangeConfirmPageObject(AppiumDriver driver){super(driver);}

    protected static final String
            SEARCH_RESULTS_LIST = "id:exchange_details_flights_list",
            FLIGHT_DEPARTURE_TIME = "id:tvFlightTime",
            ORIGIN_CITY = "id:tvFlightFrom",
            DESTINATION_CITY = "id:tvFlightTo",
            DEPARTURE_DATE = "id:tvFlightDate",
            INFO_ESS = "id:textFirst",
            INFO_NO_WAY_BACK = "id:textSecond",
            EXCHANGE_DETAILS_BASE = "id:refund_details_base",
            EXCHANGE_DETAILS_TAXES = "id:refund_details_taxes",
            EXCHANGE_DETAILS_FEE = "id:refund_details_fee",
            EXCHANGE_DETAILS_TOTAL = "id:refund_details_total",
            EXCHANGE_BUTTON = "id:exchange_btn";

    public void confirmExchange(){
        waitForElementPresent(SEARCH_RESULTS_LIST, "Блок с информацией по обмену не найден", 3);
        waitForElementPresent(ORIGIN_CITY, "В результатах поиска отсутствует название города вылета", 3);
        waitForElementPresent(DESTINATION_CITY, "В результатах поиска отсутствует название города прилета", 3);
        waitForElementPresent(FLIGHT_DEPARTURE_TIME, "В результатах поиска отсутствует информация о времени вылета", 3);
        waitForElementPresent(DEPARTURE_DATE, "В результатах поиска отсутствует информация о дате вылета", 3);
        waitForElementPresent(INFO_ESS,"Не найдена информация о необходимости перезаказа доп.услуг",3);
        waitForElementPresent(INFO_NO_WAY_BACK,"Не найдена информация о необходимости завершить обмен",3);
        waitForElementPresent(EXCHANGE_DETAILS_BASE,"Не найдена информация о разнице тарифов",3);
        waitForElementPresent(EXCHANGE_DETAILS_TAXES,"Не найдена информация о налоге",3);
        waitForElementPresent(EXCHANGE_DETAILS_FEE,"Не найдена информация о штрафе за обмен",3);
        waitForElementPresent(EXCHANGE_DETAILS_TOTAL,"Не найдена информация о сумме к доплате",3);
        waitForElementAndClick(EXCHANGE_BUTTON,"Не найдена кнопка подтверждения обмена",3);
    }
}
