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
public class DbQuery4 {

    private static final String SELECT_STATEMENT = "SELECT "+FIRST_NAME+", "+EMAIL+ " FROM "+TABLE_CONTACT+ " WHERE "+FIRST_NAME+"=\"Michael\"";
    private static final String ATTRIBUTES = "fName \temail";

    public static void main(String[] args) {

        //try-with-resources (j7)
        try(Connection connection = DbConnector.connectToDb();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SELECT_STATEMENT)){


            System.out.println(ATTRIBUTES);
            while (resultSet.next()){

                System.out.println(resultSet.getString(FIRST_NAME) + "\t"
                    + resultSet.getString(EMAIL));
                 //with printf
                //System.out.printf("%s\t%s", resultSet.getString(FIRST_NAME), resultSet.getString(EMAIL));
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.exit(-1);
        }
    }
}
