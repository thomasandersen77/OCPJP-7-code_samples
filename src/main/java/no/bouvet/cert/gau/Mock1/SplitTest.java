package no.bouvet.cert.gau.Mock1;

/**
 * Created by gaute.lyngstad on 11.12.13.
 */
public class SplitTest {
    public static void main(String[] args) {
        String quote = "aba*abaa**aabaa***";
        // match to a string starting from an "a" followed by zero or more "*"
        // "\\**" means zero or more occurrences of "*"
        // |-| a |-b-| a* |-| a |-b-| a |-| a** |-| a |-| a |-b-| a |-| a*** |-|
        String[] result = {"","b","","b","","","","b","",""};
        String [] words = quote.split("a\\**",10);
        int n = 1;
        System.out.println("regex");
        for(String word : words){
            System.out.println((n++)+": "+word);
        }
        System.out.println();
        System.out.println("expected");
        for(String word : result){
            System.out.println((n++)+": "+word);
        }
    }
}
