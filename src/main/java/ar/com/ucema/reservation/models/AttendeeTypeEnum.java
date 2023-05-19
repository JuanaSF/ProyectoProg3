package ar.com.ucema.reservation.models;

public enum AttendeeTypeEnum {
    CHILD("Child"),
    ADULT("Adult");

    private String typeName;

    AttendeeTypeEnum(String typeName) {
        this.typeName = typeName;
    }

    public String getAttendeeName() {
        return typeName;
    }
}
