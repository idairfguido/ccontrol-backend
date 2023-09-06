package br.com.guidosoft.ccontrolbackend.enuns;

public enum Status {
    ACTIVE("active"),
    INACTIVE("inactive");

    private String status;

    Status(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
