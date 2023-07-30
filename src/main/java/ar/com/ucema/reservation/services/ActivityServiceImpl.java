package ar.com.ucema.reservation.services;

import ar.com.ucema.reservation.dto.ActivityDTO;
import ar.com.ucema.reservation.enumeration.ActivityStatusEnum;
import ar.com.ucema.reservation.exception.ResourceNotFoundException;
import ar.com.ucema.reservation.models.Activity;
import ar.com.ucema.reservation.models.ActivityProfile;
import ar.com.ucema.reservation.repositories.ActivityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
public class ActivityServiceImpl implements ActivityService {

    @Autowired
    private ActivityRepository activityRepository;

    @Autowired
    private ActivityProfileService activityProfileService;

    @Override
    @Transactional(readOnly = true)
    public Activity getById(Long id) {
        return activityRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Reservation not found for Id: " + id));
    }

    @Override
    @Transactional
    public Activity createActivity(ActivityDTO activity) {

        ActivityProfile activityProfile = activityProfileService.getById(activity.getActivityProfileId());

        Activity newActivity = new Activity();

        newActivity.setProfile(activityProfile);
        newActivity.setTitle(activityProfile.getTitle());
        newActivity.setDescription(activityProfile.getDescription());
        newActivity.setCategory(activityProfile.getCategory());
        newActivity.setMainImage(activityProfile.getMainImage());
        newActivity.setAvailableCapacity(activityProfile.getMaxCapacity());
        newActivity.setPrice(activityProfile.getPrice());
        newActivity.setDate(activity.getActivityDate());
        newActivity.setStatus(ActivityStatusEnum.PENDING);

        return save(newActivity);
    }

    @Override
    @Transactional(readOnly = true)
    public Activity getByProfileAndDate(Long profileId, LocalDateTime date) {
        ActivityProfile activityProfile = activityProfileService.getById(profileId);
        return activityRepository.findByProfileAndDate(activityProfile, date);
        //return activityRepository.findByProfile_IdAndDate(profileId, date);
    }

    @Override
    public void availableCapacity(Activity activity, int size) {
        activity.setAvailableCapacity(activity.getAvailableCapacity() - size);
        save(activity);
    }

    @Override
    public Activity getByDate(LocalDateTime localDateTime) {
        Activity acFound = activityRepository.findByDate(localDateTime);
        return acFound;
    }

    private Activity save(Activity activity) {
        return activityRepository.save(activity);
    }

}
