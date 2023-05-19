package ar.com.ucema.reservation.repositories;

import ar.com.ucema.reservation.models.User;
import org.springframework.data.repository.CrudRepository;

public interface ActivityRepository extends CrudRepository<User, Long> {
}
