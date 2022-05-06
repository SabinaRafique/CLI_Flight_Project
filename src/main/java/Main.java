import bookingSystems.BookingSystem;
import services.Service;

public class Main {


    public static void main(String[] args) {
        BookingSystem bookingSystem = new BookingSystem();
        Service service = new Service();

        service.addFlight();
        service.addPassenger();
        service.bookPassengerOnFlight();
//        service.displayAvailableFlights();

    }
}
