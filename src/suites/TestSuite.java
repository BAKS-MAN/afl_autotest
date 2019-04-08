package suites;


import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import tests.Booking.*;
import tests.Reservation.ReservationInfoTests;

@RunWith(Suite.class)

@Suite.SuiteClasses({
        BookingTests.class,
        ResultsScreenTest.class,
        FlightDetailsTest.class,
        PassengersTests.class,
        EssTests.class,
        PaymentTests.class,
        SummaryTests.class,
        ReservationInfoTests.class
})

public class TestSuite { }
