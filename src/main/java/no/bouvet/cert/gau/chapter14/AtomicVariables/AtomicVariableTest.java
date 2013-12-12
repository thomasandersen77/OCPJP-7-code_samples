package no.bouvet.cert.gau.chapter14.AtomicVariables;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by gaute.lyngstad on 10.12.13.
 */
public class AtomicVariableTest {
    // Create two integer objects - one normal and another atomic - with same initial value
    private static Integer integer = new Integer(0);
    private static AtomicInteger atomicInteger = new AtomicInteger(0);

    static class IntegerIncrementer extends Thread {
        @Override
        public void run() {
            System.out.println("Incremented value of integer is: " + ++integer);
        }
    }
    static class AtomicIntegerIncrementer extends Thread{
        @Override
        public void run() {
            System.out.println("Incremented value of atomic integer is: "+
            atomicInteger.incrementAndGet());
        }
    }

    public static void main(String[] args) {
        // creating 25 threads of each to show that the Integer value
        // will get a data race, while AtomicInteger will work correctly
        for(int i = 0; i < 25; i++){
            new IntegerIncrementer().start();
            new AtomicIntegerIncrementer().start();
        }
    }
}
