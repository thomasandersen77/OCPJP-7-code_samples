package no.bouvet.cert.chapter11.TryWithResources;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * User: gaute.lyngstad
 * Date: 05.12.13
 * Time: 13:06
 * To change this template use File | Settings | File Templates.
 */
public class TryWithResources2 {
    public static void main(String[] args) {
        method("10");
        method("ten");
    }
    public static void method(String... args) {
        System.out.println("Type an integer in the console");
        System.out.println(args[0]);
        try(Scanner consoleScanner = new Scanner(args[0])){
            System.out.println("You typed the integer value: " + consoleScanner.nextInt());
        }

    }
}
