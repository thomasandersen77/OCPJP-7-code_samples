package no.bouvet.cert.gau.chapter13.AsynchronousExecution;

/**
 * Created by gaute.lyngstad on 09.12.13.
 */
public class BasicThreadStates extends Thread {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(new BasicThreadStates());
        System.out.println("Just after creating thread; \n"+
            "     The Thread state is: "+t.getState());
        t.start();
        System.out.println("Just after calling t.start(); \n"+
            "     The thread state is: " + t.getState());

        t.join();
        System.out.println("Just after main calling t.join(); \n"+
            "     The thread state is: " + t.getState());
    }
}
