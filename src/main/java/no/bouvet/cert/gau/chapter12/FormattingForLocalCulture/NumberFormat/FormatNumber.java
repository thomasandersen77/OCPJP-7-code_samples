package no.bouvet.cert.gau.chapter12.FormattingForLocalCulture.NumberFormat;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

/**
 * Created by gaute.lyngstad on 06.12.13.
 */
public class FormatNumber {

    public static final String SUCCESSFUL = "Successfully parsed the number for the locale";
    public static final String ERROR = "Error: Cannot parse the number for the locale";

    public static void main(String[] args) {
        long tenMillion = 10_000_000L;
        // first print ten million in German locale
        NumberFormat germanFormat = NumberFormat.getInstance(Locale.GERMANY);
        String localizedTenMillion = germanFormat.format(tenMillion);
        System.out.println("Ten million in German locale is " + localizedTenMillion);

        // now, scan the value ten million given in German locale
        try {
            Number parsedAmount = germanFormat.parse(localizedTenMillion);
            if(tenMillion == parsedAmount.longValue()){
                System.out.println(SUCCESSFUL);
            }
        } catch (ParseException e) {
            System.out.println(ERROR);
        }
    }
}
