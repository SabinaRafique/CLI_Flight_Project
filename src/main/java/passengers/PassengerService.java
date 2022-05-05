package passengers;

import bookingSystems.BookingSystem;
import flights.Flight;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PassengerService {

    BookingSystem bookingSystem = new BookingSystem();

    public PassengerService() {
    }
    // needed to add a constructor to create passenger service in the main class which was needed to trigger
    // the add passenger method



    //-------------------------------- Add Passenger Method (Sabina) -------------------------------\\

    public Passenger addPassenger() {
        System.out.println("What is the passenger's name?");
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


        try {
            List<Passenger> passengerList = bookingSystem.getAllPassengers();
            passengerList.add(passenger);
        } catch(NullPointerException nullPointerException) {
            System.out.println("Error: Unable to register passenger. Please try again later. ");
        }
        return passenger;
    }


    //----------------------- Remove Passenger Method (Sabina) -------------------------------\\


}
