package be.intecbrussel.service;

import be.intecbrussel.model.Account;
import be.intecbrussel.model.User;

import java.util.List;
import java.util.Optional;

public class LoginService {
    private UserService userService = new UserService();

    public boolean register(String fname, String lname, String email, String passw) {
        Account account = new Account(email, passw);
        User user = new User(fname, lname, account);

        return userService.createUser(user);
    }


    public Optional<User> login(String email, String passw) {
        Optional<User> user = userService.getUser(email);

        if (user.isPresent() && user.get().getAccount().getPassw().equals(passw)) {
            return user;
        }

        return Optional.empty();
    }

    public void registerManyUsers(List<User> userList) {
        userService.createManyUsers(userList);
    }
}
