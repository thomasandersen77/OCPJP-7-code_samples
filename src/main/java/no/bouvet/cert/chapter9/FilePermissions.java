package no.bouvet.cert.chapter9;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static no.bouvet.cert.chapter9.C9FilePath.C9PATH;

/**
 * Created with IntelliJ IDEA.
 * User: gaute.lyngstad
 * Date: 03.12.13
 * Time: 10:26
 * To change this template use File | Settings | File Templates.
 */
public class FilePermissions {

    public static void main(String[] args) {
        method("readonly.txt");
        method(C9PATH+"FilePermissions.java");
    }

    static void method(String... args){
        Path path = Paths.get(args[0]);
        System.out.printf("Readable: %b, Writable: %b, Executable: %b ",
                Files.isReadable(path), Files.isWritable(path), Files.isExecutable(path));
        System.out.println();

    }
}
