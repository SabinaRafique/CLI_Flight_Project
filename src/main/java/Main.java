import bookingSystems.BookingSystem;
import services.Service;

import java.io.IOException;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        BookingSystem bookingSystem = new BookingSystem();
        Service service = new Service();
        Scanner scanner = new Scanner(System.in);


//        service.addPassenger();
//        service.removePassenger();
//        service.addFlight();
//        service.cancelFlight();
//        service.bookPassengerOnFlight();
//        service.displayAvailableFlights();

        // 1) Add New Flights - addFlight();
        // 2) Add a New Passenger - addPassenger();
        // 3) Book a Passenger on to a Flight
        // 4) Cancel a Flight - cancelFlight();
        // 5) Remove a Passenger -  removePassenger();
        // 6) Display All Available Flights - displayAvailableFlights();
        // 7) Back to Main Menu

//        public void menuSelection() throws IOException {
            boolean exit = false;
            int userSelection;
            while (!exit) {
                System.out.println("Please select one of the options below:");
                System.out.println("[1] Add a new Passenger");
                System.out.println("[2] Cancel Flight");
                System.out.println("[3] Display All Flights");
                System.out.println("[4] Add new Flight");
                System.out.println("[5] Book passenger onto flight");
                System.out.println("[6] Remove Passenger from Flight");
                System.out.println("[0] E  xit");
                System.out.println("Please select a number to choose an option:");

                userSelection = scanner.nextInt();

                switch (userSelection) {
                    case 1:
                        service.addPassenger();
                        break;
                    case 2:
                        service.cancelFlight();
                        break;
                    case 3:
                        service.displayAvailableFlights();
                        break;
                    case 4:
                        service.addFlight();
                        break;
                    case 5:
                        service.bookPassengerOnFlight();
                        break;
                    case 6:
                        service.removePassenger();
                        break;

                    case 0:
                        System.out.println("\nExit");
                        exit = true;
                        break;
                    default:
                        System.out.println("\nPlease enter an option\n");
                        break;
                }
            }

//        }
    }
}