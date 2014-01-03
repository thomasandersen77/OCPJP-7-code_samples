package no.bouvet.cert.tan.chapter10;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by thomasa on 11.12.13.
 */
public abstract class AbstractBase {
    public static void printContactResultSet(ResultSet resultSet) throws SQLException {
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
    }
}
