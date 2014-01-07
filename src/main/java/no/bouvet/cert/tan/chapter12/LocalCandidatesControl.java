package no.bouvet.cert.tan.chapter12;

import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Created with IntelliJ IDEA.
 * User: thomasa
 * Date: 07.01.14
 * Time: 11:22
 * To change this template use File | Settings | File Templates.
 */
public class LocalCandidatesControl extends ResourceBundle.Control {
    @Override
    public List<Locale> getCandidateLocales(String baseName, Locale locale) {
        List<Locale> localeList = super.getCandidateLocales(baseName, locale);
        for(Locale l : localeList) {
            System.out.printf("locale: %s%n", l);
        }
        return localeList;
    }
}
