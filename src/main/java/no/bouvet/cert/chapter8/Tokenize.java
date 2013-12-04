package no.bouvet.cert.chapter8;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created with IntelliJ IDEA.
 * User: gaute.lyngstad
 * Date: 02.12.13
 * Time: 13:18
 * To change this template use File | Settings | File Templates.
 */
public class Tokenize {

    public static void main(String[] args) {
        method("limerick.txt");
    }

    public static void method(String... args) {
        Tokenize t = new Tokenize();

        if(args.length != 1){
            System.err.println("pass the name of the file to be read as an argument");
            System.exit(-1);
        }
        String fileName = args[0];
        // use the TreeSet<String> which will automatically sort the words
        // in alphabetical order

        Set<String> words = new TreeSet<>();
        try(Scanner tokenizingScanner = new Scanner(new FileReader(fileName))){
            // set the delimited for text as non-words (special characters,
            // white-spaces, etc), meaning that all words other than punctuation
            // characters, and white-spaces will be returned
            tokenizingScanner.useDelimiter("\\W");
            while (tokenizingScanner.hasNext()){
                String word = tokenizingScanner.next();
                if(!word.equals("")){ // process only non-empty strings
                    // convert to lowercase and then add to the set
                    words.add(word.toLowerCase());
                }
            }
            // now words are in alphabetical order without duplicates,
            // print the words separating them with tabs
            for(String word : words){
                System.out.print(word + '\t');
            }
        } catch (FileNotFoundException e) {
            System.err.println("Cannot read teh input file - pass a valid file name");
        }
    }
}
