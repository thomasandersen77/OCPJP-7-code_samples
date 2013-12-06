package no.bouvet.cert.gau.chapter8.Console;

import java.io.Console;

/**
 * Created with IntelliJ IDEA.
 * User: gaute.lyngstad
 * Date: 02.12.13
 * Time: 10:47
 * To change this template use File | Settings | File Templates.
 */
public class Echo {

    public static final String ERROR_MESSAGE = "Cannot retrive console object - are you running your" +
            " application from IDE? Exiting the application ... ";

    public static void main(String args[]){
        Console console = System.console();
        if(console==null){
            System.err.println(ERROR_MESSAGE);
            System.exit(-1);
        }
        console.printf("Write username: ");
        console.printf("You wrote: %s \n",console.readLine());
        console.printf("Write password: ");
        console.printf("Password: %s \n", console.readPassword());

    }
}
