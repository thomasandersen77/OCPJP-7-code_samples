package no.bouvet.cert.tan.chapter9;

import java.io.IOException;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Iterator;

/**
 * Created by thomasa on 10.12.13.
 */
public class Normalizer {
    public static void main(String[] args) throws IOException {
        Path path = Paths.get("C:\\java\\projects\\..\\certification\\OCA Java 7 Certification\\src\\main\\java\\no\\.\\bouvet\\cert\\tan\\chapter9");
        path = path.normalize(); // remove 'projects' from the path
        System.out.println(path);
        System.out.println(path.toAbsolutePath());
        // System.out.println(path.toRealPath(LinkOption.NOFOLLOW_LINKS));
        Iterator<Path> pathIterator = path.iterator();
        int index = 0;
        StringBuilder sb = new StringBuilder();
        while (pathIterator.hasNext()) {
            System.out.printf("%s%d [%s]%n",  sb.toString(), index++,pathIterator.next().getFileName());
            sb.append("  ");
        }

        //C:\java\certification\OCA Java 7 Certification\src\main\java\no\bouvet\cert\tan\chapter9
        //C:\java\projects\certification\OCA Java 7 Certification\src\main\java\no\bouvet\cert\tan\chapter9

    }
}
