package no.bouvet.cert.chapter12.Locales;

import java.util.Locale;

/**
 * Created with IntelliJ IDEA.
 * User: gaute.lyngstad
 * Date: 06.12.13
 * Time: 08:35
 * To change this template use File | Settings | File Templates.
 */
public class AvailableLocales {
    public static void main(String[] args) {
        System.out.println("The default locale is: " + Locale.getDefault());
        Locale [] locales = Locale.getAvailableLocales();
        System.out.printf("No. of other available locales is : %d, and they are: %n", locales.length);
        for(Locale locale : locales){
            System.out.printf("Locale code: %s and it stands for %s %n", locale, locale.getDisplayName());
        }
    }
}
