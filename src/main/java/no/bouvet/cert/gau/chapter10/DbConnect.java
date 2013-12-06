package no.bouvet.cert.gau.chapter10;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Created with IntelliJ IDEA.
 * User: gaute.lyngstad
 * Date: 04.12.13
 * Time: 14:14
 * To change this template use File | Settings | File Templates.
 */
public class DbConnect {

    // url points to jdbc protocol : mysql subprotocol; locolhost is the address
    // of the server where we installed our DBMS (i.e. on local machine) and
    // 3306 is the port on which we need to contact our DBMS
    private static final String URL = "jdbc:mysql://localhost:3306/";

    // we are connecting to the addressBook database we created earlier
    private static final String DATABASE = "addressBook";


    //we login as "root" user with PASSWORD "pass"
    private static final String USER_NAME = "root";
    private static final String PASSWORD = "pass";

    // Messages
    public static final String SUCCESSFUL = "DataBase connection: Successful";
    public static final String FAILED = "Database connection: Failed";

    public static void main(String[] args) {

       try(Connection connection = DriverManager.getConnection(
               URL + DATABASE,
               USER_NAME,
               PASSWORD)){
           System.out.println(SUCCESSFUL);
       }catch(Exception e){
           System.out.println(FAILED);
           e.printStackTrace();
       }

    }
}
