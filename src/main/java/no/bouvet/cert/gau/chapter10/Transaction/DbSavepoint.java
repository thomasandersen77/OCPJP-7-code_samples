package no.bouvet.cert.gau.chapter10.Transaction;

import no.bouvet.cert.gau.chapter10.DbConnector;

import java.sql.*;

import static no.bouvet.cert.gau.chapter10.DbConstants.*;

/**
 * Created with IntelliJ IDEA.
 * User: gaute.lyngstad
 * Date: 05.12.13
 * Time: 09:26
 * To change this template use File | Settings | File Templates.
 */
public class DbSavepoint {

    private static final String ERROR_MESSAGE = "Something gone wrong, couldn't add a contact in family group";
    private static final String SELECT_STATEMENT_ALL_FAMILY = "SELECT * FROM " + TABLE_FAMILY_GROUP;
    private static final String SAVEPOINT_DICK = "SavepointForDick";
    private static final String SAVEPOINT_HARRY = "ForHarry";

    // run DbCreateTable before running this code!
    public static void main(String[] args) throws SQLException {
        Connection connection = DbConnector.connectToDb();
        ResultSet resultSet = null;
        // we're using explicit finally blocks
        // instead of try-with-resources statement in this code
        try{
            // for commit/rollback we first need to set auto-commit to false
            connection.setAutoCommit(false);
            Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            resultSet = statement.executeQuery(SELECT_STATEMENT_ALL_FAMILY);

            System.out.println("Printing the contents of the table before inserting");
            while(resultSet.next()){
                System.out.println(resultSet.getInt(ID) + " "
                + resultSet.getString(NICK_NAME));
            }

            System.out.println("Starting to insert rows");
            // first insert
            resultSet.moveToInsertRow();
            resultSet.updateString(NICK_NAME, "Tom");
            resultSet.insertRow();
            System.out.println("Inserted row for Tom");
            // our first savepoint is here...
            Savepoint firstSavepoint = connection.setSavepoint();

            // second insert
            resultSet.moveToInsertRow();
            resultSet.updateString(NICK_NAME, "Dick");
            resultSet.insertRow();
            System.out.println("Inserted row for Dick");
            // our second savepoint is here... after we inserted Dick
            // we can give a string name for savepoint
            Savepoint secondSavepoint = connection.setSavepoint(SAVEPOINT_DICK);

            // third insert
            resultSet.moveToInsertRow();
            resultSet.updateString(NICK_NAME, "Harry");
            resultSet.insertRow();
            System.out.println("Inserted row for Harry");
            // our third savepoint is here... for "Harry"
            Savepoint thirdSavepoint = connection.setSavepoint(SAVEPOINT_HARRY);

            // rollback to the state when Dick was inserted;
            // so the insert for Harry will be lost
            System.out.println("Rolling back to the state where Tom and Dick were inserted");
            connection.rollback(secondSavepoint);
            // commit the changes now and see what happens to the contents of the table
            connection.commit();
            System.out.println("Printing the contents of the table after commit");
            resultSet = statement.executeQuery(SELECT_STATEMENT_ALL_FAMILY);
            while(resultSet.next()){
                System.out.println(resultSet.getInt(ID)+ " "
                + resultSet.getString(NICK_NAME));
            }

        }catch (SQLException e){
            System.out.println(ERROR_MESSAGE);
            //roll back all teh changes in the transaction since something has gone wrong
            connection.rollback();
            e.printStackTrace();
        }finally{
            if(connection != null) connection.close();
            if(resultSet != null) resultSet.close();
        }
    }
}
