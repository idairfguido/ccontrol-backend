package br.com.guidosoft.ccontrolbackend.enuns;

public enum FieldType {
    COIN("coin"),
    PERCENTAGE("percentage"),
    GENERIC("generic");

    private String type;

    FieldType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
