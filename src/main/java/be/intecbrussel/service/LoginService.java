package be.intecbrussel.service;

import be.intecbrussel.model.Account;
import be.intecbrussel.model.User;

import java.util.Optional;

public class LoginService {
    private UserService userService = new UserService();

    public boolean register(String fname, String lname, String email, String passw) {
        Account account = new Account(email, passw);
        User user = new User(fname, lname, account);

        return userService.createUser(user);
    }


    public Optional<User> login(String email, String passw) {

        return userService.loginUser(email, passw);
    }
}
