package flights;

import bookingSystems.BookingSystem;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FlightService {

    BookingSystem bookingSystem = new BookingSystem();

    public FlightService() {
    }


    //-------------------------------- Add Flight Method (Sabina) -------------------------------\\

   public Flight addFlight() {
        Scanner scanner = new Scanner(System.in);
        String flightID = "";
        int flightCount = 0;

        do {
            if (flightCount == 0) {
                System.out.println("Please enter the flight ID (4 digits):");
                flightID = scanner.nextLine();
                flightCount++;
            } else {
                System.out.println("Error: your flight ID should be 4 digits. Please try again");
                flightID = scanner.nextLine();
            }

        } while (flightID.length() != 4);

        System.out.println("Please enter the flight capacity:");
        int flightCapacity = scanner.nextInt();

        System.out.println("Please select your departure location");
        Object departure = JOptionPane.showInputDialog(null, "Select your departure location", "Location",
                JOptionPane.INFORMATION_MESSAGE, null, Location.values(), Location.values()[0]);
        Location departureLocation = Location.valueOf(departure.toString());
        System.out.println(departure);


        System.out.println("Please select your flight destination");
        Object destination = JOptionPane.showInputDialog(null, "Select your flight destination", "Location",
                JOptionPane.INFORMATION_MESSAGE, null, Location.values(), Location.values()[0]);


        while(departure == destination){
            System.out.println("Error: Destination cannot be the same as the departure location. Please select the destination.");
            destination = JOptionPane.showInputDialog(null, "Select your flight destination", "Location",
                    JOptionPane.INFORMATION_MESSAGE, null, Location.values(), Location.values()[0]);
        }

       Location flightDestination = Location.valueOf(destination.toString());
       System.out.println(destination);

        Flight flight = new Flight(flightID, flightCapacity, departureLocation, flightDestination, true);

        System.out.println(flight);

        List<Flight> flightList = bookingSystem.getAllFlights();

        try {
            flightList.add(flight);
        } catch(NullPointerException nullPointerException) {
            System.out.println("Error: Unable to add flight. Please try again later. ");
        }
        return flight;
    }

    //-------------------------------- Cancel Flight Method (Sabina) -------------------------------\\

    public List<Flight> cancelFlight() {
        List<Flight> flightList = bookingSystem.getAllFlights();
        List<Flight> newFlightList = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        Flight flights = new Flight("1234", 100, Location.BELGIUM, Location.DUBAI, true);
        Flight flights1 = new Flight("2468", 200, Location.LONDON, Location.MILAN, true);
        Flight flights2 = new Flight("9876", 300, Location.NEWYORK, Location.TOKYO, true);


        flightList.add(flights);
        flightList.add(flights1);
        flightList.add(flights2);


        System.out.println("Please enter the flight ID you'd like to remove:");
        String testID = scanner.nextLine();

        for(int i = 01; i < flightList.size(); i++){
            Flight flightCheck = flightList.get(i);

            if(!flightCheck.getFlightID().equals(testID)){
                newFlightList.add(flightCheck);
            }
        }
        bookingSystem.setAllFlights(newFlightList);
        return bookingSystem.getAllFlights();
    }


}
