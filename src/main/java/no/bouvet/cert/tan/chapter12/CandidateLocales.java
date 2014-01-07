package no.bouvet.cert.tan.chapter12;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Created with IntelliJ IDEA.
 * User: thomasa
 * Date: 07.01.14
 * Time: 11:21
 * To change this template use File | Settings | File Templates.
 */
public class CandidateLocales {


    public static ResourceBundle loadResourceBundle(String name, Locale locale){
        ResourceBundle bundle = ResourceBundle.getBundle(name, locale, new LocalCandidatesControl());
        return bundle;
    }
    public static void main(String[] args) {
        Locale locale = new Locale("it", "IT", "Rome");
        ResourceBundle bundle = loadResourceBundle("chapter12/ResourceBundle", locale);
        System.out.printf("Found bundle: %s", bundle.getLocale().toString());

        Locale locale2 = new Locale("fr", "CA");
        ResourceBundle bundle2 = loadResourceBundle("chapter12/ResourceBundle", locale2);
        System.out.printf("Found bundle: %s", bundle2.getLocale().toString());

    }
}
