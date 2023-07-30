package ar.com.ucema.reservation.controllers;

import ar.com.ucema.reservation.dto.ActivityDTO;
import ar.com.ucema.reservation.models.Activity;
import ar.com.ucema.reservation.services.ActivityService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping(value = "/api/activities")
@SecurityRequirement(name = "Bearer Auth")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class ActivityController {

    @Autowired
    private ActivityService activityService;

    //@PreAuthorize("hasAuthority('PROVIDER')")
    @Operation(summary = "endpoint to create an activity")
    @PostMapping
    public ResponseEntity<Activity> createActivityProfile(@RequestBody ActivityDTO activity) {
        Activity newActivity = activityService.createActivity(activity);

        return ResponseEntity.ok(newActivity);
    }

    @Operation(summary = "endpoint to get activity info by id")
    @GetMapping(path = "/{id}")
    public Activity getActivityById(@PathVariable Long id) {
        return activityService.getById(id);
    }

    @Operation(summary = "endpoint to get activity info by activity profile and date")
    @GetMapping(path = "/profile/{profileId}/date/{date}")
    public ResponseEntity<Activity> getActivityByProfileAndDate(@PathVariable Long profileId,
                                                @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime date) {
        return ResponseEntity.ok(activityService.getByProfileAndDate(profileId, date));
    }

    // Puede ser buscar por periodos
    @Operation(summary = "endpoint to get activity info by activity profile and date")
    @GetMapping(path = "/local-date-time")
    public ResponseEntity<Activity> getActivitiesByDate(@RequestParam("localDateTime") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime localDateTime) {
        Activity activity = activityService.getByDate(localDateTime);
        return ResponseEntity.ok(activity);
    }

}
