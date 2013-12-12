package no.bouvet.cert.gau.chapter7.Eksperimentere;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: gaute.lyngstad
 * Date: 02.12.13
 * Time: 09:30
 * To change this template use File | Settings | File Templates.
 */
public class Test2 {
    public static void main(String args[]){
//        System.out.printf("%+0d",100);
        System.out.println();

        // ${#)}
        System.out.printf("\"$%(,9.2f\"", -1222.2);
        System.out.println();
        System.out.printf("\"$%(,d\"", -1000000);
        System.out.println();
        System.out.printf("%b", false);
        System.out.println();

        java.util.StringTokenizer st = new java.util.StringTokenizer("axaaxaaa", "x");
        while (st.hasMoreTokens()) {
            System.out.println(st.nextToken());
        }

        String[] split = "name:john;;sex:m;;".split(";");
        System.out.println(Arrays.toString(split));

    }
}
