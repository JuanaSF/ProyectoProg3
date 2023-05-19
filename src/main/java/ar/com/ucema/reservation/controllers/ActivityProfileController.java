package ar.com.ucema.reservation.controllers;

import ar.com.ucema.reservation.dto.ActivityProfileDTO;
import ar.com.ucema.reservation.models.ActivityProfile;
import ar.com.ucema.reservation.services.ActivityProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/activity-profiles")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class ActivityProfileController {

    @Autowired
    private ActivityProfileService activityProfileService;

    @PostMapping
    public ActivityProfile createActivityProfile(@RequestBody ActivityProfileDTO profile) {
        ActivityProfile newProfile = activityProfileService.createActivityProfile(profile);

        return newProfile;
    }

    @GetMapping
    public List<ActivityProfile> getActivityProfiles() {
        return activityProfileService.getAllProfiles();
    }

    @GetMapping(path = "/provider/{userId}")
    public List<ActivityProfile> getActivityProfileByProviderId(@PathVariable Long userId) {
        return activityProfileService.getByProviderId(userId);
    }

    @GetMapping(path = "/{id}")
    public ActivityProfile getActivityProfilesById(@PathVariable Long id) {
        return activityProfileService.getById(id);
    }
}
