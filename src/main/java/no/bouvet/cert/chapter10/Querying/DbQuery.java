package no.bouvet.cert.chapter10.Querying;

import no.bouvet.cert.chapter10.DbConnector;

import java.sql.*;
import static no.bouvet.cert.chapter10.DbConstants.*;

/**
 * Created with IntelliJ IDEA.
 * User: gaute.lyngstad
 * Date: 04.12.13
 * Time: 14:58
 * To change this template use File | Settings | File Templates.
 */
public class DbQuery {

    private static final String SELECT_STATEMENT = "SELECT * FROM contact";
    private static final String ATTRIBUTES = "ID \tfName \tlName \temail \t\t\tphoneNo";

    public static void main(String[] args) {
        // Get connection, execute query, get the result set
        // and print the entries from the result rest

        //try-with-resources (j7)
        try(Connection connection = DbConnector.connectToDb();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SELECT_STATEMENT)){

            //print using column names
            System.out.println(ATTRIBUTES);
            while (resultSet.next()){
                System.out.println(resultSet.getInt(ID) + "\t"
                + resultSet.getString(FIRST_NAME) + "\t"
                + resultSet.getString(LAST_NAME) + "\t"
                + resultSet.getString(EMAIL)+ "\t"
                +resultSet.getString(PHONE_NO));
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.exit(-1);
        }
    }
}
