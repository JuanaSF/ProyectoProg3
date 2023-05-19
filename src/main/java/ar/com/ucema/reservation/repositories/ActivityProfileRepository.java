package ar.com.ucema.reservation.repositories;

import ar.com.ucema.reservation.models.ActivityProfile;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ActivityProfileRepository extends CrudRepository<ActivityProfile, Long> {
    List<ActivityProfile> findByProviderId(Long id);
}
