package be.intecbrussel.model;

public class Account {
    private final String email;
    private String passw;

    public Account(String email, String passw) {
        this.email = email;
        this.passw = passw;
    }

    public String getEmail() {
        return email;
    }

    public String getPassw() {
        return passw;
    }

    public void setPassw(String passw) {
        this.passw = passw;
    }


}
