package no.bouvet.cert.tan.chapter14;

import java.util.concurrent.Semaphore;

/**
 * Created with IntelliJ IDEA.
 * User: thomasa
 * Date: 06.01.14
 * Time: 10:52
 * To change this template use File | Settings | File Templates.
 */
public class SemaphoreMain {


    public static void main(String[] args) {

        Semaphore machines = new Semaphore(5);

        new Person("Thomas", machines);
        new Person("Mark", machines);
        new Person("Erik", machines);
        new Person("Gaute", machines);
        new Person("Lars", machines);

    }

}

class Person extends Thread {
    private Semaphore machines;

    public Person(String name, Semaphore machines) {
        this.machines = machines;
        this.setName(name);
        this.start();
    }

    @Override
    public void run() {

        try {
            System.out.println(getName() + " is WAITING for the ATM");
            machines.acquire();
            System.out.println(getName() + " is withdrawing money");
            sleep(1000); // simulate time it takes to withdraw
            System.out.println(getName() + " is FINISHED...");
            machines.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}