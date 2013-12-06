package no.bouvet.cert.chapter11.FinallyBlock;

import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * User: gaute.lyngstad
 * Date: 05.12.13
 * Time: 12:11
 * To change this template use File | Settings | File Templates.
 */
public class ScanInt7 {

    public static final String ERROR_MESSAGE = "Error: Encountered an exception and could not read an integer from the console...";
    public static final String ERROR_SOLUTION_MESSAGE = "Exiting the program - restart and try the program again!";

    public static void main(String[] args) {
        method("10");
        method("ten");
    }

    public static void method(String... args) {
        if(args.length==0)System.exit(-1);

        System.out.println("Type an integer in the console: ");
        System.out.println(args[0]);
        Scanner consScanner = new Scanner(args[0]);

        try{
            System.out.println("You typed the integer value: "+
                consScanner.nextInt());
        }catch (Exception e){
            // call all other exceptions here ...
            System.out.println(ERROR_MESSAGE);
            System.out.println(ERROR_SOLUTION_MESSAGE);
        }finally {
            System.out.println("Done reading the text... closing the Scanner");
            consScanner.close();
        }
    }
}
