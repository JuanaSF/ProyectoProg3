package ar.com.ucema.reservation.models;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "reservation")
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reservation_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "userId", referencedColumnName="user_id")
    private User client;

    @ManyToOne
    @JoinColumn(name = "activityId", referencedColumnName="activity_id")
    private Activity activity;

    private LocalDate date;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private ReservationStatusEnum status;

    @Column(name = "attendee_count", nullable = false)
    private Integer attendeeCount;

    @OneToMany(mappedBy = "reservation")
    private List<Attendee> attendees;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getClient() {
        return client;
    }

    public void setClient(User client) {
        this.client = client;
    }

    public Activity getActivity() {
        return activity;
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public ReservationStatusEnum getStatus() {
        return status;
    }

    public void setStatus(ReservationStatusEnum status) {
        this.status = status;
    }

    public Integer getAttendeeCount() {
        return attendeeCount;
    }

    public void setAttendeeCount(Integer attendeeCount) {
        this.attendeeCount = attendeeCount;
    }

    public List<Attendee> getAttendees() {
        return attendees;
    }

    public void setAttendees(List<Attendee> attendees) {
        this.attendees = attendees;
    }
}
