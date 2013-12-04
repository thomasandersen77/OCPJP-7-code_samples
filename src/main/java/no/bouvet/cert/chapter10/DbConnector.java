package no.bouvet.cert.chapter10;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created with IntelliJ IDEA.
 * User: gaute.lyngstad
 * Date: 04.12.13
 * Time: 14:56
 * To change this template use File | Settings | File Templates.
 */
public class DbConnector {

    private static final String URL = "jdbc:mysql://localhost:3306/";
    private static final String DATABASE = "addressBook";
    private static final String USER_NAME = "root";
    private static final String PASSWORD = "pass";

    public static Connection connectToDb() throws SQLException{
        return DriverManager.getConnection(URL+DATABASE, USER_NAME, PASSWORD);
    }
}
