package lib.ui.Booking;

import io.appium.java_client.AppiumDriver;
import lib.ui.MainPageObject;

import java.time.LocalDate;

public class PassengersPageObject extends MainPageObject {
    public PassengersPageObject(AppiumDriver driver){super(driver);}

    protected static final String
            PASSENGERS_BLOCK = "id:flPassengers",
            ALERT_TXT = "xpath://*[@resource-id = 'android:id/message'][contains(@text,'Отчество')]",
            ALERT_OK_BUTTON = "id:android:id/button1",
            PASSENGER_TITLE = "id:tvPassengerHeader",
            PASSENGER_TITLE_TPL = "xpath://*[contains(@resource-id,'tvPassengerHeader')][contains(@text,'{TYPE} {QUEUE_NUMBER}')]",
            PASSENGER_NAME = "id:tvPassengerName",
            PASSENGER_BIRTH_DATE = "id:tvPassengerBirthDate",
            PHONE_FIELD = "id:etPhone",
            EMAIL_FIELD = "id:etEmail",
            FIRST_NAME_FIELD = "id:tlFirstName",
            LAST_NAME_FIELD = "id:tlLastName",
            MIDDLE_NAME_FIELD = "id:tlMiddleName",
            BIRTH_DATE_FIELD  = "id:tlBorn",
            DATE_WIDGET = "id:android:id/datePicker",
            DATE_WIDGET_YEAR_BUTTON = "id:android:id/date_picker_header_year",
            DATE_WIDGET_YEAR_PICKER = "id:android:id/date_picker_year_picker",
            DATE_WIDGET_DATE_PICKER_TPL = "xpath://*[@resource-id = 'android:id/month_view']//*[contains(@text,'{DAY}')]",
            BIRTH_DATE_WIDGET_PREV_MONTH = "id:prev",
            BIRTH_DATE_WIDGET_NEXT_MONTH = "id:next",
            SEX_FIELD = "id:spSex",
            PICKER_SELECTOR_TPL = "xpath://*[@resource-id = 'android:id/text1'][@text = '{VALUE}']",
            CITIZEN_FIELD = "id:spCitizenship",
            SELECT_COUNTRY_LIST = "xpath://android.widget.ListView",
            PASSPORT_TYPE_FIELD = "id:spPassportType",
            PASSPORT_TYPE_PICKET_TPL = "xpath://*[contains(@resource-id,'title')][@text = '{PASSPORT_TYPE}']",
            PASSPORT_COUNTRY_FIELD = "id:spPassportCountry",
            PASSPORT_NUMBER_FIELD = "id:tlPassportNumber",
            PASSPORT_ISSUE_FIELD = "id:tlPassportIssue",
            LOYALTY_PARTNERS_FIELD = "id:spPartners",
            LOYALTY_NUMBER_FIELD = "id:tlLoyalityNumber",
            SAVE_BUTTON = "id:btnSave",
            NEXT_BUTTON = "id:btnNext";



    /*TEMPLATES METHODS */
    private static String getPickerElement (String value){
        return PICKER_SELECTOR_TPL.replace("{VALUE}", value);
    }
    private static String getDatePickerDay(String day){
        return DATE_WIDGET_DATE_PICKER_TPL.replace("{DAY}",day);
    }
    private static String getPassportType(String passport_type){
        return PASSPORT_TYPE_PICKET_TPL.replace("{PASSPORT_TYPE}",passport_type);
    }
    private static String getPassengerToEdit(String passenger_type,String passenger_index){
        return PASSENGER_TITLE_TPL.replace("{TYPE}",passenger_type).replace("{QUEUE_NUMBER}",passenger_index);
    }
    /*TEMPLATES METHODS */

    public void checkPassengersScreen(){
        this.waitForElementPresent(PASSENGERS_BLOCK,"Блок ввода информации о пассажирах не найден",4);
        this.waitForElementPresent(PASSENGER_TITLE,"Заголовок с типом пассажира не найден",2);
        this.waitForElementPresent(PASSENGER_NAME,"Поле с информацией об инициалах пассажира не найдено",2);
        this.waitForElementPresent(PASSENGER_TITLE,"Заголовок с типом второго пассажира не найден",2);
        this.waitForElementPresent(PASSENGER_BIRTH_DATE,"Поле с информацией о дате рождения пассажира не найдено",2);
        this.waitForElementPresent(PHONE_FIELD,"Поле ввода номера телефона не найдено",2);
        this.waitForElementPresent(EMAIL_FIELD,"Поле ввода E-mail не найдено",2);
        this.waitForElementPresent(NEXT_BUTTON,"Кнопка перехода к экрану бронирования не найдена",2);
    }

    public void checkEditPassengerScreen(){
        if (this.isElementPresent(ALERT_TXT)){
            this.waitForElementAndClick(ALERT_OK_BUTTON,"Кнопка закрытия алерта не найдена",3);
        }
        this.waitForElementPresent(FIRST_NAME_FIELD,"Поле ввода имени пассажира не найдено",2);
        this.waitForElementPresent(LAST_NAME_FIELD,"Поле ввода фамилии пассажира не найдено",2);
        this.waitForElementPresent(MIDDLE_NAME_FIELD,"Поле ввода отчества пассажира не найдено",2);
        this.waitForElementPresent(BIRTH_DATE_FIELD,"Поле ввода даты рождения пассажира не найдено",2);
        this.waitForElementPresent(SEX_FIELD,"Поле выбора пола пассажира не найдено",2);
        this.waitForElementPresent(CITIZEN_FIELD,"Поле выбора гражданства пассажира не найдено",2);
        this.waitForElementPresent(PASSPORT_TYPE_FIELD,"Поле выбора типа документа пассажира не найдено",2);
        this.waitForElementPresent(PASSPORT_COUNTRY_FIELD,"Поле выбора страны выдачи документа не найдено",2);
        this.waitForElementPresent(PASSPORT_NUMBER_FIELD,"Поле ввода номера документа не найдено",2);
        this.waitForElementPresent(PASSPORT_ISSUE_FIELD,"Поле ввода срока действия документа не найдено",2);
        this.waitForElementPresent(LOYALTY_PARTNERS_FIELD,"Поле выбора бонусной программы пассажира не найдено",2);
        this.waitForElementPresent(LOYALTY_NUMBER_FIELD,"Поле ввода номера бонусной программы пассажира не найдено",2);
    }

    public void checkEditSelectedPassengerScreen(){
        this.checkEditPassengerScreen();
        this.waitForElementPresent(SAVE_BUTTON,"Кнопка сохранения не найдена",2);
    }

    public void checkEditOnePassengerScreen(){
        this.checkEditPassengerScreen();
        this.waitForElementPresent(PHONE_FIELD,"Поле ввода номера телефона не найдено",2);
        this.waitForElementPresent(EMAIL_FIELD,"Поле ввода E-mail не найдено",2);
        this.waitForElementPresent(NEXT_BUTTON,"Кнопка перехода к экрану бронирования не найдена",2);
    }



    public void searchWithOnePassenger(String origin_city, String destination_city, Boolean OneWay){
        FlightDetailsPageObject FlightDetailsPageObject = new FlightDetailsPageObject(driver);

        FlightDetailsPageObject.searchFlights(origin_city,destination_city,OneWay);
        FlightDetailsPageObject.selectSeatsClassAndFareType("Эконом","Премиум");
        if (!OneWay){
            FlightDetailsPageObject.selectSeatsClassAndFareType("Эконом","Премиум");
        }
        this.checkEditOnePassengerScreen();
    }

    public void searchWithSeveralPassengers(String origin_city, String destination_city, Boolean OneWay){
        BookingPageObject BookingPageObject = new BookingPageObject(driver);
        ResultsPageObject ResultsPageObject = new ResultsPageObject (driver);
        FlightDetailsPageObject FlightDetailsPageObject = new FlightDetailsPageObject(driver);

        BookingPageObject.openBookingScreen();
        BookingPageObject.typeOriginCityAndSelect(origin_city);
        BookingPageObject.typeDestinationCityAndSelect(destination_city);
        if (OneWay){
            BookingPageObject.setOneWayDate();
        } else {
            BookingPageObject.setDateFromAndTo();
        }
        BookingPageObject.swipeUpQuick();
        BookingPageObject.selectAdultPassengers("1");
        BookingPageObject.selectChildPassengers("1");
        BookingPageObject.selectInfantPassengers("1");
        BookingPageObject.startSearch();
        ResultsPageObject.checkSearchResults();
        FlightDetailsPageObject.selectSeatsClassAndFareType("Эконом","Премиум");
        if (!OneWay){
            FlightDetailsPageObject.selectSeatsClassAndFareType("Эконом","Премиум");
        }
        this.checkPassengersScreen();
    }

    public void editPassengerName(String passenger_name){
        this.waitForElementAndSendKeys(FIRST_NAME_FIELD,passenger_name,"Поле ввода имени пассажира не найдено",2);
    }
    public void editPassengerLastName(String passenger_last_name){
        this.waitForElementAndSendKeys(LAST_NAME_FIELD,passenger_last_name,"Поле ввода фамилии пассажира не найдено",2);
    }
    public void editPassengerBirthDate(String passenger_birth_year){
        this.waitForElementAndClick(BIRTH_DATE_FIELD,"Поле ввода даты рождения пассажира не найдено",5);
        this.waitForElementPresent(DATE_WIDGET,"Виджет каленадря не отобразился",3);
        this.waitForElementAndClick(DATE_WIDGET_YEAR_BUTTON,"Элемент выбора года не найден",2);
        String birth_date_year_xpath = getPickerElement(passenger_birth_year);
        this.scrollUpToElementFromList(DATE_WIDGET_YEAR_PICKER,birth_date_year_xpath,10);
        LocalDate date = LocalDate.now();
        String day = Integer.toString(date.getDayOfMonth());
        String birth_date_day_xpath = getDatePickerDay(day);
        this.waitForElementAndClick(birth_date_day_xpath,"Не обнаружена дата для выбора",3);
        this.waitForElementAndClick(ALERT_OK_BUTTON,"Кнопка закрытия виджета не найдена",3);
    }
    public void editPassengerSex(String passenger_sex){
        this.waitForElementAndClick(SEX_FIELD,"Поле выбора пола пассажира не найдено",2);
        String sex_selector_xpath = getPickerElement(passenger_sex);
        this.waitForElementAndClick(sex_selector_xpath,"Поле выбора пола пассажира не найдено",2);
    }
    public void selectCitizenCountry(String citizen_country){
        this.waitForElementAndClick(CITIZEN_FIELD,"Поле выбора гражданства пассажира не найдено",2);
        String country_xpath = getPickerElement(citizen_country);
        this.scrollDownToElementFromList(SELECT_COUNTRY_LIST,country_xpath,30);
        this.waitForElementPresent(country_xpath,"Выбранная страна не отобразилась",3);
    }
   public void selectPassportType(String passport_type){
        this.waitForElementAndClick(PASSPORT_TYPE_FIELD,"Поле выбора типа документа пассажира не найдено",2);
        String passport_type_xpath = getPassportType(passport_type);
        this.waitForElementAndClick(passport_type_xpath,"Поле выбора типа документа не найдено",2);
    }
    public void selectPassportCountry(String passport_country){
        this.waitForElementAndClick(PASSPORT_COUNTRY_FIELD,"Поле выбора страны выдачи документа не найдено",2);
        String country_xpath = getPickerElement(passport_country);
        this.scrollDownToElementFromList(SELECT_COUNTRY_LIST,country_xpath,30);
        this.waitForElementPresent(country_xpath,"Выбранная страна не отобразилась",3);
    }
    public void editPassportNumber(String passport_number){
        this.waitForElementAndSendKeys(PASSPORT_NUMBER_FIELD,passport_number,"Поле ввода номера документа не найдено",2);
    }
    public void editPassportIssueDate(String passport_issue_date){
        this.waitForElementAndClick(PASSPORT_ISSUE_FIELD,"Поле ввода срока действия документа не найдено",5);
        this.waitForElementPresent(DATE_WIDGET,"Виджет каленадря не отобразился",3);
        this.waitForElementAndClick(DATE_WIDGET_YEAR_BUTTON,"Элемент выбора года не найден",2);
        String issue_year_xpath = getPickerElement(passport_issue_date);
        this.scrollDownToElementFromList(DATE_WIDGET_YEAR_PICKER,issue_year_xpath,10);
        LocalDate date = LocalDate.now();
        String day = Integer.toString(date.getDayOfMonth());
        String issue_day_xpath = getDatePickerDay(day);
        this.waitForElementAndClick(issue_day_xpath,"Не обнаружена дата для выбора",3);
        this.waitForElementAndClick(ALERT_OK_BUTTON,"Кнопка закрытия виджета не найдена",3);
    }

    public void editPhoneNumber(String phone_number){
        this.waitForElementAndSendKeys(PHONE_FIELD,phone_number,"Поле ввода номера телефона не найдено",2);
    }
    public void editEmailAddress(String email_address){
        this.waitForElementAndSendKeys(EMAIL_FIELD,email_address,"Поле ввода E-mail не найдено",2);
    }
    public void pressNextButton(){
        this.swipeUpQuick();
        waitForElementAndClick(NEXT_BUTTON,"Кнопка перехода к экрану бронирования не найдена",2);
    }
    public void selectPassengerToEdit(String passenger_type,String passenger_index){
        String passenger_xpath = getPassengerToEdit(passenger_type, passenger_index);
        this.waitForElementAndClick(passenger_xpath, "Пассажир '"+passenger_type+" "+passenger_index+"' не найден",3);
        this.checkEditSelectedPassengerScreen();
    }
    public void pressSaveButton(){
        waitForElementAndClick(SAVE_BUTTON,"Кнопка сохранения изменений не найдена",2);
    }
}
