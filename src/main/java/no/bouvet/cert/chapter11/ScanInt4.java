package no.bouvet.cert.chapter11;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * User: gaute.lyngstad
 * Date: 05.12.13
 * Time: 12:11
 * To change this template use File | Settings | File Templates.
 */
public class ScanInt4 {

    private static final String ERROR_MESSAGE_INPUT_MISMATCH = "Error: Cannot scan an integer from the given string";
    private static final String ERROR_MESSAGE_NO_SUCH_ELEMENT = "Error: Cannot scan an integer from the given string";
    private static final String ERROR_MESSAGE_ILLEGAL_STATE = "Error: nextInt() called on a closed Scanner object";

    public static void main(String[] args) {
//        String integerStr = "100";
//        String integerStr = "hundred";
        String integerStr = "";
        System.out.println("The string to scan integer from it is: "+integerStr);
        Scanner consoleScanner = new Scanner(integerStr);
        try{
            System.out.println("The integer value scanned from string is: "+
            consoleScanner.nextInt());
        }catch (InputMismatchException ime){
            // nextInt() throws InputMismatchException in case anything other than an integer
            // is provided in the string
            System.out.println(ERROR_MESSAGE_INPUT_MISMATCH);
        }catch (NoSuchElementException nsee){
            System.out.println(ERROR_MESSAGE_NO_SUCH_ELEMENT);
        }catch (IllegalStateException ise){
            System.out.println(ERROR_MESSAGE_ILLEGAL_STATE);
        }
    }
}
