import flights.Flight;
import flights.FlightService;
import passengers.Passenger;
import passengers.PassengerService;

import java.util.List;

public class Main {


    public static void main(String[] args) {
        PassengerService passengerService = new PassengerService();
        Passenger passenger = passengerService.addPassenger();

        List<Passenger> passengerList = passengerService.removePassenger();

        FlightService flightService = new FlightService();
        Flight flight = flightService.addFlight();

    }
}
