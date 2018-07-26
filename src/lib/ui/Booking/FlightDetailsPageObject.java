package lib.ui.Booking;

import io.appium.java_client.AppiumDriver;
import lib.ui.MainPageObject;

public class FlightDetailsPageObject extends MainPageObject {
    public FlightDetailsPageObject(AppiumDriver driver){super(driver);}

    protected static final String
            FLIGHT_INFO = "id:ru.aeroflot.afltest:id/llFlights",
            TARIFF_INFO = "id:ru.aeroflot.afltest:id/llPrices",
            ECONOMY_CLASS_BUTTON= "id:ru.aeroflot.afltest:id/tvEconom",
            COMFORT_CLASS_BUTTON = "id:ru.aeroflot.afltest:id/tvComfort",
            BUSINESS_CLASS_BUTTON = "id:ru.aeroflot.afltest:id/tvBusiness",
            FLIGHT_DURATION = "id:ru.aeroflot.afltest:id/tvTimeInterval",
            FLIGHT_NUMBER = "id:ru.aeroflot.afltest:id/tvFlightName",
            FLIGHT_MODEL = "id:ru.aeroflot.afltest:id/tvAirplaneName",
            FLIGHT_DEPARTURE_TIME = "id:ru.aeroflot.afltest:id/tvDepartureTime",
            FLIGHT_ARRIVAL_TIME = "id:ru.aeroflot.afltest:id/tvArrivalTime",
            FLIGHT_DEPARTURE_CITY = "id:ru.aeroflot.afltest:id/tvOriginCity",
            FLIGHT_ARRIVAL_CITY = "id:ru.aeroflot.afltest:id/tvDestCity",
            FLIGHT_DEPARTURE_AIRPORT = "id:ru.aeroflot.afltest:id/tvOriginAirport",
            FLIGHT_ARRIVAL_AIRPORT = "id:ru.aeroflot.afltest:id/tvDestAirport",
            FLIGHT_TRANSFER_CITY = "id:ru.aeroflot.afltest:id/tvTransferCity",
            FLIGHT_TRANSFER_AIRPORT = "id:ru.aeroflot.afltest:id/tvTransferAirport",
            FLIGHT_TRANSFER_TIME = "id:ru.aeroflot.afltest:id/tvTransferTime",
            FARE_CLASS_NAME = "id:ru.aeroflot.afltest:id/class_name",
            FARE_TYPE = "id:ru.aeroflot.afltest:id/tvFareClass",
            FARE_INFO = "id:ru.aeroflot.afltest:id/tvFareInfo",
            SELECT_FARE_TYPE_TPL = "xpath://*[@resource-id = 'ru.aeroflot.afltest:id/tvFareClass'][contains(@text,'{FARE_TYPE}')]",
            NEXT_BUTTON = "id:ru.aeroflot.afltest:id/btnNext";



    /*TEMPLATES METHODS */
    private static String getFareType(String fare_type){
        return SELECT_FARE_TYPE_TPL.replace("{FARE_TYPE}", fare_type);
    }
    /*TEMPLATES METHODS */

    public void selectSeatsClass(String seats_class){
        if (seats_class.equals("Эконом")){
            if (getElementText(ECONOMY_CLASS_BUTTON).equals("Продано") && (!getElementText(BUSINESS_CLASS_BUTTON).equals("Продано"))){
                this.waitForElementAndClick(BUSINESS_CLASS_BUTTON,"Кнопка выбора бизнес класса не найдена",5);
            }else {
                this.waitForElementAndClick(ECONOMY_CLASS_BUTTON, "Кнопка выбора эконом класса не найдена", 5);
            }
        } else if (seats_class.equals("Комфорт")){
            if (getElementText(COMFORT_CLASS_BUTTON).equals("Продано")&& (!getElementText(BUSINESS_CLASS_BUTTON).equals("Продано"))){
                this.waitForElementAndClick(BUSINESS_CLASS_BUTTON,"Кнопка выбора бизнес класса не найдена",5);
            }else {
                this.waitForElementAndClick(ECONOMY_CLASS_BUTTON,"Кнопка выбора комфорт класса не найдена",5);
            }
        } else if (seats_class.equals("Бизнес")){
            if (getElementText(BUSINESS_CLASS_BUTTON).equals("Продано")){
                this.waitForElementAndClick(ECONOMY_CLASS_BUTTON, "Кнопка выбора эконом класса не найдена", 5);
            }else {
                this.waitForElementAndClick(BUSINESS_CLASS_BUTTON,"Кнопка выбора бизнес класса не найдена",5);
            }
        } else {
            throw new AssertionError("Класс указан неверно, нужно указать 'Эконом'/'Комфорт'/'Бизнес'");
        }
    }

    public void checkFlightDetailsScreen(){
        this.waitForElementPresent(FLIGHT_INFO,"Блок с информацией о перелете не найден",2);
        this.waitForElementPresent(TARIFF_INFO,"Блок с информацией о перелете не найден",2);
        this.waitForElementPresent(FLIGHT_DURATION,"Информация о времени полета не найдена",2);
        this.waitForElementPresent(FLIGHT_NUMBER,"Информация о номере рейса не найдена",2);
        this.waitForElementPresent(FLIGHT_MODEL,"Информация о модели борта не найдена",2);
        this.waitForElementPresent(FLIGHT_DEPARTURE_TIME,"Информация о времени вылета не найдена",2);
        this.waitForElementPresent(FLIGHT_ARRIVAL_TIME,"Информация о времени прибытия не найдена",2);
        this.waitForElementPresent(FLIGHT_DEPARTURE_CITY,"Информация о городе вылета не найдена",2);
        this.waitForElementPresent(FLIGHT_ARRIVAL_CITY,"Информация о городе прибытия не найдена",2);
        this.waitForElementPresent(FLIGHT_DEPARTURE_AIRPORT,"Информация об аэропорте вылета не найдена",2);
        this.waitForElementPresent(FLIGHT_ARRIVAL_AIRPORT,"Информация об аэропорте прибытия не найдена",2);
        if (this.isElementPresent(FLIGHT_TRANSFER_CITY)){ //Если есть инфа о пересадке, то проверяем элементы, относящиеся к пересадке
            this.waitForElementPresent(FLIGHT_TRANSFER_CITY,"Информация о городе пересадки не найдена",2);
            this.waitForElementPresent(FLIGHT_TRANSFER_AIRPORT,"Информация об аэропорте пересадки не найдена",2);
            this.waitForElementPresent(FLIGHT_TRANSFER_TIME,"Информация о времени пересадки не найдена",2);
        }
        this.swipeUpToFindElement(FARE_INFO,"Кнопка информации о тарифах не найдена",4);
        this.waitForElementPresent(FARE_CLASS_NAME,"Информация о классе не найдена",2);
        this.waitForElementPresent(FARE_TYPE,"Информация с описаниями тарифов не найдена",2);

    }

    public void selectFareType(String fare_type){
        String fare_type_xpath = getFareType(fare_type);
        this.swipeLeftToFindElement(FARE_TYPE,fare_type_xpath,"Указанный тариф '"+fare_type+"' не найден.",5);
        waitForElementAndClick(fare_type_xpath,"Не удалось выбрать тариф",3);
        waitForElementAndClick(NEXT_BUTTON,"Кнопка перехода к бронированию не найдена",3);
    }

    public void selectSeatsClassAndFareType(String seats_class, String fare_type){
        this.selectSeatsClass(seats_class);
        this.checkFlightDetailsScreen();
        selectFareType(fare_type);
    }


}
