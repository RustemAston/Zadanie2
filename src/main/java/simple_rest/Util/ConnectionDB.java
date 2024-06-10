package simple_rest.Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB {
    private static final String DRIVER = "driver-class-name";
    private static final String URL = "url";
    private static final String USERNAME = "username";
    private static final String PASSWORD = "password";
    private static Connection connection;

    static {
        try {
            Class.forName(propertiesFile.getProperties(DRIVER));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection(){
        try {
            connection = DriverManager.getConnection(propertiesFile.getProperties(URL),
                    propertiesFile.getProperties(USERNAME),
                    propertiesFile.getProperties(PASSWORD));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}