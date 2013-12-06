package no.bouvet.cert.gau.chapter10.Updating;

import no.bouvet.cert.gau.chapter10.DbConnector;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static no.bouvet.cert.gau.chapter10.DbConstants.*;

/**
 * Created with IntelliJ IDEA.
 * User: gaute.lyngstad
 * Date: 04.12.13
 * Time: 14:58
 * To change this template use File | Settings | File Templates.
 */
public class DbUpdate {

    private static final String SELECT_STATEMENT = "SELECT * FROM "+TABLE_CONTACT+ " WHERE "+FIRST_NAME+"=\"Michael\"";
    private static final String ATTRIBUTES = "id \tfName \tlname \t\tphoneNo";
    public static final String BEFORE = "Before the update";
    public static final String AFTER = "After the update";
    // Before the update
    // id 	fName 	lname 		phoneNo
    // 1	Michael	Taylor	michael@abc.com	+919876543210

    public static void main(String[] args) {

        //try-with-resources (j7)
        try(Connection connection = DbConnector.connectToDb();
            Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet resultSet = statement.executeQuery(SELECT_STATEMENT)){

            // first fetch the date and display it before the update operation
            System.out.println(BEFORE);
            System.out.println(ATTRIBUTES);

            while (resultSet.next()){
                System.out.println(resultSet.getInt(ID) + "\t"
                        + resultSet.getString(FIRST_NAME) + "\t"
                        + resultSet.getString(LAST_NAME) + "\t"
                        + resultSet.getString(EMAIL)+ "\t"
                        +resultSet.getString(PHONE_NO));
            }

            // move to row number 1
            resultSet.absolute(1);
            resultSet.updateString(PHONE_NO, "+919976543210");
            // set the changes in the database by calling updateRow()
            resultSet.updateRow();

            System.out.println(AFTER);
            System.out.println(ATTRIBUTES);

            resultSet.beforeFirst();
            while (resultSet.next()){
                System.out.println(resultSet.getInt(ID) + "\t"
                        + resultSet.getString(FIRST_NAME) + "\t"
                        + resultSet.getString(LAST_NAME) + "\t"
                        + resultSet.getString(EMAIL)+ "\t"
                        +resultSet.getString(PHONE_NO));
            }

            //reset back
            resultSet.absolute(1);
            resultSet.updateString(PHONE_NO, "+919876543210");
            resultSet.updateRow();


        } catch (SQLException e) {
            e.printStackTrace();
            System.exit(-1);
        }
    }
}
