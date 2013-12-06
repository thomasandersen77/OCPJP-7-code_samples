package no.bouvet.cert.gau.chapter9.util;

import no.bouvet.cert.gau.chapter9.C9FilePath;

import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by thomasa on 03.12.13.
 */
public class PathResolver {
    private String relativePath;
    private String resourcesPath;
    private String absolutePath;

    public PathResolver(String path) {
        Path thePath = Paths.get(path);
        boolean exists = Files.exists(thePath);
        if(exists) {
            System.out.println("Exists: " + thePath.getFileName());
        } else {
            throw new InvalidPathException(relativePath, "Does not exist");
        }

        this.relativePath = path;
        this.absolutePath = thePath.toAbsolutePath().toString();
        this.resourcesPath = Paths.get(C9FilePath.C9_RESOURCE_PATH).toString();
    }

    public String getRelativePath() {
        return relativePath;
    }

    public String getResourcesPath() {
        return resourcesPath;
    }

    public String getAbsolutePath() {
        return absolutePath;
    }

    public static void main(String[] args) {
        PathResolver pathResolver = new PathResolver(C9FilePath.C9_RESOURCE_PATH);
        System.out.printf("RelativePath [%s]\n", pathResolver.getRelativePath());
        System.out.printf("AbsolutePath [%s]\n", pathResolver.getAbsolutePath());
        System.out.printf("ResourcePath [%s]\n", pathResolver.getResourcesPath());

    }
}
