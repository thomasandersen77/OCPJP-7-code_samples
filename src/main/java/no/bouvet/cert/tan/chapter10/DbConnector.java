package no.bouvet.cert.tan.chapter10;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by thomasa on 11.12.13.
 */
public class DbConnector {

    public static Connection getConnection() throws SQLException {
        String dataBase = "addressBook";
        String url = String.format("jdbc:mysql://localhost:3306/%s", dataBase);
        String user = "root";
        String password = "pass";
        return DriverManager.getConnection(url, user, password);
    }
}
