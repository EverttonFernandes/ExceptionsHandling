package service.impl;

import model.entities.Reservation;
import model.exceptions.DomainException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ReservationServiceImpl {

    public static void validateDatesReservation(Date checkIn, Date checkOut){
        if (!checkOut.after(checkIn)) {
            throw new DomainException("Check-out date must be after check-n date");
        }
    }

    public static Reservation saveReservation(int roomNumber, Date checkIn, Date checkOut) {
        validateDatesReservation(checkIn, checkOut);
        return new Reservation(roomNumber, checkIn, checkOut);
    }

    public static void informationsReserve(Reservation information) {
        StringBuilder builder = new StringBuilder();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        builder.append("Room ").append(information.getRoomNumber());
        builder.append(", check-in: ").append(sdf.format(information.getCheckIn()));
        builder.append(", check-out: ").append(sdf.format(information.getCheckOut()));
        builder.append(", ").append(information.durationInDays());
        builder.append(" nights");
        System.out.println(builder);
    }

    public static void updateDates(Date checkIn, Date checkOut, Reservation reservation) {
        validateDatesUpdateReservation(checkIn, checkOut);
        reservation.setCheckIn(checkIn);
        reservation.setCheckOut(checkOut);
    }

    private static void validateDatesUpdateReservation(Date checkIn, Date checkOut) {
        Date now = new Date();

        if (checkIn.before(now) || checkOut.before(now)) {
            throw new DomainException("Reservation dates for update must be future dates");
        }
    }

}