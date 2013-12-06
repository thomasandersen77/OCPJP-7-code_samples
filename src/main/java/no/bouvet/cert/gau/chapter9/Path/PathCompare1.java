package no.bouvet.cert.gau.chapter9.Path;

import java.nio.file.Path;
import java.nio.file.Paths;
import static no.bouvet.cert.gau.chapter9.C9FilePath.*;


/**
 * Created with IntelliJ IDEA.
 * User: gaute.lyngstad
 * Date: 03.12.13
 * Time: 09:49
 * To change this template use File | Settings | File Templates.
 */
public class PathCompare1 {

    public static final String ABSOLUTE_PATH = "D:\\OCA_Java_7_Certification\\src\\main\\resources\\chapter9\\Test";
    public static final String RELATIVE_PATH = C9_RESOURCE_PATH + "Test";

    public static void main(String[] args) {
        Path path1 = Paths.get(RELATIVE_PATH);
        Path path2 = Paths.get(ABSOLUTE_PATH);
        // compare two paths using compareTo() method
        System.out.println(path1);
        System.out.println(path2);
        System.out.println();
        System.out.println("(path1.compareTo(path2) == 0) is: " + (path1.compareTo(path2)==0));

        // comparing two paths using equals() method
        System.out.println("path1.equals(path2) is: " + path1.equals(path2));

        // comparing two paths using equals() method with absolute path
        System.out.println("path2.equals(path1.toAbsolutePath()) is: "+ path2.equals(path1.toAbsolutePath()));
    }
}
