package no.bouvet.cert.tan.chapter13;

/**
 * Created with IntelliJ IDEA.
 * User: thomasa
 * Date: 03.01.14
 * Time: 15:38
 * To change this template use File | Settings | File Templates.
 */
public class Blocked_Timed_WaitingExampleMain {

    public static void main(String[] args) {
        Thread t1 = new MyThread();
        Thread t2 = new MyThread();
        t1.start();
        t2.start();

        System.out.println(t1.getName() + ", I am currently in state " + t1.getState());
        System.out.println(t2.getName() + ", I am currently in state " + t2.getState());
    }
}

class MyThread extends Thread {
    private static final Object lock = new Object();
    public MyThread() {
        System.out.println("Started MyThread with name = " + getName());
    }

    @Override
    public void run() {
        synchronized (this) {
            try {
                //wait(); //yields same response output
                wait(100);
            } catch (InterruptedException e) {
                //e.printStackTrace();
            }
        }

    }
}
