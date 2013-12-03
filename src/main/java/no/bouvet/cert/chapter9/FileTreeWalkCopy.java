package no.bouvet.cert.chapter9;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;


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

    public static final String USAGE_FILE_TREE_WALK_COPY_SOURCE_PATH_DESTINATION_PATH = "usage: FileTreeWalkCopy <source-path> <destination-path>";
    public static final String FILES_COPIED_SUCCESSFULLY = "Files copied successfully!";
    public static final String SRC = "Test";
    public static final String DEST = "Test2";


    public static void main(String[] args) {
        method(SRC, DEST);
    }

    public static void method(String... args) {
        if(args.length!=2){
               System.out.println(USAGE_FILE_TREE_WALK_COPY_SOURCE_PATH_DESTINATION_PATH);
               System.exit(-1);
        }
        Path pathSource = Paths.get(args[0]);
        Path pathDestination = Paths.get(args[1]);
        try{
            Files.walkFileTree(pathSource,new MyFileCopyVisitor(pathSource,pathDestination));
            System.out.println(FILES_COPIED_SUCCESSFULLY);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
