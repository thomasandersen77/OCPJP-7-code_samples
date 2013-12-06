package no.bouvet.cert.chapter9.Files.FileTree.Copy;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

import static no.bouvet.cert.chapter9.C9FilePath.*;

class MyFileCopyVisitor extends SimpleFileVisitor<Path> {
    private Path source, destination;

    MyFileCopyVisitor(Path source, Path destination) {
        this.source = source;
        this.destination = destination;
    }

    @Override
    public FileVisitResult visitFile(Path path, BasicFileAttributes fileAttributes){
        Path newd = destination.resolve(source.relativize(path));

        try{
            Files.copy(path,newd, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult preVisitDirectory(Path path, BasicFileAttributes fileAttributes) throws IOException {
        Path newd = destination.resolve(source.relativize(path));
        try{
            Files.copy(path,newd, StandardCopyOption.REPLACE_EXISTING);
        }catch (IOException e) {
            e.printStackTrace();
        }
        return FileVisitResult.CONTINUE;
    }
}

public class FileTreeWalkCopy {

    public static final String ERROR_MESSAGE = "usage: FileTreeWalkCopy <source-path> <destination-path>";
    public static final String SUCCESSFULL_MESSAGE = "Files copied successfully!";
    public static final String SRC = C9_RESOURCE_PATH+"Test";
    public static final String DEST = C9_RESOURCE_PATH+"Test2";


    public static void main(String[] args) {
        method(SRC, DEST);
    }

    public static void method(String... args) {
        if(args.length!=2){
               System.out.println(ERROR_MESSAGE);
               System.exit(-1);
        }
        Path pathSource = Paths.get(args[0]);
        Path pathDestination = Paths.get(args[1]);
        try{
            Files.walkFileTree(pathSource,new MyFileCopyVisitor(pathSource,pathDestination));
            System.out.println(SUCCESSFULL_MESSAGE);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
