package ar.com.ucema.reservation.repositories;

import ar.com.ucema.reservation.models.Activity;
import ar.com.ucema.reservation.models.ActivityProfile;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public interface ActivityRepository extends CrudRepository<Activity, Long> {
    Activity findByProfileAndDate(ActivityProfile activityProfile, LocalDateTime date);

    Activity findByProfile_IdAndDate(Long profileId, LocalDateTime date);

    Activity findByDate(LocalDateTime localDateTime);
}
