import model.entities.InfoReservation;
import model.entities.Reservation;
import model.exceptions.DomainException;
import service.ReservationServiceImpl;
import java.text.ParseException;
import java.util.Date;

public class Program {

    private static InfoReservation infoReservation;
    private static ReservationServiceImpl service;
    private static Reservation reservation;
    private static Date checkIn;
    private static Date checkOut;
    private static int roomNumber;

    public static void main(String[] args) {

        try {
            saveReservation();
            service.validateDatesReservation(checkIn, checkOut);
            service.informationsReserve(reservation);

            updateReservation();
            service.informationsReserve(reservation);

        } catch (ParseException parseException) {
            System.out.println("Invalid date format");
        } catch (DomainException exception) {
            System.out.println("Error in reservation: " + exception.getMessage());
        } catch (RuntimeException runtimeException) {
            System.out.println("Unexpected error");
        }
        //infoReservation.closeScanner();
    }

    private static void saveReservation() throws ParseException {
        System.out.println("Room number: ");
        roomNumber = infoReservation.getScanner().nextInt();
        System.out.println("Check-in date (dd/MM/yyy): ");
        checkIn = infoReservation.getSdf().parse(infoReservation.getScanner().next());
        System.out.println("Check-Out date (dd/MM/yyy): ");
        checkOut = infoReservation.getSdf().parse(infoReservation.getScanner().next());

        service.saveReservation(roomNumber, checkIn, checkOut);
    }

    private static void updateReservation() throws ParseException {
        System.out.println();
        System.out.println("Enter data to update the reservation");

        System.out.println("Check-in date (dd/MM/yyy): ");
        checkIn = infoReservation.getSdf().parse(infoReservation.getScanner().next());
        System.out.println("Check-Out date (dd/MM/yyy): ");
        checkOut = infoReservation.getSdf().parse(infoReservation.getScanner().next());

        service.updateDates(checkIn, checkOut);
    }

}