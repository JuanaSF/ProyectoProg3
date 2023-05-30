package ar.com.ucema.reservation.repositories;

import ar.com.ucema.reservation.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {

    User findByEmail(String email);
}
