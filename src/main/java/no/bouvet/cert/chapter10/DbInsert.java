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
public class DbInsert {

    private static final String SELECT_STATEMENT = "SELECT * FROM "+TABLE_CONTACT;
    private static final String ATTRIBUTES = "id \tfName \tlname \t\tphoneNo";
    public static final String BEFORE = "Before the insert";
    public static final String AFTER = "After the insert";

    public static void main(String[] args) {

        //try-with-resources (j7)
        try(Connection connection = DbConnector.connectToDb();
            Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet resultSet = statement.executeQuery(SELECT_STATEMENT)){

            System.out.println(BEFORE);
            System.out.println(ATTRIBUTES);

            while (resultSet.next()){
                System.out.println(resultSet.getInt(ID) + "\t"
                        + resultSet.getString(FIRST_NAME) + "\t"
                        + resultSet.getString(LAST_NAME) + "\t"
                        + resultSet.getString(EMAIL)+ "\t"
                        +resultSet.getString(PHONE_NO));
            }

            resultSet.moveToInsertRow();
            resultSet.updateString(FIRST_NAME, "John");
            resultSet.updateString(LAST_NAME, "K.");
            resultSet.updateString(EMAIL, "john@abc.com");
            resultSet.updateString(PHONE_NO, "+19753186420");
            resultSet.insertRow();

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
        } catch (SQLException e) {
            e.printStackTrace();
            System.exit(-1);
        }
    }
}
