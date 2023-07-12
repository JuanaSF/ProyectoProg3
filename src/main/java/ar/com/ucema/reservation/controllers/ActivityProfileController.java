package ar.com.ucema.reservation.controllers;

import ar.com.ucema.reservation.dto.ActivityProfileDTO;
import ar.com.ucema.reservation.models.ActivityProfile;
import ar.com.ucema.reservation.services.ActivityProfileService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/activity-profiles")
@SecurityRequirement(name = "Bearer Auth")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class ActivityProfileController {

    @Autowired
    private ActivityProfileService activityProfileService;

    @PreAuthorize("hasAuthority('PROVIDER')")
    @Operation(summary = "endpoint to create an activity profile")
    @PostMapping
    public ResponseEntity<ActivityProfile> createActivityProfile(@RequestBody ActivityProfileDTO profile) {
        ActivityProfile newProfile = activityProfileService.createActivityProfile(profile);

        return ResponseEntity.ok(newProfile);
    }

    @Operation(summary = "endpoint to get list of activity profiles")
    @GetMapping
    public List<ActivityProfile> getActivityProfiles() {
        return activityProfileService.getAllProfiles();
    }

    @PreAuthorize("hasAnyAuthority('ADMIN', 'PROVIDER')")
    @Operation(summary = "endpoint to get a list of a user's activity profiles")
    @GetMapping(path = "/provider/{userId}")
    public List<ActivityProfile> getActivityProfileByProviderId(@PathVariable Long userId) {
        return activityProfileService.getByProviderId(userId);
    }

    @Operation(summary = "endpoint to get activity profile info")
    @GetMapping(path = "/{id}")
    public ActivityProfile getActivityProfilesById(@PathVariable Long id) {
        return activityProfileService.getById(id);
    }
}
