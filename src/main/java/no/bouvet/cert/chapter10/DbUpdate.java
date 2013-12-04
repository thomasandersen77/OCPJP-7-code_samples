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
public class DbUpdate {

    private static final String SELECT_STATEMENT = "SELECT * FROM "+TABLE_CONTACT+ " WHERE "+FIRST_NAME+"=\"Michael\"";
    private static final String ATTRIBUTES = "id \tfName \tlname \t\tphoneNo";
    public static final String BEFORE = "Before the update";

    public static void main(String[] args) {

        //try-with-resources (j7)
        try(Connection connection = DbConnector.connectToDb();
            Statement statement = connection.createStatement();
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

            //TODO

        } catch (SQLException e) {
            e.printStackTrace();
            System.exit(-1);
        }
    }
}
