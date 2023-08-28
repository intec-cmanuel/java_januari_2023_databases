package be.intecbrussel.repository;

import be.intecbrussel.config.MySQLConfiguration;
import be.intecbrussel.model.Account;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Optional;

public class AccountRepository {



    public boolean createAccount(Account account) {
        String query = String.format("INSERT INTO Account VALUES ( '%s' , '%s' );", account.getEmail(), account.getPassw());


        Connection connection = MySQLConfiguration.getConnection();

        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(query); // INSERT DATA
            // statement.executeQuery(query); // SELECT DATA
            connection.close();

        }catch (SQLException e) {
            System.out.println("Error: could not create account");
            throw new RuntimeException(e);
        }

        return true;
    }

    public Optional<Account> getAccount(String email, String passw) {

        String query = String.format(
                "SELECT '%s' FROM Account " +
                        "WHERE email like '%s' ", passw, email);


        String[] words = query.replaceAll("'", "").split("\\s+");
        System.out.println(query);
        return Optional.of(new Account(words[7], words[1]));

    }


    /**
     *  INSERT INTO Account VALUES ('email','passw');
     */
}
