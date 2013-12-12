package no.bouvet.cert.gau.chapter12.LoadingAResourceBundle;

import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Created by gaute.lyngstad on 06.12.13.
 */

// Extend ResourceBundle.Control and getCandidateLocales method
// to get the list of candidates locales that Java searches for

class TalkativeResourceBundleControl extends ResourceBundle.Control {
    // override the default getCandidateLocales method to print
    // the candidate locales first

    @Override
    public List<Locale> getCandidateLocales(String baseName, Locale locale) {
        List<Locale> candidateLocales = super.getCandidateLocales(baseName, locale);
        System.out.printf("Candidate locales for base bundle name %s and locale %s %n",
                baseName, locale.getDisplayName());
        for(Locale candidateLocale : candidateLocales){
            System.out.println(candidateLocale);
        }
        return candidateLocales;
    }
}

public class CandidateLocales {

    public static void loadResourceBundle(String resourceBundleName, Locale locale){
        // Pass an instance of TalkativeResourceBundleControl
        // to print candidate locales
        ResourceBundle resourceBundle = ResourceBundle.getBundle(resourceBundleName, locale,
                new TalkativeResourceBundleControl());
        String rbLocaleName = resourceBundle.getLocale().toString();
        // if the resource bundle locale name is empty,
        // it means default property file
        if (rbLocaleName.equals("")) {
            System.out.println("Loaded the default property file with name: " +
            resourceBundleName);
        }else{
            System.out.println("Loaded the resource bundle for the locale: " +
            resourceBundleName + "." + rbLocaleName);
        }
    }

    public static void main(String[] args) {
        // trace how ResourceBundle_it_IT_ROME.properties is resovled
        loadResourceBundle("chapter12.ResourceBundle", new Locale("it", "IT", "Rome"));
    }

}
