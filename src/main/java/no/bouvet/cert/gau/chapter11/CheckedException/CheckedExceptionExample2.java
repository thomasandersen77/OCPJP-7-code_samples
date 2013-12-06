package no.bouvet.cert.gau.chapter11.CheckedException;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * Created with IntelliJ IDEA.
 * User: gaute.lyngstad
 * Date: 05.12.13
 * Time: 13:49
 * To change this template use File | Settings | File Templates.
 */
public class CheckedExceptionExample2 {

    public static void main(String[] args) throws FileNotFoundException{
        method("file.txt");
    }

    public static void method(String... args) throws FileNotFoundException{
        FileInputStream fis = new FileInputStream(args[0]);
    }
}
