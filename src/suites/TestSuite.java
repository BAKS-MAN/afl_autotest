package suites;


import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import tests.Booking.*;

@RunWith(Suite.class)

@Suite.SuiteClasses({
        BookingTests.class,
        FlightDetailsTest.class,
        PassengersTests.class,
        PaymentTests.class,
        ResultsScreenTest.class,
        SummaryTests.class
})

public class TestSuite { }
