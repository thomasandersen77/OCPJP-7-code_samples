package no.bouvet.cert.gau.chapter12.FormattingForLocalCulture.DataFormat;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by gaute.lyngstad on 09.12.13.
 */
public class TimePattern {
    public static void main(String[] args) {
        // patterns from simple to complex ones
        String [] timeFormats = {
                "h:mm", /* h is hour in am/pm (1-12), m is minute*/
                "hh 'o''clock'", /* '' is the escape sequence to print a single quote */
                "H:mm a", /* H is hour in day (0-23), a is am/pm */
                "hh:mm:ss:SS", /* s in seconds, S in milliseconds */
                "K:mm:ss a, zzzz" /* K is hour in am/pm(0-11), z is time zone */
        };
        Date today = new Date();
        System.out.println("Default format for the time is " +
                DateFormat.getTimeInstance().format(today));
        for(String timeFormat : timeFormats){
            System.out.printf("Time is pattern \"%s\" is: %s %n", timeFormat,
                    new SimpleDateFormat(timeFormat).format(today));
        }
    }
}
