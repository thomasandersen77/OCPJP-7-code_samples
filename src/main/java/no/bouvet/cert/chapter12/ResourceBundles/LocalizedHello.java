package no.bouvet.cert.chapter12.ResourceBundles;

import java.net.URL;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;
import static no.bouvet.cert.chapter12.C12FilePath.*;
/**
 * Created by gaute.lyngstad on 06.12.13.
 */
public class LocalizedHello {
    /**
     * <par>
     *     <ul>
     *         <li>A resourceBundle refers to a .properties file, that hold data for a predefined locale/language </li>
     *         <li>The .properties files must be defined, in the form "String" = "String" (f.eks. 'Greeting = Hello')</li>
     *         <li>The resource bundled used by this method is defined as ResourceBundle_#languageCode#_#countryCode#.properties</li>
     *     </ul>
     * </par>
     *
     * @param location set location in form of 'Locale.ITALY' or 'new Locale("ar","", "")'. Passing null will result in default location being used
     * @throws MissingResourceException
     */
    public void resourceBundle(Locale location) throws MissingResourceException {
        if(location!=null)
            Locale.setDefault(location);
        Locale currentLocale = Locale.getDefault();
        ResourceBundle resBundle = ResourceBundle.getBundle("ResourceBundle", currentLocale);
        System.out.printf(resBundle.getString("Greeting"));
    }

    public static void main(String[] args) {
        new LocalizedHello().resourceBundle(null);
    }
}
