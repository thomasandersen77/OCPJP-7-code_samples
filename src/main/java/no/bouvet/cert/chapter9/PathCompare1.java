package no.bouvet.cert.chapter9;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created with IntelliJ IDEA.
 * User: gaute.lyngstad
 * Date: 03.12.13
 * Time: 09:49
 * To change this template use File | Settings | File Templates.
 */
public class PathCompare1 {
    public static void main(String[] args) {
        Path path1 = Paths.get("Test");
        Path path2 = Paths.get("D:\\OCA_Java_7_Certification\\Test");
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
