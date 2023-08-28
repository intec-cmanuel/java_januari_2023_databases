package be.intecbrussel.repository;

import be.intecbrussel.config.MySQLConfiguration;
import be.intecbrussel.model.Account;
import be.intecbrussel.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public class UserRepository {

    static final String DB_URL = "jdbc:mysql://localhost/accountapp";
    static final String USER = "guest";
    static final String PASS = "0579";



    public boolean createUser(User user) {

        String query = "INSERT INTO User VALUES (?, ?, ?, ?);";

        try (Connection connection = MySQLConfiguration.getConnection()) {

            PreparedStatement statement = connection.prepareStatement(query);
            statement.setLong(1, user.getId());
            statement.setString(2, user.getFname());
            statement.setString(3, user.getLname());
            statement.setString(4, user.getAccount().getEmail());

            statement.executeUpdate();

        } catch (SQLException e) {
            System.err.println("USER COULD NOT BE CREATED");
            e.printStackTrace();
            return false;
        }

        return true;

    }

    public Optional<User> getUser(Account account) {
        String query = "SELECT * FROM User WHERE accEmail like ?";

        try (Connection connection = MySQLConfiguration.getConnection()) {

            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, account.getEmail());

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                long id = resultSet.getLong("id");
                String fname = resultSet.getString(2);
                String lname = resultSet.getString("lname");

                User user = new User(id, fname, lname, account);
                return Optional.of(user);
            }

            //

        } catch (SQLException e) {
            System.err.println("COULD NOT RETRIEVE USER");
            e.printStackTrace();
            //
        }

        return Optional.empty();
    }
}
