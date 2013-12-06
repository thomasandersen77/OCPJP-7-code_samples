package no.bouvet.cert.chapter12.FormattingForLocalCulture.NumberFormat;

import java.text.NumberFormat;
import java.util.Locale;

/**
 * Created by gaute.lyngstad on 06.12.13.
 */

// Illustrates how to use NumberFormat class to get Currency instance
public class LocalizedCurrency {
    public static void main(String[] args) {
        long tenMillion = 10_000_000L;
        Locale[] locales = {Locale.CANADA,
                            Locale.FRANCE,
                            Locale.GERMANY,
                            Locale.TAIWAN};
        // for each of the four locales,
        // print the currency amount as it look in that locale
        for(Locale locale : locales){
            System.out.println("Then million in "+ locale.getDisplayName() + " is " +
                    NumberFormat.getCurrencyInstance(locale).format(tenMillion));
        }
    }
}
