package no.bouvet.cert.tan.chapter10;

import java.sql.*;

/**
 * Created by thomasa on 10.12.13.
 */
public class ResultSetManipulationExample extends AbstractBase{


    public static void main(String[] args) throws SQLException {

        createContact("per","pettersen", "per@pettersen.no", "99444411");

        //queryResultSetAndModify();
        getAllContacts();
    }

    public static void createContact(String firstName, String lastName, String email, String phoneNumber) throws SQLException {

        try (PreparedStatement statement = DbConnector.getConnection().prepareStatement(
                "insert into contact(firstName, lastName, email, phoneNo) values (?,?,?,?)")){  // Statement & Connection instances closed by try-with-resources
            statement.setString(1, firstName);
            statement.setString(2, lastName);
            statement.setString(3, email);
            statement.setString(4, phoneNumber);
            int rowsUpdated = statement.executeUpdate();
            System.out.printf("Rows affected: %d\n", rowsUpdated);
            if(rowsUpdated > 0)
                System.out.println("Created Contact: firstName = [" + firstName + "], lastName = [" + lastName + "], email = [" + email + "], phoneNumber = [" + phoneNumber + "]");
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }


    }

    public static void getAllContacts() throws SQLException {
        // all three JDBC resource classes are created inside the try-with-resources and will
        // ble closed when exiting the try/catch blocks
        try(Connection connection = DbConnector.getConnection();
            Statement stm = connection.createStatement();
            ResultSet resultSet = stm.executeQuery("SELECT * FROM contact")) {


            printContactResultSet(resultSet);
        } catch (SQLException e1) {
            e1.printStackTrace();
            throw e1;
        }
    }

    public static void queryResultSetAndModify() throws SQLException {
        ResultSet resultSet = null;
        Statement stm = null;
        Connection connection = null;
        // need to explicitly close the resources
        try {
            connection = DbConnector.getConnection();
            connection.setAutoCommit(false);
            stm = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            resultSet = stm.executeQuery("SELECT * FROM contact");

            resultSet.moveToInsertRow(); // move cursor to next available row and prepare it for insertions
            resultSet.updateString("firstName", "anne");
            resultSet.updateString("lastName", "olsen");
            resultSet.updateString("email", "anne@broadpark");
            resultSet.updateString("phoneNo", "97541588");

            resultSet.insertRow();    // important to actually insert the row
            connection.commit(); // persist since we do not autoCommit in Connection

            printContactResultSet(resultSet);
        } catch (SQLException e1) {
            if(connection != null)
                connection.rollback(); // rolling back in case SQLException (not necessary because commit statement where never reached)
            e1.printStackTrace();
            throw e1;
        } finally { // closing
            if(stm!= null)          stm.close();
            if(resultSet!= null)    resultSet.close();
            if(connection!= null)   connection.close();
        }
    }


}
