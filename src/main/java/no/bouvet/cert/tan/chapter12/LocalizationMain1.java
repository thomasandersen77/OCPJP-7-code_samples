package no.bouvet.cert.tan.chapter12;

import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: thomasa
 * Date: 07.01.14
 * Time: 11:07
 * To change this template use File | Settings | File Templates.
 */
public class LocalizationMain1 {

    public static void main(String[] args) {
        ResourceBundle resourceBundle = ResourceBundle.getBundle("chapter12\\ResourceBundle");
        assert resourceBundle != null;
        printKeyValues(resourceBundle);

        Locale locale = Locale.ITALY;
        resourceBundle = ResourceBundle.getBundle("chapter12/ResourceBundle", locale);
        assert resourceBundle != null;
        printKeyValues(resourceBundle);

        // languageCode, countryCode, variant
        Locale localeRome = new Locale("it", "IT", "Rome");
        resourceBundle = ResourceBundle.getBundle("chapter12/ResourceBundle", localeRome);
        assert resourceBundle != null;
        printKeyValues(resourceBundle);
    }

    private static void printKeyValues(ResourceBundle resourceBundle) {
        Set<String> keys = resourceBundle.keySet();
        for(String key : keys) {
            System.out.printf("key: [%s]\tvalue: [%s]%n", key, resourceBundle.getString(key));
        }
    }

}
