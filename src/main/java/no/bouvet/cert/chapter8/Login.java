package no.bouvet.cert.chapter8;

import java.io.Console;
import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: gaute.lyngstad
 * Date: 02.12.13
 * Time: 11:14
 * To change this template use File | Settings | File Templates.
 */
public class Login {

    public static final String SCRAT = "scrat";
    public static final String NUTS = "nuts";

    public static void main(String []args){
        Console console = System.console();
        if(console != null) {
            String userName = null;
            char[] password = null;

            userName = console.readLine("Enter your username: ");
            password = console.readPassword("Enter password: ");
            if(userName.equals(SCRAT)&& new String(password).equals(NUTS)){
                console.printf("login successful!");
            }else {
                console.printf("restart application and try again");
            }
            Arrays.fill(password, ' ');
        }
    }
}
