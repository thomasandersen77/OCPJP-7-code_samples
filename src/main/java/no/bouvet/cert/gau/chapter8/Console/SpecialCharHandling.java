package no.bouvet.cert.gau.chapter8.Console;

import java.io.Console;
import java.util.logging.Logger;

/**
 * Created with IntelliJ IDEA.
 * User: gaute.lyngstad
 * Date: 02.12.13
 * Time: 12:04
 * To change this template use File | Settings | File Templates.
 */
public class SpecialCharHandling {

    Logger log = Logger.getLogger(this.getClass().getName());
    public static void main(String []args){
        String scandString = "å, ä and ö";
        System.out.println("Printing scands directly with println: "+scandString);
        Console console = System.console();
        console.printf("Printing scands thro' console's printf method: "+scandString);

    }


}
