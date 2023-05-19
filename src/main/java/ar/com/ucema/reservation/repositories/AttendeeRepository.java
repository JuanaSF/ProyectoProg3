package ar.com.ucema.reservation.repositories;

import ar.com.ucema.reservation.models.Attendee;
import org.springframework.data.repository.CrudRepository;

public interface AttendeeRepository extends CrudRepository<Attendee, Long> {
}
