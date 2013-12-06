package no.bouvet.cert.gau.chapter10.Querying;

import no.bouvet.cert.gau.chapter10.DbConnector;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created with IntelliJ IDEA.
 * User: gaute.lyngstad
 * Date: 04.12.13
 * Time: 14:58
 * To change this template use File | Settings | File Templates.
 */
public class DbQuery3 {

    private static final String SELECT_STATEMENT = "SELECT * FROM contact";
    private static final String ATTRIBUTES = "ID \tfName \tlName \temail \t\t\tphoneNo";

    public static void main(String[] args) {
        // Get connection, execute query, get the result set
        // and print the entries from the result rest

        //try-with-resources (j7)
        try(Connection connection = DbConnector.connectToDb();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SELECT_STATEMENT)){

            //print when not knowing meta data
            System.out.println(ATTRIBUTES);
            int numOfColumns = resultSet.getMetaData().getColumnCount();
            while(resultSet.next()) {
                for(int i = 1; i<= numOfColumns;i++){
                    // since we do not know the data type of the column, we use getObject()
                    System.out.print(resultSet.getObject(i) + "\t");
                }
                System.out.println();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.exit(-1);
        }
    }
}
