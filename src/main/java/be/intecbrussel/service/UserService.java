package be.intecbrussel.service;

import be.intecbrussel.model.Account;
import be.intecbrussel.model.User;
import be.intecbrussel.repository.UserRepository;

import java.util.Optional;

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

    public Optional<User> loginUser(String email, String passw) {

        Optional<Account> account = accountService.getAccount(email, passw);

        if (account.isPresent()) {
            Account foundAccount = account.get();

            return userRepository.getUser(email, passw, foundAccount);
        } else {
            return Optional.empty();
        }

    }
}
