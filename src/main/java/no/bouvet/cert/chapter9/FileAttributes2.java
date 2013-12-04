package no.bouvet.cert.chapter9;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.DosFileAttributes;

import static no.bouvet.cert.chapter9.C9FilePath.C9_PATH;


/**
 * Created with IntelliJ IDEA.
 * User: gaute.lyngstad
 * Date: 03.12.13
 * Time: 10:49
 * To change this template use File | Settings | File Templates.
 */
public class FileAttributes2 {

    public static void main(String[] args) {
        method(C9_PATH +"FileAttributes2.java");
    }

    public static void method(String... args) {
        Path path = Paths.get(args[0]);
        try{
            BasicFileAttributes fileAttributes = Files.readAttributes(path, BasicFileAttributes.class);
            System.out.println("File size: "+ fileAttributes.size());
            System.out.println("isDirectory: "+fileAttributes.isDirectory());
            System.out.println("isRegularFile: "+fileAttributes.isRegularFile());
            System.out.println("isSymbolicLink: "+ fileAttributes.isSymbolicLink());
            System.out.println("File last accessed time: " + fileAttributes.lastAccessTime());
            System.out.println("File created time: "+fileAttributes.creationTime());

            //Windows only
            System.out.println();
            DosFileAttributes dosFileAttributes = Files.readAttributes(path, DosFileAttributes.class);
            System.out.println("isArchive: "+dosFileAttributes.isArchive());
            System.out.println("isHidden: "+dosFileAttributes.isHidden());
            System.out.println("isReadOnly: "+dosFileAttributes.isReadOnly());
            System.out.println("isSystem: "+dosFileAttributes.isSystem());

            //Unix only
//            System.out.println();
//            PosixFileAttributes posixFileAttributes = Files.readAttributes(path, PosixFileAttributes.class);
//            System.out.println("Group: "+posixFileAttributes.group());
//            System.out.println("Owner: "+posixFileAttributes.owner());
//            System.out.println("Permissions: "+posixFileAttributes.permissions());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
