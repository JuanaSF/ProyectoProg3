package ar.com.ucema.reservation.models;

public enum RoleEnum {

    USER("User"),
    PROVIDER("Provider"),
    ADMIN("Admin");

    private String name;

    RoleEnum(String roleName) {
        this.name = roleName;
    }

    public String getRoleName() {
        return name;
    }
}
