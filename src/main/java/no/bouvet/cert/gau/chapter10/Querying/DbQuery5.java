package no.bouvet.cert.gau.chapter10.Querying;

import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;
import java.sql.SQLException;

import static no.bouvet.cert.gau.chapter10.DbConstants.*;
import static no.bouvet.cert.gau.chapter10.DbConnector.*;
/**
 * Created with IntelliJ IDEA.
 * User: gaute.lyngstad
 * Date: 04.12.13
 * Time: 14:58
 * To change this template use File | Settings | File Templates.
 */
public class DbQuery5 {

    public static final String SELECT_STATEMENT_ALL_CONTACT = "SELECT * FROM " + TABLE_CONTACT;
    public static final String ATTRIBUTES = "id \tfName \tlname \temail \t\tphoneNo";

    public static void main(String[] args) {

        try{
           //first, create a factory object for rowset
            RowSetFactory rowSetFactory = RowSetProvider.newFactory();
            //create a JDBC rowset from the factory
            JdbcRowSet rowSet = rowSetFactory.createJdbcRowSet();
            rowSet.setUrl(URL+DATABASE);
            rowSet.setUsername(USER_NAME);
            rowSet.setPassword(PASSWORD);
            rowSet.setCommand(SELECT_STATEMENT_ALL_CONTACT);
            rowSet.execute();

            System.out.println(ATTRIBUTES);
            while(rowSet.next()){
                System.out.println(rowSet.getInt(ID) + "\t"
                        + rowSet.getString(FIRST_NAME) + "\t"
                        + rowSet.getString(LAST_NAME) + "\t"
                        + rowSet.getString(EMAIL)+ "\t"
                        +rowSet.getString(PHONE_NO));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
