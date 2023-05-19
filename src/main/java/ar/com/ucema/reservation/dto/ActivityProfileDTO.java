package ar.com.ucema.reservation.dto;

import ar.com.ucema.reservation.models.ActivityProfileStatusEnum;
import ar.com.ucema.reservation.models.ActivityStatusEnum;

public class ActivityProfileDTO {

    private Long userId;
    private String title;
    private String description;
    private String category;
    private Integer maxCapacity;
    private Double price;
    private ActivityProfileStatusEnum status;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

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
}
