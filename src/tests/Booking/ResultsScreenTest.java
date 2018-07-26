package tests.Booking;

import lib.CoreTestCase;
import lib.ui.Booking.ResultsPageObject;
import org.junit.Test;

public class ResultsScreenTest extends CoreTestCase {

    @Test
    public void testSearchWithResults(){
        ResultsPageObject ResultsPageObject = new ResultsPageObject(driver);
        ResultsPageObject.makeOWSearchWithResults("Москва", "Краснодар",false);
    }

    @Test
    public void testSearchWithoutResults(){
        ResultsPageObject ResultsPageObject = new ResultsPageObject(driver);
        ResultsPageObject.makeSearchWithoutResults("Москва","Днепропетровск",false); //По данному маршруту не должно быть результатов
    }
    @Test
    public void testSearchWithAlternatives(){
        ResultsPageObject ResultsPageObject = new ResultsPageObject(driver);
        ResultsPageObject.makeSearchToAlternativeDestination("Москва","Каунас",false);  //По данному маршруту должны быть доступны альтернативные рейсы
    }
}
