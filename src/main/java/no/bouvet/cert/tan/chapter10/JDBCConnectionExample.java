package no.bouvet.cert.tan.chapter10;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by thomasa on 10.12.13.
 */
public class JDBCConnectionExample {
    public static void main(String[] args) {
        String dataBase = "addressBook";
        String url = String.format("jdbc:mysql://localhost:3306/%s", dataBase);
        String user = "root";
        String password = "pass";

        try(Connection connection = DriverManager.getConnection(url, user, password)) {
            System.out.printf("isOpen ? %b%n", !connection.isClosed());
            connection.close();
            System.out.printf("isOpen ? %b%n", !connection.isClosed());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
