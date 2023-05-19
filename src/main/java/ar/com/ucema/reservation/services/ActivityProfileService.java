package ar.com.ucema.reservation.services;

import ar.com.ucema.reservation.dto.ActivityProfileDTO;
import ar.com.ucema.reservation.models.ActivityProfile;

import java.security.Principal;
import java.util.List;

public interface ActivityProfileService {

    List<ActivityProfile> getAllProfiles();

    List<ActivityProfile> getByProviderId(Long id);

    ActivityProfile createActivityProfile(ActivityProfileDTO profile);

    ActivityProfile getById(Long id);
}
