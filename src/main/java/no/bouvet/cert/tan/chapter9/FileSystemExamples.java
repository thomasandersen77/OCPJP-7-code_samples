package no.bouvet.cert.tan.chapter9;

import java.io.IOException;
import java.nio.file.*;

/**
 * Created by thomasa on 10.12.13.
 */
public class FileSystemExamples {
    public static void main(String[] args) throws IOException {
        Path path = Paths.get(".\\src\\main\\java\\no\\bouvet\\cert\\tan\\chapter9");
        Path thePath = path.normalize();
        System.out.println(thePath.toRealPath());
        FileSystems.getDefault();
        WatchService watchService = path.getFileSystem().newWatchService();
        thePath.register(watchService, StandardWatchEventKinds.ENTRY_MODIFY);

        for(;;) {
            WatchKey key = null;
            try {
                key = watchService.take();
            } catch (InterruptedException e) {
                throw new NullPointerException(e.getMessage());
            }

            for(WatchEvent<?> event : key.pollEvents()) {
                System.out.println("Event: "+ event.kind().name() + ", " + event.context());
            }
            key.reset();
        }
    }
}
