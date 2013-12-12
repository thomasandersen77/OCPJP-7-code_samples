package no.bouvet.cert.gau.chapter13.CreatingThreads;

/**
 * Created by gaute.lyngstad on 09.12.13.
 */
public class MyThread2 implements Runnable{
    @Override
    public void run() {
        // Because the this class in implementing the Runnable
        // interface instead of extends Thread, a call to
        // Thread.currentThread is needed to get an instance
        // of the thread.
        System.out.println("In run method; Thread name is: "+
            Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        Thread myThread = new Thread(new MyThread2());
        myThread.start();
        System.out.println("In main method; thread is: "+
            Thread.currentThread().getName());
    }

}
