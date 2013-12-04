package no.bouvet.cert.chapter10;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static no.bouvet.cert.chapter10.DbConstants.*;

/**
 * Created with IntelliJ IDEA.
 * User: gaute.lyngstad
 * Date: 04.12.13
 * Time: 14:58
 * To change this template use File | Settings | File Templates.
 */
public class DbQuery2 {

    private static final String SELECT_STATEMENT = "SELECT * FROM contact";
    private static final String ATTRIBUTES = "ID \tfName \tlName \temail \t\t\tphoneNo";

    public static void main(String[] args) {
        // Get connection, execute query, get the result set
        // and print the entries from the result rest

        //try-with-resources (j7)
        try(Connection connection = DbConnector.connectToDb();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SELECT_STATEMENT)){

            //print using column numbers
            System.out.println(ATTRIBUTES);
            while(resultSet.next()) {
                System.out.println(resultSet.getInt(1) + "\t"
                        + resultSet.getString(2) + "\t"
                        + resultSet.getString(3) + "\t"
                        + resultSet.getString(4)+ "\t"
                        +resultSet.getString(5));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.exit(-1);
        }
    }
}
