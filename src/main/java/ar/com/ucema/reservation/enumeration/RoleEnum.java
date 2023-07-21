package ar.com.ucema.reservation.enumeration;

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
