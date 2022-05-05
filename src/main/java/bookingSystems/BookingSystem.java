package bookingSystems;

import flights.Flight;
import passengers.Passenger;

import java.util.ArrayList;
import java.util.List;

public class BookingSystem {
    private List<Flight> allFlights;
    private List<Flight> availableFlights;
    private List<Passenger> allPassengers;

    public BookingSystem() {
        this.allFlights = new ArrayList<>();
        this.availableFlights = new ArrayList<>();
        this.allPassengers = new ArrayList<>();
    }

    public List<Flight> getAllFlights() {
        return allFlights;
    }

    public void setAllFlights(List<Flight> allFlights) {
        this.allFlights = allFlights;
    }

    public List<Flight> getAvailableFlights() {
        return availableFlights;
    }

    public void setAvailableFlights(List<Flight> availableFlights) {
        this.availableFlights = availableFlights;
    }

    public List<Passenger> getAllPassengers() {
        return allPassengers;
    }

    public void setAllPassengers(List<Passenger> allPassengers) {
        this.allPassengers = allPassengers;
    }

    @Override
    public String toString() {
        return "BookingSystem{" +
                "allFlights=" + allFlights +
                ", availableFlights=" + availableFlights +
                ", allPassengers=" + allPassengers +
                '}';
    }
}
