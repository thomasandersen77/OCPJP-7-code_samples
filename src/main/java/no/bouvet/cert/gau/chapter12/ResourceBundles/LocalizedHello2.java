package no.bouvet.cert.gau.chapter12.ResourceBundles;

import java.nio.file.Paths;
import java.util.Locale;
import java.util.ResourceBundle;
/**
 * Created by gaute.lyngstad on 06.12.13.
 */
public class LocalizedHello2 {

    /**
     *
     * @param resBundle
     */
    public static void printMovieDetails(ResourceBundle resBundle){
        String movieName = resBundle.getString("MovieName");
        Long grossRevenue = (Long) (resBundle.getObject("GrossRevenue"));
        Integer year = (Integer) resBundle.getObject("Year");
        System.out.println("Movie " + movieName + "("+year+")"+" grossed "+grossRevenue);
    }
    
    public static void main(String[] args) {
        System.out.println(Paths.get(".").toAbsolutePath());
        // print the largest box-office hit movie for default (US) locale
        Locale locale = Locale.getDefault();
        printMovieDetails(ResourceBundle.getBundle(LocalizedHello2.class.getPackage().getName()+".ResBundle", locale));

        // print the largest box-office hit movie for Italian locale
        locale = new Locale("it", "IT", "");
        printMovieDetails(ResourceBundle.getBundle(LocalizedHello2.class.getPackage().getName()+".ResBundle", locale));
    }
}
