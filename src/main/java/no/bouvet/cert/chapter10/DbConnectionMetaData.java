package no.bouvet.cert.chapter10;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;

/**
 * Created with IntelliJ IDEA.
 * User: gaute.lyngstad
 * Date: 05.12.13
 * Time: 09:12
 * To change this template use File | Settings | File Templates.
 */
public class DbConnectionMetaData {
    public static void main(String[] args) throws SQLException{
        Connection connection = DbConnector.connectToDb();
        DatabaseMetaData metaData = connection.getMetaData();
        System.out.println("Displaying some of the database meta data from the Connection object");
        System.out.println("Database is: " + metaData.getDatabaseProductName() + " " +
        metaData.getDatabaseProductVersion());
        System.out.println("Driver is: " + metaData.getDriverName() + " " + metaData.getDriverVersion());
        System.out.println("The URL for this connection is: "+ metaData.getURL());
        System.out.println("User name is: " + metaData.getUserName());
        System.out.println("Maximum no. of rows you can insert is: " + metaData.getMaxRowSize());
    }
}
