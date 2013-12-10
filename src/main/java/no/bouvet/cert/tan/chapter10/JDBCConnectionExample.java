package no.bouvet.cert.tan.chapter10;

import java.sql.*;

/**
 * Created by thomasa on 10.12.13.
 */
public class JDBCConnectionExample {
    public static void main(String[] args) {
        String dataBase = "addressBook";
        String url = String.format("jdbc:mysql://localhost:3306/%s", dataBase);
        String user = "root";
        String password = "pass";

        try(Connection connection = DriverManager.getConnection(url, user, password)) {
            /*
            Statement insert = connection.createStatement();
            insert.execute("insert into contact(firstName, lastName, email, phoneNo) values ('thomas','andersen','thomasa@bouvet.no','97407116')");
            */

            Statement stm = connection.createStatement();
            ResultSet resultSet = stm.executeQuery("SELECT * FROM contact");
            while (resultSet.next()){
                System.out.printf("%s\t", resultSet.getString(1));
                System.out.printf("%s\t",resultSet.getString(2));
                System.out.printf("%s\t",resultSet.getString(3));
                System.out.printf("%s\t",resultSet.getString(4));
                System.out.printf("%s\t",resultSet.getString(5));
                System.out.println();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
