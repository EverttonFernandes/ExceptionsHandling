import model.entities.InfoReservation;
import model.entities.Reservation;
import model.exceptions.DomainException;
import service.impl.ReservationServiceImpl;

import java.text.ParseException;
import java.util.Date;

public class Program {

    private static Reservation reservation;
    private static Date checkIn;
    private static Date checkOut;
    private static int roomNumber;

    public static void main(String[] args) {

        try {
            inputsAndOutputsOfReservation();
        } catch (ParseException parseException) {
            System.out.println("Invalid date format");
        } catch (DomainException exception) {
            System.out.println("Error in reservation: " + exception.getMessage());
        } catch (RuntimeException runtimeException) {
            System.out.println("Unexpected error");
        }
        new InfoReservation().closeScanner();
    }

    private static void inputsAndOutputsOfReservation() throws ParseException {
        saveReservation();
        ReservationServiceImpl.informationsReserve(reservation);

        updateReservation(reservation);
        ReservationServiceImpl.informationsReserve(reservation);
    }

    private static void saveReservation() throws ParseException {
        System.out.println("Room number: ");
        roomNumber = new InfoReservation().getScanner().nextInt();
        System.out.println("Check-in date (dd/MM/yyy): ");
        checkIn = new InfoReservation().getSdf().parse(new InfoReservation().getScanner().next());
        System.out.println("Check-Out date (dd/MM/yyy): ");
        checkOut = new InfoReservation().getSdf().parse(new InfoReservation().getScanner().next());

        reservation = ReservationServiceImpl.saveReservation(roomNumber, checkIn, checkOut);
    }

    private static void updateReservation(Reservation reservation) throws ParseException {
        System.out.println();
        System.out.println("Enter data to update the reservation");

        System.out.println("Check-in date (dd/MM/yyy): ");
        checkIn = new InfoReservation().getSdf().parse(new InfoReservation().getScanner().next());
        System.out.println("Check-Out date (dd/MM/yyy): ");
        checkOut = new InfoReservation().getSdf().parse(new InfoReservation().getScanner().next());

        ReservationServiceImpl.updateDates(checkIn, checkOut, reservation);
    }

}