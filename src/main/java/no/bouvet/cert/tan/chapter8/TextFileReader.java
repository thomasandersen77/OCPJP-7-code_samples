package no.bouvet.cert.tan.chapter8;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by thomasa on 09.12.13.
 */
public class TextFileReader {
    public static void main(String[] args) {
        try(FileReader fr = new FileReader("C:/temp/test.txt")){
            int c = 0;
            while((c = fr.read()) != -1) {
                System.out.print((char)c);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
