package ar.com.ucema.reservation.dto;

import ar.com.ucema.reservation.enumeration.ReservationStatusEnum;
import ar.com.ucema.reservation.models.Attendee;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class ReservationDTO {

    private Long activityId;
    private LocalDateTime reservationDate;
    private Double price;
    private List<AttendeeDTO> attendees;

    public Long getActivityId() {
        return activityId;
    }

    public void setActivityId(Long activityId) {
        this.activityId = activityId;
    }

    public LocalDateTime getReservationDate() {
        return reservationDate;
    }

    public void setReservationDate(LocalDateTime reservationDate) {
        this.reservationDate = reservationDate;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public List<AttendeeDTO> getAttendees() {
        return attendees;
    }

    public void setAttendees(List<AttendeeDTO> attendees) {
        this.attendees = attendees;
    }
}
