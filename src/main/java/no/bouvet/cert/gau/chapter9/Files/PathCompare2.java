package no.bouvet.cert.gau.chapter9.Files;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static no.bouvet.cert.gau.chapter9.C9FilePath.*;

/**
 * Created with IntelliJ IDEA.
 * User: gaute.lyngstad
 * Date: 03.12.13
 * Time: 10:07
 * To change this template use File | Settings | File Templates.
 */
public class PathCompare2 {

    public static final String ABSOLUTE_PATH = "D:\\OCA_Java_7_Certification\\src\\main\\resources\\chapter9\\Test";
    public static final String RELATIVE_PATH = C9_RESOURCE_PATH + "Test";

    public static void main(String[] args) throws IOException {
        Path path1 = Paths.get(RELATIVE_PATH);
        Path path2 = Paths.get(ABSOLUTE_PATH);

        System.out.println("Files.isSameFile(path1, path2) is: "
                + Files.isSameFile(path1, path2));

    }
}
