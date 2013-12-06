package no.bouvet.cert.gau.chapter10;

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
    //import static no.bouvet.cert.gau.chapter10.DbConnector.*;

    // Fields are public because of DbQuery5 use them directly
    public static final String URL = "jdbc:mysql://localhost:3306/";
    public static final String DATABASE = "addressBook";
    public static final String USER_NAME = "root";
    public static final String PASSWORD = "pass";

    public static Connection connectToDb() throws SQLException{
        return DriverManager.getConnection(URL+DATABASE, USER_NAME, PASSWORD);
    }
    private DbConnector(){}
}
