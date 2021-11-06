package dto;

public class FieldsWithoutLombok {

    String email;
    String password;

    public String getEmail() {
        return email;
    }

    public FieldsWithoutLombok setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public FieldsWithoutLombok setPassword(String password) {
        this.password = password;
        return this;
    }
}
