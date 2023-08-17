package be.intecbrussel.model;

import be.intecbrussel.util.IdGenerator;

public class User {
    private long id;
    private String fname;
    private String lname;
    private Account account;

    private User(long id, String fname, String lname, Account account) {
        this.id = id;
        this.fname = fname;
        this.lname = lname;
        this.account = account;
    }

    public User(String fname, String lname, Account account) {
        this(IdGenerator.generateID(), fname, lname, account);
    }

    public Account getAccount() {
        return account;
    }

    public long getId() {
        return id;
    }

    public String getFname() {
        return fname;
    }

    public String getLname() {
        return lname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }
}
