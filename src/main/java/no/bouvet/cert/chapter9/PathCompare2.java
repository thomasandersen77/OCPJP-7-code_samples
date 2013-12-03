package no.bouvet.cert.chapter9;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created with IntelliJ IDEA.
 * User: gaute.lyngstad
 * Date: 03.12.13
 * Time: 10:07
 * To change this template use File | Settings | File Templates.
 */
public class PathCompare2 {
    public static void main(String[] args) throws IOException {
        Path path1 = Paths.get("Test");
        Path path2 = Paths.get("D:\\OCA_Java_7_Certification\\Test");

        System.out.println("Files.isSameFile(path1, path2) is: "
                + Files.isSameFile(path1, path2));

    }
}
