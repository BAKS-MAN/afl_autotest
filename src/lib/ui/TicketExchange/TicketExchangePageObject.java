package lib.ui.TicketExchange;

import io.appium.java_client.AppiumDriver;
import lib.ui.MainPageObject;
import lib.ui.Reservation.ReservationInfoPageObject;

public class TicketExchangePageObject extends MainPageObject {
    public TicketExchangePageObject (AppiumDriver driver){super(driver);}

    private void goToExchangeRouteScreen(){
        ReservationInfoPageObject ReservationInfoPageObject = new ReservationInfoPageObject(driver);
        ExchangePaxSelectPageObject ExchangePaxSelectPageObject = new ExchangePaxSelectPageObject(driver);
        ReservationInfoPageObject.exchangeTicket();
        ExchangePaxSelectPageObject.confirmPassengers();
    }

    public void exchangeDefault(){
        ExchangeRoutePageObject ExchangeRoutePageObject = new ExchangeRoutePageObject(driver);
        ExchangeResultsPageObject ExchangeResultsPageObject = new ExchangeResultsPageObject(driver);
        ExchangeConfirmPageObject ExchangeConfirmPageObject = new ExchangeConfirmPageObject(driver);
        goToExchangeRouteScreen();
        ExchangeRoutePageObject.searchWithoutChanges();
        ExchangeResultsPageObject.selectResult();
//        ExchangeConfirmPageObject.confirmExchange();
    }

    public void exchangeWithDateChange(){
        ExchangeRoutePageObject ExchangeRoutePageObject = new ExchangeRoutePageObject(driver);
        ExchangeResultsPageObject ExchangeResultsPageObject = new ExchangeResultsPageObject(driver);
        ExchangeConfirmPageObject ExchangeConfirmPageObject = new ExchangeConfirmPageObject(driver);
        goToExchangeRouteScreen();
        ExchangeRoutePageObject.searchWithAnotherDate();

        ExchangeConfirmPageObject.confirmExchange();
    }

    public void exchangeWithOriginCityChange(){
        ExchangeRoutePageObject ExchangeRoutePageObject = new ExchangeRoutePageObject(driver);
        ExchangeResultsPageObject ExchangeResultsPageObject = new ExchangeResultsPageObject(driver);
        ExchangeConfirmPageObject ExchangeConfirmPageObject = new ExchangeConfirmPageObject(driver);
        goToExchangeRouteScreen();
        ExchangeRoutePageObject.searchWithAnotherOriginCity("Санкт-Петербург");

        ExchangeConfirmPageObject.confirmExchange();
    }

    public void exchangeWithDestinationCityChange(){
        ExchangeRoutePageObject ExchangeRoutePageObject = new ExchangeRoutePageObject(driver);
        ExchangeResultsPageObject ExchangeResultsPageObject = new ExchangeResultsPageObject(driver);
        ExchangeConfirmPageObject ExchangeConfirmPageObject = new ExchangeConfirmPageObject(driver);
        goToExchangeRouteScreen();
        ExchangeRoutePageObject.searchWithAnotherDestinationCity("Красноярск");

        ExchangeConfirmPageObject.confirmExchange();
    }

    public void exchangeWithoutSecondSegment(){
        ExchangeRoutePageObject ExchangeRoutePageObject = new ExchangeRoutePageObject(driver);
        ExchangeResultsPageObject ExchangeResultsPageObject = new ExchangeResultsPageObject(driver);
        ExchangeConfirmPageObject ExchangeConfirmPageObject = new ExchangeConfirmPageObject(driver);
        goToExchangeRouteScreen();
        ExchangeRoutePageObject.searchWithoutSecondSegment();

        ExchangeConfirmPageObject.confirmExchange();
    }
}
