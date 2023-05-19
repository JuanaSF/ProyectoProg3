package ar.com.ucema.reservation.models;

public enum RoleEnum {

    USER("User"),
    PROVIDER("Provider"),
    ADMIN("Admin");

    private String roleName;

    RoleEnum(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleName() {
        return roleName;
    }
}
