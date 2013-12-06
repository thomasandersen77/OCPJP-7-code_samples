package no.bouvet.cert.gau.chapter12.ResourceBundles;

import java.util.ListResourceBundle;

/**
 * Created by gaute.lyngstad on 06.12.13.
 */

// default US English version
public class ResBundle extends ListResourceBundle{

    @Override
    public Object[][] getContents() {
        return contents;
    }
    static final Object[][] contents = {
            {"MovieName", "Avatar"},
            {"GrossRevenue", (Long) 2782275172L},
            {"Year", (Integer)2009}
    };
}
