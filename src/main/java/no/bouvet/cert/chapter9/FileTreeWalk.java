package no.bouvet.cert.chapter9;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

/**
 * Created with IntelliJ IDEA.
 * User: gaute.lyngstad
 * Date: 03.12.13
 * Time: 12:14
 * To change this template use File | Settings | File Templates.
 */

class MyFileVisitor extends SimpleFileVisitor<Path>{

    @Override
    public FileVisitResult visitFile(Path path, BasicFileAttributes fileAttributes) throws IOException {
        System.out.println("file name:"+path.getFileName());
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult preVisitDirectory(Path path, BasicFileAttributes fileAttributes) throws IOException {
        System.out.println("--------------Directory name:" + path + "--------------");
        return FileVisitResult.CONTINUE;
    }
}

public class FileTreeWalk {

    public static final String USAGE_FILE_WALK_TREE_SOURCE_PATH = "usage: FileWalkTree <source-path>";

    public static void main(String[] args) {
        method("src");
    }

    public static void method(String... args) {
        if(args.length!=1){
               System.out.println(USAGE_FILE_WALK_TREE_SOURCE_PATH);
               System.exit(-1);
        }
        Path pathSource = Paths.get(args[0]);
        try{
            Files.walkFileTree(pathSource,new MyFileVisitor());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
