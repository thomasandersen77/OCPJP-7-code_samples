package no.bouvet.cert.chapter9.WatchService;

import java.io.IOException;
import java.nio.file.*;

import static no.bouvet.cert.chapter9.C9FilePath.C9_PATH;
/**
 * Created with IntelliJ IDEA.
 * User: gaute.lyngstad
 * Date: 03.12.13
 * Time: 15:09
 * To change this template use File | Settings | File Templates.
 *
 */
public class KeepAnEye {

    public static final String OVERFLOW = "OVERFLOW";
    public static final String ENTRY_MODIFY = "ENTRY_MODIFY";
    public static final String ENTRY_CREATE = "ENTRY_CREATE";
    public static final String ENTRY_DELETE = "ENTRY_DELETE";

    public static void main(String[] args) {


//        Path path = Paths.get(".\\");
        Path path = Paths.get(C9_PATH);
        WatchService watchService = null;
        try{
            // get a watchService based on the path
            watchService = path.getFileSystem().newWatchService();
            // register what kind of events that should be watched for.
            path.register(watchService, StandardWatchEventKinds.ENTRY_MODIFY,
                    StandardWatchEventKinds.ENTRY_CREATE,
                    StandardWatchEventKinds.ENTRY_DELETE,
                    StandardWatchEventKinds.OVERFLOW);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //infinite loop
        for(;;){
            WatchKey key = null;
            try{
                key = watchService.take(); // waiting/blocking until an event happens

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // iterate for each event
            for(WatchEvent<?> event:key.pollEvents()){
                switch (event.kind().name()){
                    case OVERFLOW:
                        System.out.println("We lost some events");
                        break;
                    case ENTRY_MODIFY:
                        System.out.println("File "+ event.context() + " is changed!");
                        break;
                    //extra
                    case ENTRY_CREATE:
                        System.out.println("File " +event.context()+ " was created!");
                        break;
                    case ENTRY_DELETE:
                        System.out.println("File " +event.context()+ " was deleted!");
                        break;
                }
            }
            key.reset();
        }
    }
}
