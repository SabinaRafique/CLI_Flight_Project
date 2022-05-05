package passengers;

import bookingSystems.BookingSystem;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PassengerService {

    private Passenger passenger;

    BookingSystem bookingSystem = new BookingSystem();

    public PassengerService() {
    }
    // needed to add a constructor to create passenger service in the main class which was needed to trigger
    // the add passenger method



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
        } catch(NullPointerException nullPointerException) {
            System.out.println("Error: Unable to register passenger. Please try again later. ");
        }

        return passenger;
    }


    //----------------------- Remove Passenger Method (Sabina) -------------------------------\\

    public List<Passenger> removePassenger() {
        List<Passenger> passengerList = bookingSystem.getAllPassengers();
        List<Passenger> newPassengerList = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        Passenger passenger = new Passenger("s", "12345678900", "123456", Gender.FEMALE, Nationality.AMERICAN);
        Passenger passenger1 = new Passenger("n", "09876543211", "654321", Gender.FEMALE, Nationality.AMERICAN);
        Passenger passenger2 = new Passenger("p", "09876543211", "876543", Gender.FEMALE, Nationality.AMERICAN);

        passengerList.add(passenger);
        passengerList.add(passenger1);
        passengerList.add(passenger2);

        System.out.println("Please enter the passport number of the passenger you'd like to remove:");
        String testID = scanner.nextLine();

        for(int i = 01; i < passengerList.size(); i++){
            Passenger passengerCheck = passengerList.get(i);

            if(!passengerCheck.getPassportNumber().equals(testID)){
                newPassengerList.add(passengerCheck);
            }
        }
        bookingSystem.setAllPassengers(newPassengerList);
        return bookingSystem.getAllPassengers();
    }

}
