package no.bouvet.cert.tan.chapter7;

/**
 * Created by thomasa on 09.12.13.
 */
public class PrintfTests {
    public static void main(String[] args) {
        String s1 = "%-20s \t %.2f%n";
        System.out.printf(s1, "Thomas", 36.234);
        System.out.printf(s1, "1234567890123", 36.1);
        /* prints:
        Thomas               	 36.23
        1234567890123        	 36.10
        */

    }
}
