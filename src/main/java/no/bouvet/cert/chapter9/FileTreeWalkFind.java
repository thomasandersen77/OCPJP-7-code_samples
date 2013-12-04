package no.bouvet.cert.chapter9;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.*;

import static no.bouvet.cert.chapter9.C9FilePath.C9_PATH;


/**
 * Created with IntelliJ IDEA.
 * User: gaute.lyngstad
 * Date: 03.12.13
 * Time: 14:41
 * To change this template use File | Settings | File Templates.
 */

class MyFileFindVisitor extends SimpleFileVisitor<Path> {
    private static final String INVALID_PATTERN_ERROR = "Invalid pattern; did you forget to prefix \"glob:\"?(as in glob:*.java";
    private PathMatcher matcher;

    public MyFileFindVisitor(String pattern) {
        try{
            matcher = FileSystems.getDefault().getPathMatcher(pattern);
        }catch(IllegalArgumentException iae){
            System.err.println(INVALID_PATTERN_ERROR);
            System.exit(-1);
        }
    }
    @Override
    public FileVisitResult visitFile(Path path, BasicFileAttributes fileAttributes){
        find(path);
        return FileVisitResult.CONTINUE;
    }

    private void find(Path path) {
        Path name = path.getFileName();
        if(matcher.matches(name)){
            System.out.println("Matching file:" + path.getFileName());
        }
    }

    @Override
    public FileVisitResult preVisitDirectory(Path path, BasicFileAttributes fileAttributes) throws IOException {
        find(path);
        return FileVisitResult.CONTINUE;
    }
}

public class FileTreeWalkFind{

    private static final String PATTERN = "glob:File*.java";
    private static final String ERROR_MESSAGE = "usage: FileTreeWalkFind <start-path> <pattern to search>";
    private static final String COMPLETE_MESSAGE = "File search completed!";

    public static void main(String[] args) {
        // instead of console!
        method(C9_PATH, PATTERN);

        // if using console
//        method(args);
    }

    public static void method(String... args) {
        if(args.length != 2){
            System.out.println(ERROR_MESSAGE);
            System.exit(-1);
        }
        Path startPath= Paths.get(args[0]);
        String pattern = args[1];
        try{
            Files.walkFileTree(startPath, new MyFileFindVisitor(pattern));
            System.out.println(COMPLETE_MESSAGE);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
