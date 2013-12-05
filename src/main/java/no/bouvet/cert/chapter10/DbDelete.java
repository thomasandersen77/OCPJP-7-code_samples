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
public class DbDelete {

    private static final String SELECT_STATEMENT_JOHN = "SELECT * FROM "+TABLE_CONTACT+" WHERE "+FIRST_NAME+"=\"John\"";
    private static final String SELECT_STATEMENT_ALL = "SELECT * FROM "+TABLE_CONTACT;
    private static final String ATTRIBUTES = "id \tfName \tlname \t\tphoneNo";
    public static final String AFTER = "After the deletion";

    public static void main(String[] args) {

        //try-with-resources (j7)
        try(Connection connection = DbConnector.connectToDb();
            Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet resultSet1 = statement.executeQuery(SELECT_STATEMENT_JOHN)){

            if(resultSet1.next()){
                // delete the first row
                resultSet1.deleteRow();
            }
            resultSet1.close();

            try(ResultSet resultSet2 = statement.executeQuery(SELECT_STATEMENT_ALL)){

                System.out.println(AFTER);
                System.out.println(ATTRIBUTES);

                while (resultSet2.next()){
                    System.out.println(resultSet2.getInt(ID) + "\t"
                            + resultSet2.getString(FIRST_NAME) + "\t"
                            + resultSet2.getString(LAST_NAME) + "\t"
                            + resultSet2.getString(EMAIL)+ "\t"
                            +resultSet2.getString(PHONE_NO));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.exit(-1);
        }
    }
}
