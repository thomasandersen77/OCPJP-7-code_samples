package no.bouvet.cert.gau.chapter12.FormattingForLocalCulture.DataFormat;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by gaute.lyngstad on 09.12.13.
 */
public class PatternStringExample {
    public static void main(String[] args) {
        String pattern = "dd-MM-yy"; //d for day, M for month, y for year
        SimpleDateFormat formatter = new SimpleDateFormat(pattern);
        // the default Date constructor initializes the current date/time
        System.out.println(formatter.format(new Date()));
    }
}
