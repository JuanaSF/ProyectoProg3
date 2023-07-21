package ar.com.ucema.reservation.models;

import ar.com.ucema.reservation.enumeration.DayOfWeekEnum;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "availability")
public class Availability {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "availability_id")
    private Long id;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "activity_profile_id")
    private ActivityProfile activityProfile;

    @Column(name = "date_of_week", nullable = false)
    @Enumerated(EnumType.STRING)
    private DayOfWeekEnum dayOfWeek;

    @Column(nullable = false)
    private String hours;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public DayOfWeekEnum getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(DayOfWeekEnum dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public String getHours() {
        return hours;
    }

    public void setHours(String hours) {
        this.hours = hours;
    }

    public ActivityProfile getActivityProfile() {
        return activityProfile;
    }

    public void setActivityProfile(ActivityProfile activityProfile) {
        this.activityProfile = activityProfile;
    }
}
