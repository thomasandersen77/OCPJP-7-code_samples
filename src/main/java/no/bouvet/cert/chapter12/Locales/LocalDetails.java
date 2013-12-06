package no.bouvet.cert.chapter12.Locales;

import java.util.Locale;

/**
 * Created with IntelliJ IDEA.
 * User: gaute.lyngstad
 * Date: 06.12.13
 * Time: 08:46
 * To change this template use File | Settings | File Templates.
 */
public class LocalDetails {
    public static void main(String[] args) {
        Locale.setDefault(Locale.CANADA_FRENCH);
        Locale defaultLocale = Locale.getDefault();
        System.out.printf("The default locale is %s %n", defaultLocale);
        System.out.printf("The default language code is %s and the name is %s %n",
                defaultLocale.getLanguage(), defaultLocale.getDisplayLanguage());
        System.out.printf("The default country code is %s and the name is %s %n",
                defaultLocale.getCountry(), defaultLocale.getDisplayCountry());
        System.out.printf("The default variant code is %s and the name is %s %n",
                defaultLocale.getVariant(), defaultLocale.getDisplayVariant());
    }
}
