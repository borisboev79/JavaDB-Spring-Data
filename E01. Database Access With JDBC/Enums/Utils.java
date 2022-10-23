package Enums;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public enum Utils {
    ;
    public static final Connection getSQLConnection() throws SQLException {
        final Properties properties = new Properties();

        properties.setProperty(Constants.USER_KEY, Constants.USER_VALUE);
        properties.setProperty(Constants.PASSWORD_KEY, Constants.PASWORD_VALUE);

        return DriverManager.getConnection(Constants.MINOINS_DB_URL, properties);

    }
}
