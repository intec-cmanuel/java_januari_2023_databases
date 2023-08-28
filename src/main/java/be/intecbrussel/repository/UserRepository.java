package be.intecbrussel.repository;

import be.intecbrussel.model.Account;
import be.intecbrussel.model.User;

import java.sql.*;
import java.util.Optional;

public class UserRepository {

    static final String DB_URL = "jdbc:mysql://localhost/accountapp";
    static final String USER = "guest";
    static final String PASS = "0579";



    public boolean createUser(User user) {
//        String query = String.format("INSERT INTO User VALUES ('%d', '%s', '%s', '%s');",
//                user.getId(), user.getFname(), user.getLname(), user.getAccount().getEmail());

        final String QUERY = String.format("INSERT INTO User VALUES ('%d', '%s', '%s', '%s');",
                user.getId(), user.getFname(), user.getLname(), user.getAccount().getEmail());

        System.out.println(QUERY);
        return true;

    }

    public Optional<User> getUser(String email, String passw, Account account) {
        String query = String.format("SELECT fname, lname, passw" +
                                     "FROM User " +
                                     "INNER JOIN Account ON User.accEmail = Account.email" +
                                     "WHERE email like '%s'", email);

        String[] words = query.split("\\s+");
        
        if (query.isEmpty()){
            return Optional.empty();
        } else {
            return Optional.of(new User(words[1], words[2], account));
        }
    }
}
