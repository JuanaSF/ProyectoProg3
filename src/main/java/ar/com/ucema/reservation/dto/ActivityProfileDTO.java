package ar.com.ucema.reservation.dto;

import ar.com.ucema.reservation.enumeration.ActivityProfileStatusEnum;
import ar.com.ucema.reservation.models.Availability;

import java.util.List;

public class ActivityProfileDTO {

    private String title;
    private String description;
    private String category;
    private Integer maxCapacity;
    private Double price;
    private ActivityProfileStatusEnum status;
    private List<AvailabilityDTO> availability;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Integer getMaxCapacity() {
        return maxCapacity;
    }

    public void setMaxCapacity(Integer maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public ActivityProfileStatusEnum getStatus() {
        return status;
    }

    public void setStatus(ActivityProfileStatusEnum status) {
        this.status = status;
    }

    public List<AvailabilityDTO> getAvailability() {
        return availability;
    }

    public void setAvailability(List<AvailabilityDTO> availability) {
        this.availability = availability;
    }
}
