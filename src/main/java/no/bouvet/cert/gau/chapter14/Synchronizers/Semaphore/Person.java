package no.bouvet.cert.gau.chapter14.Synchronizers.Semaphore;

import java.util.concurrent.Semaphore;

/**
 * Created by gaute.lyngstad on 09.12.13.
 */
public class Person extends Thread{
    private Semaphore machines;

    public Person(Semaphore machines, String name) {
        this.machines = machines;
        this.setName(name);
        this.start();
    }

    @Override
    public void run() {
        try {
            System.out.println(getName() + " waiting to access an ATM machine");
            machines.acquire();
            System.out.println(getName() + " is accessing an ATM machine");
            Thread.sleep(1000); // simulate the time required for withdrawing amount
            System.out.println(getName() + " is done using the ATM machine");
            machines.release();
        } catch (InterruptedException e) {
            System.err.println(e);
        }
    }
}
