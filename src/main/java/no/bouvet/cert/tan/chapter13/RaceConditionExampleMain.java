package no.bouvet.cert.tan.chapter13;

/**
 * Created with IntelliJ IDEA.
 * User: thomasa
 * Date: 03.01.14
 * Time: 11:23
 * To change this template use File | Settings | File Templates.
 */
public class RaceConditionExampleMain {

    public static void main(String[] args) {
        UserCounter uc = new UserCounter();
        Thread t1 = new Thread(uc);
        Thread t2 = new Thread(uc);
        Thread t3 = new Thread(uc);
        t1.start();
        t2.start();
        t3.start();
    }
}

class Counter {
    public static int count;
}

class UserCounter implements Runnable{

    public void increment() {
        // this synchronized block avoids race condition / data race
        synchronized (this) {
            Counter.count++;
            System.out.print(Counter.count  + " ");
        }
    }

    @Override
    public void run() {
        increment();
        increment();
        increment();
    }
}