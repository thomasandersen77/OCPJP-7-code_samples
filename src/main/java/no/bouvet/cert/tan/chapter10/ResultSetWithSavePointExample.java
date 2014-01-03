package no.bouvet.cert.tan.chapter10;

import java.sql.*;

/**
 * Created by thomasa on 11.12.13.
 */
public class ResultSetWithSavePointExample extends AbstractBase{

    public static void main(String[] args) throws SQLException {
        Connection connection;
        ResultSet resultSet;

        try {
            connection = DbConnector.getConnection();
            connection.setAutoCommit(false);
            Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            resultSet = statement.executeQuery("SELECT * FROM familygroup");
            printFamilyGroup(resultSet);
            resultSet.moveToInsertRow();
            resultSet.updateString("nickName", "test");
            resultSet.insertRow();
            resultSet.updateRow();
            printFamilyGroup(resultSet);
            Savepoint firstSavepoint = connection.setSavepoint("mySavePoint");
            connection.rollback(firstSavepoint);
            connection.commit();
            printFamilyGroup(resultSet);

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {

        }


    }

    protected static void printFamilyGroup(ResultSet resultSet) throws SQLException {
        while (resultSet.next()) {
            System.out.printf("ID=%d\t\tNickName=%s%n", resultSet.getInt(1), resultSet.getString(2));
        }
    }


}
