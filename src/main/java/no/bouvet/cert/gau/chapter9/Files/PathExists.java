package no.bouvet.cert.gau.chapter9.Files;

import no.bouvet.cert.gau.chapter9.util.PathResolver;

import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;

import static no.bouvet.cert.gau.chapter9.C9FilePath.*;


/**
 * Created with IntelliJ IDEA.
 * User: gaute.lyngstad
 * Date: 03.12.13
 * Time: 10:13
 * To change this template use File | Settings | File Templates.
 */
public class PathExists {

    public static void main(String[] args) {
        main2(C9_FILES_PATH +"PathExists.java");
        main2("D:\\OCA_Java_7_Certification\\");
        main2("D:\\");
        main2(new PathResolver(C9_RESOURCE_PATH).getResourcesPath()+"\\thomas.txt");
        printPath(new PathResolver(C9_FILES_PATH +"PathExists.java"));
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

    public static void printPath(PathResolver pathResolver) {
        System.out.printf("RelativePath [%s]\n", pathResolver.getRelativePath());
        System.out.printf("AbsolutePath [%s]\n", pathResolver.getAbsolutePath());
        System.out.printf("ResourcePath [%s]\n", pathResolver.getResourcesPath());
    }
}
