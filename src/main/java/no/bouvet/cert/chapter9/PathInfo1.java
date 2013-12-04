package no.bouvet.cert.chapter9;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created with IntelliJ IDEA.
 * User: gaute.lyngstad
 * Date: 03.12.13
 * Time: 08:59
 * To change this template use File | Settings | File Templates.
 */
public class PathInfo1 {

    public static final String TESTFILE_TXT = "D:\\test\\testfile.txt";

    public static void main(String[] args) {
        // create a Path object by calling static method get() in Paths class
        //This does not require a file to exist, and it does not create one
        Path path = Paths.get(TESTFILE_TXT);

        // retrieve basic information about path
        System.out.println("Printing file information: ");
        System.out.println("\t file name: "+ path.getFileName());
        System.out.println("\t root of the path: " + path.getRoot());
        System.out.println("\t parent of the target: " + path.getParent());
        System.out.println("\t name count of path: " + path.getNameCount());
        System.out.println("\t get name by index 0: " + path.getName(0));
        System.out.println("\t normalize() : " + path.normalize());
        System.out.println("\t isAbsolute() : " + path.isAbsolute());
        System.out.println("\t start with D:\\: " + path.startsWith("D:\\"));
        System.out.println("\t start with C:\\: " + path.startsWith("C:\\"));

        // print path elements
        System.out.println("Printing elements of the path: ");
        for(Path element : path){
            System.out.println("\t path element: "  + element);
        }
    }
}
