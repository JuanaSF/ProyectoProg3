package ar.com.ucema.reservation.repositories;

import ar.com.ucema.reservation.models.Reservation;
import org.springframework.data.repository.CrudRepository;

public interface ReservationRepository extends CrudRepository<Reservation, Long> {
}
