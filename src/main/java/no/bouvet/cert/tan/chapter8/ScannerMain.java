package no.bouvet.cert.tan.chapter8;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * User: thomasa
 * Date: 22.01.14
 * Time: 14:15
 * To change this template use File | Settings | File Templates.
 */
public class ScannerMain {
    public static void main(String[] args) {


        try(Scanner scanner = new Scanner(new FileInputStream("chapter8/readCopyFile.txt"))){
            while ( scanner.hasNext() ){
                System.out.println(scanner.next());
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

    }
}
