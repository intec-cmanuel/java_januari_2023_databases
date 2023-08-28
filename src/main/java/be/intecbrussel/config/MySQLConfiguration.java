package be.intecbrussel.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class MySQLConfiguration {

    public static Connection getConnection() {
        String user = "root"; // access to all DB -> make user and give access to what you want to use JeanJean
        String passw = "intec-123";
        String url = "localhost";
        String port = "3306";
        String database = "accountapp";

        String connectionString = String.format("jdbc:mysql://%s:%s/%s",
                                                url, port, database);

        Properties connectionProperties = new Properties();
        connectionProperties.put("user", user);
        connectionProperties.put("password", passw);

        Connection connection;
        try {
            connection = DriverManager.getConnection(connectionString, connectionProperties);
        } catch (SQLException e) {
            System.err.println("Error: Could not connect to database");
            throw new RuntimeException(e);
        }

        return connection;

    }

}
