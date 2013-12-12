package no.bouvet.cert.gau.chapter14.TimeUnitEnumeration;

import java.util.concurrent.TimeUnit;

/**
 * Created by gaute.lyngstad on 10.12.13.
 */

// A simple example showing how to make use of TimeUnit enumeration
public class TimeUnitExample {
    public static void main(String[] args) throws InterruptedException{
        System.out.println("Calling sleep() method on main thread for 2 seconds");
        // Thread.sleep takes milli-seconds as argument. By using TimeUnit enumeration,
        // you can specify the time to sleep in other time units such as hours, minutes,
        // seconds, etc.
        Thread.sleep(TimeUnit.SECONDS.toMillis(2));
        System.out.println("main thread wakes up from sleep");
    }
}
