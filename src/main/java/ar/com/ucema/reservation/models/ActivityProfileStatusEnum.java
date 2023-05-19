package ar.com.ucema.reservation.models;

public enum ActivityProfileStatusEnum {
    DRAFT("Draft"),
    PUBLISHED("Published"),
    PAUSED("Paused"),
    DELETED("Deleted");

    private String statusName;

    ActivityProfileStatusEnum(String statusName) {
        this.statusName = statusName;
    }

    public String getStatusName() {
        return statusName;
    }
}
