package no.bouvet.cert.tan.chapter9;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributeView;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Date;

/**
 * Created by thomasa on 09.12.13.
 */
public class PathExamples {
    public static void main(String[] args) throws IOException {
        //Path path = Paths.get("C:\\temp\\test2.txt");
        Path path = Paths.get(".\\test2.txt");
        System.out.printf("Path toURI      :\t %s%n", path.toUri());
        System.out.printf("Path absolute   :\t %s%n", path.toAbsolutePath());

        System.out.printf("Path exists     :\t %s%n", Files.exists(path, LinkOption.NOFOLLOW_LINKS));
        if(Files.exists(path))
            Files.delete(path);

        Files.createFile(path);

        Files.setAttribute(path, "dos:hidden", true, LinkOption.NOFOLLOW_LINKS);  // will not be visible in dos
        BasicFileAttributes fileAttributes = Files.readAttributes(path, BasicFileAttributes.class, LinkOption.NOFOLLOW_LINKS);
        System.out.printf("CreationTime: %s%n",fileAttributes.creationTime().toString());

        System.out.printf("Path relativize  :\t%s%n", path.relativize(Paths.get("certification\\OCPJP_Java_7_Certification")));
        System.out.printf("Path normalize   :\t%s%n", path.normalize());
        System.out.printf("Path realPath    :\t  %s%n", path.toRealPath(LinkOption.NOFOLLOW_LINKS));

        System.out.printf("isFile: %s, isExecutable: %s, isReadable: %s, isWritable: %s%n", !Files.isDirectory(path), Files.isExecutable(path), Files.isReadable(path), Files.isWritable(path));

        Files.delete(path);
    }
}
