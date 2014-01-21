package no.bouvet.cert.tan.chapter7;

/**
 * Created with IntelliJ IDEA.
 * User: thomasa
 * Date: 21.01.14
 * Time: 10:09
 * To change this template use File | Settings | File Templates.
 */
public class StringSearching1 {
    public static void main(String[] args) {

        regionMatches();
        indexOfMultiple();
    }

    private static void indexOfMultiple() {

        String str = "I am an OCPJP student and I am reading for the exam";
        int index = 0;

        while(str.indexOf("am", index) > -1) {
            index = str.indexOf("am", index);
            System.out.printf("Found \"am\" at index = %s%n", index);
            index++;
        }


    }

    private static void regionMatches() {
        String searchStr = "Testing region matches with ignoreCase = true";

        String indexOfWord = "with";
        int startIndex = searchStr.indexOf(indexOfWord);

        if(startIndex > -1) {
            System.out.println(searchStr.substring(startIndex + indexOfWord.length() + 1));
            String matchStr = "ignorecase";
            boolean found = searchStr.regionMatches(true, startIndex + indexOfWord.length() + 1, matchStr, 0, matchStr.length());
            System.out.println(found);
        }
    }
}
