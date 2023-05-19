package ar.com.ucema.reservation.services;

import ar.com.ucema.reservation.dto.ActivityProfileDTO;
import ar.com.ucema.reservation.models.ActivityProfile;
import ar.com.ucema.reservation.models.ActivityProfileStatusEnum;
import ar.com.ucema.reservation.models.User;
import ar.com.ucema.reservation.repositories.ActivityProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.List;

@Service
public class ActivityProfileServiceImpl implements ActivityProfileService {

    @Autowired
    private ActivityProfileRepository activityProfileRepository;

    @Autowired
    private UserService userService;

    @Override
    public List<ActivityProfile> getAllProfiles() {
        return (List<ActivityProfile>) activityProfileRepository.findAll();
    }

    @Override
    public List<ActivityProfile> getByProviderId(Long id) {
        return activityProfileRepository.findByProviderId(id);
    }

    @Override
    public ActivityProfile createActivityProfile(ActivityProfileDTO profile) {
        User provider = userService.getById(profile.getUserId());

        ActivityProfile newProfile = new ActivityProfile();

        newProfile.setProvider(provider);
        newProfile.setTitle(profile.getTitle());
        newProfile.setDescription(profile.getDescription());
        newProfile.setCategory(profile.getCategory());
        newProfile.setMaxCapacity(profile.getMaxCapacity());
        newProfile.setPrice(profile.getPrice());
        newProfile.setStatus(profile.getStatus());

         return save(newProfile);
    }

    @Override
    public ActivityProfile getById(Long id) {
        return activityProfileRepository.findById(id).orElse(null);
    }

    private ActivityProfile save(ActivityProfile profile) {
        return activityProfileRepository.save(profile);
    }
}
