package no.bouvet.cert.tan.chapter10;

import com.sun.xml.internal.fastinfoset.stax.factory.StAXOutputFactory;

import java.sql.*;

/**
 * Created by thomasa on 10.12.13.
 */
public class JDBCConnectionExample {

    public static Connection getConnection() throws SQLException {
        String dataBase = "addressBook";
        String url = String.format("jdbc:mysql://localhost:3306/%s", dataBase);
        String user = "root";
        String password = "pass";
        return DriverManager.getConnection(url, user, password);


    }

    public static void main(String[] args) throws SQLException {

        /*
        Statement insert = connection.createStatement();
        insert.execute("insert into contact(firstName, lastName, email, phoneNo) values ('thomas','andersen','thomasa@bouvet.no','97407116')");
        */

        // all three JDBC resource classes are created inside the try-with-resources and will
        // ble closed when exiting the try/catch block
        try(Connection connection = getConnection();
            Statement stm = connection.createStatement();
            ResultSet resultSet = stm.executeQuery("SELECT * FROM contact")) {

            System.out.printf("ID\tfirstName\tlastName\temail\t\t\t\t\t%s %n","phoneNo");
            System.out.println("*******************************************************************");
            while (resultSet.next()){
                System.out.printf("%-2s\t", resultSet.getString(1));
                System.out.printf("%-10s\t",resultSet.getString("firstName"));
                System.out.printf("%-10s\t",resultSet.getString(3));
                System.out.printf("%-20s\t",resultSet.getString("email"));
                System.out.printf("%-10s\t",resultSet.getString(5));
                System.out.println();
            }
        } catch (SQLException e1) {
            e1.printStackTrace();
            throw e1;
        }



    }
}
