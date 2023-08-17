package be.intecbrussel.repository;

import be.intecbrussel.model.Account;

public class AccountRepository {

    public boolean createAccount(Account account) {
        String query = String.format("INSERT INTO Account VALUES ( '%s' , '%s' );", account.getEmail(), account.getPassw());

        System.out.println(query);
        return true;
    }

    /**
     *  INSERT INTO Account VALUES ('email','passw');
     */
}
