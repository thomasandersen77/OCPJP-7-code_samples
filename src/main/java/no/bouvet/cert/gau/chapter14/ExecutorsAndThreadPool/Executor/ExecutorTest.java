package no.bouvet.cert.gau.chapter14.ExecutorsAndThreadPool.Executor;

import java.util.concurrent.Executor;

/**
 * Created by gaute.lyngstad on 10.12.13.
 */

// This Task class implements Runnable, so its a Thread object
class Task implements Runnable{
    @Override
    public void run() {
        System.out.println("Calling Task.run()");
    }
}

// This class implements Executor interface and should override execute(Runnable) method.
// We provide an overloaded execute method with an additional argument 'times' to create and
// run the threads for given number of times
class RepeatedExecutor implements Executor{
    @Override
    public void execute(Runnable runnable) {
        new Thread(runnable).start();
    }
    public void execute(Runnable runnable, int times){
        System.out.printf("Calling Task.run() thro' Executor.execute() for %d times %n", times);
        for(int i = 0; i<times;i++){
            execute(runnable);
        }
    }
}

// This class spawns a Task thread and explicitly calls start() method.
// It's also shows how to execute a Thread using Executor
public class ExecutorTest {
    public static void main(String[] args) {
        Runnable runnable = new Task();
        System.out.println("Calling Task.run() by directly creating Thread object");
        Thread thread = new Thread(runnable);
        thread.start();
        RepeatedExecutor executor = new RepeatedExecutor();
        executor.execute(runnable,3);
    }
}
