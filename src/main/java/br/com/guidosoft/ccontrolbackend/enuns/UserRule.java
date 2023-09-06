package br.com.guidosoft.ccontrolbackend.enuns;

public enum UserRule {
    ADMIN("admin"),
    USER("user");

    private String role;

    UserRule(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }
}
