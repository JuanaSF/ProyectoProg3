package ar.com.ucema.reservation.enumeration;

public enum ReservationStatusEnum {
    AWAITING_CONFIRMATION("Awaiting confirmation"),
    COMPLETED("Completed"),
    NO_SHOW("No-show"),
    REJECTED("Rejected"),
    MODIFIED("Modified"),
    AWAITING_PAYMENT("Awaiting payment"),
    EXPIRED("Expired"),
    CANCELED("Canceled"),
    CONFIRMED("Confirmed");

    private String statusName;

    ReservationStatusEnum(String statusName) {
        this.statusName = statusName;
    }

    public String getStatusName() {
        return statusName;
    }
}
