package no.bouvet.cert.tan.chapter9;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

/**
 * Created by thomasa on 10.12.13.
 */
public class WalkFileTreeRecursively {
    public static void main(String[] args) throws IOException {

        Path path = Paths.get("C:/");

        Files.walkFileTree(path, new MyVisitor());

    }
}

class MyVisitor extends SimpleFileVisitor<Path> {

    @Override
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
        if(dir != null && dir.getFileName() != null)
            System.out.println("************"  + dir.getFileName().toString().toUpperCase()+ "**********************");
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        System.out.println("File: " + file.getFileName());
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
        return FileVisitResult.CONTINUE;
    }
}

