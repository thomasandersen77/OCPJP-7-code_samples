package no.bouvet.cert.gau.chapter12.ResourceBundles;

import java.util.ListResourceBundle;

/**
 * Created by gaute.lyngstad on 06.12.13.
 */

//Italian version
public class ResBundle_it_IT extends ListResourceBundle{

    @Override
    public Object[][] getContents() {
        return contents;
    }
    static final Object[][] contents = {
            {"MovieName", "Che Bella Giornata"},
            {"GrossRevenue", (Long) 43000000L},
            {"Year", (Integer)2011}
    };
}
