package no.bouvet.cert.chapter8.ByteStream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: gaute.lyngstad
 * Date: 02.12.13
 * Time: 13:49
 * To change this template use File | Settings | File Templates.
 */
public class ClassFileMagicNumbersChecker {

    public static final String ERROR_MESSAGE = "Pass a valid file name as argument";
    public static final String FILE_NOT_FOUND = "file does not exist with the given file name ";
    public static final String I_O_EXCEPTION = "an I/O error occurred while processing the file";

    public static void main(String[] args) {
        // use console and send in a .class file
        method(args);
    }

    public static void method(String... args) {
        if(args.length != 1){
            System.err.println(ERROR_MESSAGE);
            System.exit(-1);
        }
        String fileName = args[0];
        //create a magicNumber byte array with values for four bytes in 0xCAFEBABE
        // you need to have a explicit down case to byte since
        // the hex value like 0xCA are of type int
        byte []magicNumber = {(byte) 0xCA, (byte)0xFE, (byte)0xBA, (byte)0xBE};
        try(FileInputStream fis = new FileInputStream(fileName)){
            // magic number is of 4 byte[4]
            // use a temorary buffer ot read first four bytes
            byte[] u4buffer = new byte[4];
            // read a buffer full (4 bytes here) of data from the file
            if(fis.read(u4buffer)!=-1){ // if read was successful
                // the overloaded method equals for two byte arrays
                // checks for equality of contents
                if(Arrays.equals(magicNumber,u4buffer)){
                    System.out.printf("The magic number for passed file %s" +
                            " match that of a .class file", fileName);
                }else{
                    System.out.printf("The magic number for passed file %s does" +
                            " not match that of a .class file", fileName);
                }

            }
        } catch (FileNotFoundException e) {
            System.err.println(FILE_NOT_FOUND);
        } catch (IOException e) {
            System.err.println(I_O_EXCEPTION);
        }
    }
}
