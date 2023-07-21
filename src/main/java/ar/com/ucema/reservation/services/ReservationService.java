package ar.com.ucema.reservation.services;

import ar.com.ucema.reservation.dto.ReservationDTO;
import ar.com.ucema.reservation.models.Reservation;

public interface ReservationService {

    Reservation getById(Long id);

    Reservation createReservation(ReservationDTO reservation);
}
