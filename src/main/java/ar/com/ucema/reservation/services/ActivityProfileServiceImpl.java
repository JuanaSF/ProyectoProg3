package ar.com.ucema.reservation.services;

import ar.com.ucema.reservation.dto.ActivityProfileDTO;
import ar.com.ucema.reservation.dto.AvailabilityDTO;
import ar.com.ucema.reservation.exception.InvalidFieldsException;
import ar.com.ucema.reservation.exception.ResourceNotFoundException;
import ar.com.ucema.reservation.models.ActivityProfile;
import ar.com.ucema.reservation.models.Availability;
import ar.com.ucema.reservation.models.User;
import ar.com.ucema.reservation.repositories.ActivityProfileRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class ActivityProfileServiceImpl implements ActivityProfileService {

    @Autowired
    private ActivityProfileRepository activityProfileRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Override
    @Transactional(readOnly = true)
    public List<ActivityProfile> getAllProfiles() {
        return (List<ActivityProfile>) activityProfileRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public List<ActivityProfile> getByProviderId(Long id) {
        return activityProfileRepository.findByProviderId(id);
    }

    @Override
    @Transactional
    public ActivityProfile createActivityProfile(ActivityProfileDTO profile) {
        ActivityProfile newProfile = new ActivityProfile(profile.getTitle(), profile.getDescription(),
                profile.getCategory(), profile.getMainImage(), profile.getMaxCapacity(), profile.getPrice(), profile.getStatus());
        validateProfile(newProfile);

        User provider = userDetailsService.getAuthenticatedUser();

        newProfile.setProvider(provider);
        newProfile.setTitle(profile.getTitle());
        newProfile.setDescription(profile.getDescription());
        newProfile.setCategory(profile.getCategory());
        newProfile.setMaxCapacity(profile.getMaxCapacity());
        newProfile.setPrice(profile.getPrice());
        newProfile.setStatus(profile.getStatus());

        if (profile.getAvailability() != null && !profile.getAvailability().isEmpty()) {
            newProfile.setAvailability(new ArrayList<>());

            for (AvailabilityDTO a : profile.getAvailability()) {
                Availability availability = new Availability();

                availability.setDayOfWeek(a.getDayOfWeek());
                availability.setHours(a.getHours());

                newProfile.loadAvailability(availability);
            }
        }

         return save(newProfile);
    }

    private void validateProfile(ActivityProfile profile) {
        boolean hasErrors = false;
        List<String> errors = new ArrayList<>();

        if (StringUtils.isBlank(profile.getTitle())) {
            errors.add("The field title cannot be null");
            hasErrors = true;
        }

        if (StringUtils.isBlank(profile.getDescription())) {
            errors.add("The field description cannot be null");
            hasErrors = true;
        }

        if (StringUtils.isBlank(profile.getCategory())) {
            errors.add("The field category cannot be null");
            hasErrors = true;
        }

        if (profile.getMaxCapacity() == null) {
            errors.add("The field max capacity cannot be null");
            hasErrors = true;
        }

        if (profile.getPrice() == null) {
            errors.add("The field price cannot be null");
            hasErrors = true;
        }

        if (profile.getStatus() == null) {
            errors.add("The field status cannot be null");
            hasErrors = true;
        }

        if (hasErrors) throw new InvalidFieldsException("The activity profile contains invalid fields", errors);
    }

    @Override
    @Transactional(readOnly = true)
    public ActivityProfile getById(Long id) {
        return activityProfileRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Activity profile not found for Id: " + id));
    }

    @Override
    @Transactional
    public ActivityProfile updateActivityProfile(ActivityProfileDTO profile, Long id) {

        ActivityProfile profileDB = getById(id);

        profileDB.setTitle(profile.getTitle());
        profileDB.setDescription(profile.getDescription());
        profileDB.setCategory(profile.getCategory());
        profileDB.setMainImage(profile.getMainImage());
        profileDB.setMaxCapacity(profile.getMaxCapacity());
        profileDB.setPrice(profile.getPrice());
        profileDB.setStatus(profile.getStatus());

        if (profile.getAvailability() != null && !profile.getAvailability().isEmpty()) {

            for (AvailabilityDTO a : profile.getAvailability()) {
                Availability availability = new Availability();

                availability.setDayOfWeek(a.getDayOfWeek());
                availability.setHours(a.getHours());

                profileDB.loadAvailability(availability);
            }
        }

        save(profileDB);

        return profileDB;
    }

    private ActivityProfile save(ActivityProfile profile) {
        return activityProfileRepository.save(profile);
    }
}
