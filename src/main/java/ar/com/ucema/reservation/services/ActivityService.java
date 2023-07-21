package ar.com.ucema.reservation.services;

import ar.com.ucema.reservation.dto.ActivityDTO;
import ar.com.ucema.reservation.models.Activity;

import java.time.LocalDateTime;

public interface ActivityService {
    Activity getById(Long id);

    Activity createActivity(ActivityDTO activity);

    Activity getByProfileAndDate(Long profileId, LocalDateTime date);

    void availableCapacity(Activity activity, int size);

    Activity getByDate(LocalDateTime localDateTime);
}
