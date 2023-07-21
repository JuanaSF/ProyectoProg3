package ar.com.ucema.reservation.dto;

import ar.com.ucema.reservation.enumeration.DayOfWeekEnum;

public class AvailabilityDTO {

    private DayOfWeekEnum dayOfWeek;
    private String hours;

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
}
