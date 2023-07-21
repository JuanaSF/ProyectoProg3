package ar.com.ucema.reservation.dto;

import java.time.LocalDateTime;

public class ActivityDTO {

    private Long activityProfileId;
    private LocalDateTime activityDate;

    public Long getActivityProfileId() {
        return activityProfileId;
    }

    public void setActivityProfileId(Long activityProfileId) {
        this.activityProfileId = activityProfileId;
    }

    public LocalDateTime getActivityDate() {
        return activityDate;
    }

    public void setActivityDate(LocalDateTime activityDate) {
        this.activityDate = activityDate;
    }
}
