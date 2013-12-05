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
public class DbCreateTable {

    private static final String CREATE_STATEMENT = "CREATE TABLE "+TABLE_FAMILY_GROUP+" ("+
            ID+" int not null auto_increment, "+
            NICK_NAME+" varChar(30) not null, " +
            "primary key("+ID+"));";
    private static final String SUCCESSFUL = "Table created successfully";

    public static void main(String[] args) {

        //try-with-resources (j7)
        try(Connection connection = DbConnector.connectToDb();
            Statement statement = connection.createStatement();){
            // use CREATE TABLE SQL statement to create table familyGroup

            int result = statement.executeUpdate(CREATE_STATEMENT);
            System.out.println(SUCCESSFUL);

        } catch (SQLException e) {
            e.printStackTrace();
            System.exit(-1);
        }
    }
}
