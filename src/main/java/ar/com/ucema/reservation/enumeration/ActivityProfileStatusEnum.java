package ar.com.ucema.reservation.enumeration;

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

    public static ActivityProfileStatusEnum getStatusByName(String name) {
        for (ActivityProfileStatusEnum status : ActivityProfileStatusEnum.values()) {
            if (status.getStatusName().equals(name)) {
                return status;
            }
        }
        return null;
    }
}
