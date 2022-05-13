import flights.Flight;
import flights.Location;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import passengers.Gender;
import passengers.Nationality;
import passengers.Passenger;


import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ServiceTest {
    Flight flight;
    Passenger passenger;

    @BeforeEach
    public void setUp() {
        this.flight = new Flight("1234", 100, Location.LONDON, Location.DUBAI, true);
        this.passenger = new Passenger("John Doe", "02085586543", "111111", Gender.MALE, Nationality.AMERICAN);
    }

    //-------------------------------- Flight Tests -------------------------------\\

    @Test
    public void hasFlightID() {
        assertThat(flight.getFlightID()).isNotNull();
        assertThat(flight.getFlightID()).isEqualTo("1234");
    }

    @Test
    public void hasCapacity() {
        assertThat(flight.getCapacity()).isLessThan(200);
    }

    @Test
    public void hasDepartureLocation() {
        assertThat(flight.getDeparture()).isEqualTo(Location.LONDON);
    }

    @Test
    public void hasDestination() {
        assertThat(flight.getDestination()).isEqualTo(Location.DUBAI);
    }

    //-------------------------------- Passenger Tests -------------------------------\\

    @Test
    public void hasName () {
        assertThat(passenger.getName()).isEqualTo("John Doe");
    }

    @Test
    public void hasTelName () {
        assertThat(passenger.getTelNumber()).isEqualTo("02085586543");
    }

    @Test
    public void hasPassportNumber() {
        assertThat(passenger.getPassportNumber()).isEqualTo("111111");
    }

    @Test
    public void hasGender() {
        assertThat(passenger.getGender()).isEqualTo(Gender.MALE);
    }

    @Test
    public void hasNationality() {
        assertThat(passenger.getNationality()).isEqualTo(Nationality.AMERICAN);
    }


}

