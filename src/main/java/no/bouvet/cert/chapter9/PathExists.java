package no.bouvet.cert.chapter9;

import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;

import static no.bouvet.cert.chapter9.C9FilePath.C9PATH;


/**
 * Created with IntelliJ IDEA.
 * User: gaute.lyngstad
 * Date: 03.12.13
 * Time: 10:13
 * To change this template use File | Settings | File Templates.
 */
public class PathExists {

    public static void main(String[] args) {
        main2(C9PATH+"PathExists.java");
        main2("D:\\OCA_Java_7_Certification\\");
        main2("D:\\");
    }

    public static void main2(String... args) {
        Path path = Paths.get(args[0]);
        if(Files.exists(path, LinkOption.NOFOLLOW_LINKS)){
            System.out.println("The file/directory " + path.getFileName() + " exists");
            // check whether it is a file or a directory
            if(Files.isDirectory(path , LinkOption.NOFOLLOW_LINKS)) {
                System.out.println(path.getFileName() + " is a directory");
            }
            else{
                System.out.println(path.getFileName() + " is a file");
            }
        }
        else{
            System.out.println("The file/directory " + path.getFileName() + " does not exist");
        }
    }
}
