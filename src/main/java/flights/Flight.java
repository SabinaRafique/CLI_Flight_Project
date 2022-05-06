package flights;

import passengers.Passenger;

import java.util.ArrayList;
import java.util.List;

public class Flight {
    private String flightID;
    private int capacity;
    private Location departure;
    private Location destination;
    private List<Passenger> passengers;
    private boolean isAvailable;
    // add flight company + constructor + getter/setter + toString();


    public Flight(String flightID, int capacity, Location departure, Location destination, boolean isAvailable) {
        this.flightID = flightID;
        this.capacity = capacity;
        this.departure = departure;
        this.destination = destination;
        this.passengers = new ArrayList<>();
        this.isAvailable = true;
    }

    public String getFlightID() {
        return flightID;
    }

    public void setFlightID(String flightID) {
        this.flightID = flightID;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public Location getDeparture() {
        return departure;
    }

    public void setDeparture(Location departure) {
        this.departure = departure;
    }

    public Location getDestination() {
        return destination;
    }

    public void setDestination(Location destination) {
        this.destination = destination;
    }

    public List<Passenger> getPassengers() {
        return passengers;
    }

    public void setPassengers(List<Passenger> passengers) {
        this.passengers = passengers;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    @Override
    public String toString() {
        return "Flight{" +
                "flightID=" + flightID +
                ", capacity=" + capacity +
                ", departure=" + departure +
                ", destination=" + destination +
                ", passengers=" + passengers +
                ", isAvailable=" + isAvailable +
                '}';
    }
}
