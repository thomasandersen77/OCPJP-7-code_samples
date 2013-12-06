package no.bouvet.cert.gau.chapter11.TryWithResources;

import java.util.zip.*;
import java.io.*;
import static no.bouvet.cert.gau.chapter11.C11FilePath.*;
/**
 * Created with IntelliJ IDEA.
 * User: gaute.lyngstad
 * Date: 05.12.13
 * Time: 13:15
 * To change this template use File | Settings | File Templates.
 */
public class ZipTextFile {
    public static final int CHUNK = 1024; // to help copy chunks of 1KB
    public static final String FILE_NAME = C11_RESOURCE_PATH+"file.txt";

    public static void main(String[] args) {
        method(FILE_NAME);
    }

    public static void method(String... args) {
        if(args.length== 0){
            System.out.println("Pass the name of the file in the current directory to be zipped as an argument");
            System.exit(-1);
        }

        String fileName = args[0];
        //name of the zip file is the input file name with the suffix ".zip"
        String zipFileName = fileName + ".zip";

        byte[] buffer = new byte[CHUNK];
        //these constructors can throw FileNotFound Exception
        try(ZipOutputStream zipFile = new ZipOutputStream(new FileOutputStream(zipFileName));
                FileInputStream fileIn = new FileInputStream(fileName);) {
            //putNextEntry can throw IOException
            zipFile.putNextEntry(new ZipEntry(fileName));
            int lenRead = 0;    //variable to keep track of number of bytes
                                //successfully read
            //copy the contents of the input file into the zil file
            while((lenRead = fileIn.read(buffer))>0){
                // both read and write methods can throw IOException
                zipFile.write(buffer, 0, lenRead);
            }
            // the streams will be closed automatically because they are
            //within try-with-resources statement
        }
        // this can result in multiple exceptions thrown from the try block;
        // use "suppressed exceptions" to get the exceptions that were suppressed!
        catch (Exception e) {
            System.out.println("The caught exception is: " + e);
            System.out.print("The suppressed exception are: ");
            for(Throwable suppressed: e.getSuppressed()){
                System.out.println(suppressed);
            }
        }
    }
}
