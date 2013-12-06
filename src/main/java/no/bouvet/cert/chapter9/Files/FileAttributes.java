package no.bouvet.cert.chapter9.Files;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;

import static no.bouvet.cert.chapter9.C9FilePath.C9_FILES_PATH;
import static no.bouvet.cert.chapter9.C9FilePath.C9_PATH;


/**
 * Created with IntelliJ IDEA.
 * User: gaute.lyngstad
 * Date: 03.12.13
 * Time: 10:34
 * To change this template use File | Settings | File Templates.
 */
public class FileAttributes {

    public static final String CREATION_TIME = "creationTime";
    public static final String LAST_MODIFIED_TIME = "lastModifiedTime";
    public static final String SIZE = "size";
    public static final String DOS_HIDDEN = "dos:hidden";
    public static final String IS_DIRECTORY = "isDirectory";

    public static void main(String[] args) {
        method(C9_FILES_PATH +"FileAttributes.java");
    }

    public static void method(String... args) {
        Path path = Paths.get(args[0]);
        try{
            Object object = Files.getAttribute(path, CREATION_TIME,
                    LinkOption.NOFOLLOW_LINKS);
            System.out.println("Create time: "+ object);

            object = Files.getAttribute(path, LAST_MODIFIED_TIME,
                    LinkOption.NOFOLLOW_LINKS);
            System.out.println("Last modified time: " + object);

            object = Files.getAttribute(path, SIZE, LinkOption.NOFOLLOW_LINKS);
            System.out.println("Size: " + object);

            object = Files.getAttribute(path, DOS_HIDDEN, LinkOption.NOFOLLOW_LINKS);
            System.out.println("isHidden: " + object);

            object = Files.getAttribute(path, IS_DIRECTORY, LinkOption.NOFOLLOW_LINKS);
            System.out.println("isDirectory: " + object);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
