package no.bouvet.cert.tan.chapter11;

import java.io.*;
import java.nio.file.AccessDeniedException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Created with IntelliJ IDEA.
 * User: thomasa
 * Date: 07.01.14
 * Time: 18:41
 * To change this template use File | Settings | File Templates.
 */
public class NonStaticInitBlockWithCheckedException {

    private File file;
    // this block will be merged with constructor at compile time.
    // therefor all exceptions has to be handled by the constructor or else it will give a compile error
    {
        file = Files.createFile(Paths.get("/temp").toAbsolutePath()).toFile();
    }
    // because the compiler merges the init block, the IOException can be declared thrown here
    public NonStaticInitBlockWithCheckedException() throws IOException  {
        if(file.exists()) {
            System.out.println("File exists");
        } else {
            throw new IOException("File does not exist");
        }
    }

    public static void main(String[] args) throws IOException {

        try {
            new NonStaticInitBlockWithCheckedException();
        } catch (AccessDeniedException e) {
            System.out.println(e);
        }
    }
}
