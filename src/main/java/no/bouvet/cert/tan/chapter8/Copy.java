package no.bouvet.cert.tan.chapter8;

import java.io.*;

public class Copy {
    public static void main(String[] args) {
        if(args.length != 2) throw new IllegalArgumentException("Not correct number of arguments");

        try(BufferedReader reader = new BufferedReader(new FileReader(args[0]));
            BufferedWriter writer = new BufferedWriter(new FileWriter(args[1]))) {

            int ch = 0;
            while ((ch = reader.read()) > -1) {
                writer.write( (char) ch);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
