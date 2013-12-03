package no.bouvet.cert.chapter9;

import java.io.IOException;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Logger;

/**
 * Created with IntelliJ IDEA.
 * User: gaute.lyngstad
 * Date: 03.12.13
 * Time: 09:17
 * To change this template use File | Settings | File Templates.
 */
public class PathInfo2 {
    private final static Logger LOG = Logger.getLogger(PathInfo2.class.getName());
    public static final String TEST = ".\\Test";

    public static void main(String[] args) throws IOException {
        //get a path object with relative path
        //LOG.info("Hey");
        Path testFilePath = Paths.get(TEST);
        System.out.println("the file name is: " + testFilePath.getFileName());
        System.out.println("It's URI is: " + testFilePath.toUri());
        System.out.println("It's absolute path is: " + testFilePath.toAbsolutePath());
        System.out.println("It's normalized path is: " + testFilePath.normalize());

        //get another path object with normalized relative path
        Path testPathNormalized = Paths.get(testFilePath.normalize().toString());
        System.out.println("It's normalized absolute path is: " + testPathNormalized.toAbsolutePath());
        System.out.println("It's normalized real path is: " + testFilePath.toRealPath(LinkOption.NOFOLLOW_LINKS));
    }
}
