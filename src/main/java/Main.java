import bookingSystems.BookingSystem;
import services.Service;

import java.io.IOException;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        BookingSystem bookingSystem = new BookingSystem();
        Service service = new Service();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to BNTA's Flight Booker!");

        //-------------------------------- Menu (Hamza/Mohamed) -------------------------------\\

        boolean exit = false;
        int menuChoice;
        while (!exit) {
            System.out.println("Please select one of the options below:");
            System.out.println("[1] Add a new Passenger");
            System.out.println("[2] Add new Flight");
            System.out.println("[3] Display All Flights");
            System.out.println("[4] Cancel Flight");
            System.out.println("[5] Book passenger onto flight");
            System.out.println("[6] Remove Passenger from Flight");
            System.out.println("[7] Exit");
            System.out.println("Please select a number to choose an option:");

            menuChoice = scanner.nextInt();

            switch (menuChoice) {
                case 1:
                    service.addPassenger();
                    break;
                case 2:
                    service.addFlight();
                    break;
                case 3:
                    service.displayAvailableFlights();
                    break;
                case 4:
                    service.cancelFlight();
                    break;
                case 5:
                    service.bookPassengerOnFlight();
                    break;
                case 6:
                    service.removePassenger();
                    break;

                case 7:
                    System.out.println("\nExit");
                    exit = true;
                    break;
                default:
                    System.out.println("\nPlease enter an option\n");
                    break;
            }
        }
    }
}