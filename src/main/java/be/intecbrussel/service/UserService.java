package be.intecbrussel.service;

import be.intecbrussel.model.User;
import be.intecbrussel.repository.UserRepository;

public class UserService {
    private AccountService accountService = new AccountService();
    private UserRepository userRepository = new UserRepository();

    public boolean createUser(User user) {
        boolean success = accountService.createAccount(user.getAccount());

        if (success) {
            return userRepository.createUser(user);
        }

        return false;
    }
}
