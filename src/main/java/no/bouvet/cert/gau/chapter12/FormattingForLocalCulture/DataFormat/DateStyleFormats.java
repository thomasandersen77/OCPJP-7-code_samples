package no.bouvet.cert.gau.chapter12.FormattingForLocalCulture.DataFormat;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by gaute.lyngstad on 09.12.13.
 */
public class DateStyleFormats {

    public static void main(String[] args) {
        Date now = new Date();
        String[] titles = {"Short", "Medium", "Long", "Full", "Default"};
        int[] dateStyleFormats = {DateFormat.SHORT, DateFormat.MEDIUM, DateFormat.LONG, DateFormat.FULL, DateFormat.DEFAULT};
        System.out.println("Today's date in diffrent styles are: ");

        // print today's date in all four formats plus
        // the default format in the default Locale
        int count = 0;
        for(int dateStyleFormat : dateStyleFormats){
            DateFormat dateFormat = DateFormat.getDateInstance(dateStyleFormat);
            System.out.print(count<titles.length?titles[count++]+"\t: ":"");
            System.out.println(dateFormat.format(now));
        }

    }
}
