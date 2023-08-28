package be.intecbrussel.repository;

import be.intecbrussel.config.MySQLConfiguration;
import be.intecbrussel.model.Account;

import java.sql.*;
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

    public Optional<Account> getAccount(String email) {

//        String query = String.format("SELECT * FROM Account WHERE email like '%s' ", email);
        String query = "SELECT * FROM Account WHERE email like ?;";
        System.out.println(query);

        try (Connection connection = MySQLConfiguration.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, email);

            System.out.println(statement);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                String dbEmail = resultSet.getString(1);
                String dbPassword = resultSet.getString(2);
                Account account = new Account(dbEmail, dbPassword);
                return Optional.of(account);
            }

        } catch (SQLException e) {
            System.err.println("Error: could not find account");
            throw new RuntimeException(e);
        }

        return Optional.empty();
    }


    /**
     *  INSERT INTO Account VALUES ('email','passw');
     */
}
