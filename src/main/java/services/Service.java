package services;

import bookingSystems.BookingSystem;
import flights.Flight;
import flights.Location;
import passengers.Gender;
import passengers.Nationality;
import passengers.Passenger;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Service {

    BookingSystem bookingSystem = new BookingSystem();
    public Service() {
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


        while (departure == destination) {
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
        } catch (NullPointerException nullPointerException) {
            System.out.println("Error: Unable to add flight. Please try again later. ");
        }
        System.out.println("The flight has been added successfully!");
        return flight;
    }


    //-------------------------------- Cancel Flight Method (Sabina) -------------------------------\\

    public List<Flight> cancelFlight() {
        List<Flight> flightList = bookingSystem.getAllFlights();

        List<Flight> newFlightList = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

//        Flight flights = new Flight("1234", 100, Location.BELGIUM, Location.DUBAI, true);
//        Flight flights1 = new Flight("2468", 200, Location.LONDON, Location.MILAN, true);
//        Flight flights2 = new Flight("9876", 300, Location.NEWYORK, Location.TOKYO, true);
//
//
//        flightList.add(flights);
//        flightList.add(flights1);
//        flightList.add(flights2);

        System.out.println(flightList);
        System.out.println("Please enter the flight ID you'd like to remove:");
        String testID = scanner.nextLine();

        for (int i = 0; i < flightList.size(); i++) {
            Flight flightCheck = flightList.get(i);

            if (!flightCheck.getFlightID().equals(testID)) {
                newFlightList.add(flightCheck);
            }
        }
        System.out.println("Flight " + testID + " has been removed.");
        bookingSystem.setAllFlights(newFlightList);
        return bookingSystem.getAllFlights();
    }

    //-------------------------------- Display Available Flights (Sabina) -------------------------------\\

    public void displayAvailableFlights() {
        List<Flight> flightList = bookingSystem.getAllFlights();
        System.out.println(flightList);
        System.out.println("Please see all available flights");
    }

    //-------------------------------- Add Passenger Method (Sabina) -------------------------------\\

    public Passenger addPassenger() {
        System.out.println("Please enter the passenger's name:");
        Scanner scanner = new Scanner(System.in);
        String passengerName = scanner.nextLine();

        String telNumber = "";
        int count = 0;

        do {
            if (count == 0) {
                System.out.println("Please enter your telephone number (11 digits):");
                telNumber = scanner.nextLine();
                count++;
            } else {
                System.out.println("Error: your telephone number should be 11 digits. Please try again.");
                telNumber = scanner.nextLine();
            }
        } while (telNumber.length() != 11);


        String passportNumber = "";
        int count2 = 0;

        do {
            if (count2 == 0) {
                System.out.println("Please enter your passport number (6 digits):");
                passportNumber = scanner.nextLine();
                count2++;
            } else {
                System.out.println("Error: your passport number should be 6 digits. Please try again.");
                passportNumber = scanner.nextLine();
            }
        } while (passportNumber.length() != 6);

        System.out.println("Please select your gender");
        Object selection = JOptionPane.showInputDialog(null, "Select your gender", "Gender",
                JOptionPane.INFORMATION_MESSAGE, null, Gender.values(), Gender.values()[0]);
        Gender gender = Gender.valueOf(selection.toString());
        System.out.println(selection);


        System.out.println("Please select your nationality");
        Object selection2 = JOptionPane.showInputDialog(null, "Choose your nationality",
                "Nationality", JOptionPane.INFORMATION_MESSAGE, null, Nationality.values(), Nationality.values()[0]);
        Nationality nationality = Nationality.valueOf(selection2.toString());
        System.out.println(selection2);

        Passenger passenger = new Passenger(passengerName, telNumber, passportNumber, gender, nationality);
        System.out.println(passenger);

        List<Passenger> passengerList = bookingSystem.getAllPassengers();

        try {
            passengerList.add(passenger);
        } catch (NullPointerException nullPointerException) {
            System.out.println("Error: Unable to register passenger. Please try again later. ");
        }
        System.out.println("Passenger has been added successfully");
        return passenger;
    }


    //----------------------- Remove Passenger Method (Sabina) -------------------------------\\

    public List<Passenger> removePassenger() {
        List<Passenger> passengerList = bookingSystem.getAllPassengers();
        List<Passenger> newPassengerList = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

//        Passenger passenger = new Passenger("s", "12345678900", "123456", Gender.FEMALE, Nationality.AMERICAN);
//        Passenger passenger1 = new Passenger("n", "09876543211", "654321", Gender.FEMALE, Nationality.AMERICAN);
//        Passenger passenger2 = new Passenger("p", "09876543211", "876543", Gender.FEMALE, Nationality.AMERICAN);
//
//        passengerList.add(passenger);
//        passengerList.add(passenger1);
//        passengerList.add(passenger2);

        System.out.println("Please enter the passport number of the passenger you'd like to remove:");
        String testID = scanner.nextLine();

        for (int i = 0; i < passengerList.size(); i++) {
            Passenger passengerCheck = passengerList.get(i);

            if (!passengerCheck.getPassportNumber().equals(testID)) {
                newPassengerList.add(passengerCheck);
            }
        }
        System.out.println("Passenger with " + testID + " has been removed.");

        bookingSystem.setAllPassengers(newPassengerList);
        return bookingSystem.getAllPassengers();
    }

    //-------------------------------- Book A Passenger On A Flight Method (Sabina) -------------------------------\\

    public void bookPassengerOnFlight() {
        List<Passenger> passengerList = bookingSystem.getAllPassengers();
        List<Flight> flightList = bookingSystem.getAllFlights();
        List<Flight> availableFlightList = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter the customer's passport number");
        String passportNumber = scanner.nextLine();
        Passenger passenger = null;

        for (int i = 0; i < passengerList.size(); i++) {
            Passenger passengerCheck = passengerList.get(i);
            if (passengerCheck.getPassportNumber().equals(passportNumber)) {
                passenger = passengerList.get(i);
            }
        }

        System.out.println("Please enter the ID of the flight you'd like to be booked on");
        String flightID = scanner.nextLine();
        Flight flight = null;

        for (int i = 0; i < flightList.size(); i++) {
            Flight flightCheck = flightList.get(i);
            if (flightCheck.getFlightID().equals(flightID)) {
                flight = flightList.get(i);
            }
        }

        if (flight.isAvailable()) {
            List<Passenger> currentPassengerList = flight.getPassengers();
            currentPassengerList.add(passenger);
            if (flight.getCapacity() == flight.getPassengers().size()) {
                flight.setAvailable(false);
                for (int i = 0; i < bookingSystem.getAllFlights().size(); i++) {
                    Flight flightCheck = flightList.get(i);
                    if (!flightCheck.getFlightID().equals(flight.getFlightID())) {
                        availableFlightList.add(flightList.get(i));
                    }
                }
            }

        } else {
            System.out.println("Sorry this flight is fully booked");
        }

        System.out.println("You've been booked onto flight " + flightID);
//
//        System.out.println(bookingSystem);
//        System.out.println(flight);
    }
}
