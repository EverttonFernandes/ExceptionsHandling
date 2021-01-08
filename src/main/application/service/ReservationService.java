package service;

import model.entities.Reservation;

import java.util.Date;

public interface ReservationService {
    void updateDates(Date checkIn, Date checkOut);
    void informationsReserve(Reservation information);
    void saveReservation(int roomNumber, Date checkIn, Date checkOut);
}
