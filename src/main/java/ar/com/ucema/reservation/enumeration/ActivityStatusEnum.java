package ar.com.ucema.reservation.enumeration;

public enum ActivityStatusEnum {
    PENDING("Pending"),
    RESCHEDULED("Rescheduled"),
    CANCELED("Canceled"),
    COMPLETED("Completed");

    private String statusName;

    ActivityStatusEnum(String statusName) {
        this.statusName = statusName;
    }

    public String getStatusName() {
        return statusName;
    }
}
