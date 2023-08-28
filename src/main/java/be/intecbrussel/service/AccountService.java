package be.intecbrussel.service;

import be.intecbrussel.model.Account;
import be.intecbrussel.repository.AccountRepository;

import java.util.Optional;

public class AccountService {
    private AccountRepository accountRepository = new AccountRepository();

    public boolean createAccount(Account account) {
        return accountRepository.createAccount(account);
    }

    public Optional<Account> getAccount(String email, String passw) {

        Optional<Account> account = accountRepository.getAccount(email, passw);

        if ((account.isPresent()) || (passw.equals(account.get().getPassw()))) {
            return account;
        }else {
            return Optional.empty();
        }

    }
}
