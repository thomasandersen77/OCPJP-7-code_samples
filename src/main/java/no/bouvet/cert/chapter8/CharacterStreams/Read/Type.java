package no.bouvet.cert.chapter8.CharacterStreams.Read;

import java.io.*;
import java.util.logging.Logger;

/**
 * Created with IntelliJ IDEA.
 * User: gaute.lyngstad
 * Date: 02.12.13
 * Time: 12:51
 * To change this template use File | Settings | File Templates.
 */
public class Type {
    Logger log = Logger.getLogger(this.getClass().getName());

    public static void main(String[] files) {

        files = new String[]{"text.txt"};
        String desFile = "output.txt";
        if(files.length == 0){
            System.err.println("pass the name of the file(s) as argument");
            System.exit(-1);
        }

        for(String file : files){
            try(BufferedReader inputFile = new BufferedReader(new FileReader(file));
            BufferedWriter outputFile = new BufferedWriter(new FileWriter(desFile))){
                int ch = 0;
                while((ch = inputFile.read()) != -1){
                    System.out.print((char) ch);
                    outputFile.write((char)ch);
                }
            } catch (FileNotFoundException e) {
                System.err.printf("Cannot open the given file %s ", file);
            } catch (IOException e) {
                System.err.printf("Error when processing file %s... skipping it", file);
            }
        }
    }
}
