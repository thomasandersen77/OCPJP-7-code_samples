package no.bouvet.cert.chapter9;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import static no.bouvet.cert.chapter9.C9FilePath.C9PATH;

/**
 * Created with IntelliJ IDEA.
 * User: gaute.lyngstad
 * Date: 03.12.13
 * Time: 11:05
 * To change this template use File | Settings | File Templates.
 */
public class FileCopy {

    private static final String src = C9PATH+"FileCopy.java";
//    private static final String des = ".\\src\\main\\java\\no\\bouvet\\cert\\chapter9\\Backup.txt";
    private static final String des = C9PATH+"Backup.txt";

    public static void main(String[] args) {
        method(src, des);
    }

    public static void method(String... args) {
        if(args.length!=2){
            System.out.println("usage: FileCopy <source-path> <destination-path>");
            System.exit(-1);
        }
        Path pathSource = Paths.get(args[0]);
        Path pathDestination = Paths.get(args[1]);

        try{
//            Files.copy(pathSource,pathDestination);
            Files.copy(pathSource, pathDestination, StandardCopyOption.REPLACE_EXISTING);
                    System.out.println("Source file copied sucessfully");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
