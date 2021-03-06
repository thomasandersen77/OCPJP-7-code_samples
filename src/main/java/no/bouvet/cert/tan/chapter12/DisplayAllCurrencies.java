package no.bouvet.cert.tan.chapter12;

import java.text.NumberFormat;
import java.util.Currency;
import java.util.Locale;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: thomasa
 * Date: 07.01.14
 * Time: 12:37
 * To change this template use File | Settings | File Templates.
 */
public class DisplayAllCurrencies {
    public static void main(String[] args) {

        Locale[] locales = Locale.getAvailableLocales();
        for(Locale locale : locales) {
            if(!locale.toString().isEmpty()) {
                try {
                    Currency currency = Currency.getInstance(locale);
                    System.out.printf("%s\t%s\t%s\t%s%n", currency.getSymbol(), currency.getCurrencyCode(), currency.getDisplayName(), currency.getNumericCode());
                } catch (Exception e) {
                    System.out.printf("**** NO CURRENCY FOR LOCALE %s ****************%n", locale);
                }
            }
        }
        System.out.println("\n\n");

        Set<Currency> currencies = Currency.getAvailableCurrencies();
        for(Currency currency : currencies) {
            System.out.printf("%s\t%s\t%s\t%s%n", currency.getSymbol(), currency.getCurrencyCode(), currency.getDisplayName(), currency.getNumericCode());
        }



    }
}
