package no.bouvet.cert.gau.chapter11.MultiCatch;

import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * User: gaute.lyngstad
 * Date: 05.12.13
 * Time: 12:11
 * To change this template use File | Settings | File Templates.
 */
public class ScanInt5 {

    private static final String ERROR_MESSAGE = "Error: An error occured while attempting to scan the integer";

    public static void main(String[] args) {
        String integerStr = "";
        System.out.println("The string to scan integer from it is: "+integerStr);
        Scanner consoleScanner = new Scanner(integerStr);
        try{
            System.out.println("The integer value scanned from string is: "+
            consoleScanner.nextInt());
        }catch (NoSuchElementException | IllegalStateException multi){
            System.out.println(ERROR_MESSAGE);
        }
    }
}
