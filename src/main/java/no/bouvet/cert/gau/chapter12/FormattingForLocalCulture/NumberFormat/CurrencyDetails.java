package no.bouvet.cert.gau.chapter12.FormattingForLocalCulture.NumberFormat;

import java.util.Currency;
import java.util.Locale;

/**
 * Created by gaute.lyngstad on 06.12.13.
 */
public class CurrencyDetails {
    public static void main(String[] args) {
        Locale locale = Locale.getDefault();
        Currency currencyInstance = Currency.getInstance(locale);
        System.out.println(" The currency code for locale " + locale
            + " is: " + currencyInstance.getCurrencyCode()
            + " \n The currency symbol is " + currencyInstance.getSymbol()
            + " \n The currency name is " + currencyInstance.getDisplayName());
    }
}
