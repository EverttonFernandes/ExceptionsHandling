import model.entities.Reservation;
import model.exceptions.DomainException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        try {
            System.out.println("Room number: ");
            int number = scanner.nextInt();
            System.out.println("Check-in date (dd/MM/yyy): ");
            Date checkIn = sdf.parse(scanner.next());
            System.out.println("Check-Out date (dd/MM/yyy): ");
            Date checkOut = sdf.parse(scanner.next());


            Reservation reservation = new Reservation(number, checkIn, checkOut);
            System.out.println("Reservation: " + reservation);
            System.out.println();
            System.out.println("Enter data to update the reservation");

            System.out.println("Check-in date (dd/MM/yyy): ");
            checkIn = sdf.parse(scanner.next());
            System.out.println("Check-Out date (dd/MM/yyy): ");
            checkOut = sdf.parse(scanner.next());

            reservation.updateDates(checkIn, checkOut);
            System.out.println("Reservation: " + reservation);
        } catch (ParseException parseException) {
            System.out.println("Invalid date format");
        } catch (DomainException exception) {
            System.out.println("Error in reservation: " + exception.getMessage());
        } catch (RuntimeException runtimeException) {
            System.out.println("Unexpected error");
        }
        scanner.close();
    }
}