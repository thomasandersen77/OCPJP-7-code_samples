package no.bouvet.cert.gau.chapter10.Transaction;

import no.bouvet.cert.gau.chapter10.DbConnector;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import static no.bouvet.cert.gau.chapter10.DbConstants.*;
/**
 * Created with IntelliJ IDEA.
 * User: gaute.lyngstad
 * Date: 05.12.13
 * Time: 09:26
 * To change this template use File | Settings | File Templates.
 */
public class DbTransaction {

    private static final String ERROR_MESSAGE = "Something gone wrong, couldn't add a contact in family group";
    private static final String SELECT_STATEMENT_ALL_FAMILY = "SELECT * FROM " + TABLE_FAMILY_GROUP;
    private static final String SELECT_STATEMENT_ALL_CONTACT = "SELECT * FROM " + TABLE_CONTACT;

    // run DbCreateTable before running this code!
    public static void main(String[] args) throws SQLException {
        Connection connection = DbConnector.connectToDb();
        ResultSet resultSet1 = null, resultSet2 = null;
        // we're using explicit finally blocks
        // instead of try-with-resources statement in this code
        try{
            // for commit/rollback we first need to set auto-commit to false
            connection.setAutoCommit(false);
            Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            resultSet1 = statement.executeQuery(SELECT_STATEMENT_ALL_FAMILY);
            resultSet1.moveToInsertRow();
            resultSet1.updateString(NICK_NAME,"Sam Uncle");
            // updating here... but this change will be lost if a rollback happens
            resultSet1.insertRow();
            System.out.println("First table updated...");

            resultSet2 = statement.executeQuery(SELECT_STATEMENT_ALL_CONTACT);
            resultSet2.moveToInsertRow();
            resultSet2.updateString(FIRST_NAME, "Samuel");
//            resultSet2.updateString(FIRST_NAME, "The great samuel the billionaire from Washington DC");
            resultSet2.updateString(LAST_NAME, "Uncle");
            resultSet2.updateString(EMAIL, "sam@abc.com");
            resultSet2.updateString(PHONE_NO, "+119955331100");
            // updating here... but this change will be lost if a rollback happens
            resultSet2.insertRow();
            System.out.println("Both tables updated, committing now.");
            //we're committing the changes for both the tables only now
            connection.commit();
        }catch (SQLException e){
            System.out.println(ERROR_MESSAGE);
            connection.rollback();
            e.printStackTrace();
        }finally{
            if(connection != null) connection.close();
            if(resultSet1 != null) resultSet1.close();
            if(resultSet2 != null) resultSet2.close();
        }
    }
}
