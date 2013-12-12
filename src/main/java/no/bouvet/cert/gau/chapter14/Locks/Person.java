package no.bouvet.cert.gau.chapter14.Locks;

import java.util.concurrent.locks.Lock;

/**
 * Created by gaute.lyngstad on 10.12.13.
 */

// Each Person is an independent thread; their access to the common resource
// (the ATM machine in this case) needs to be synchronized using a lock
public class Person extends Thread {
    private Lock machine;

    public Person(Lock machine, String name) {
        this.machine = machine;
        this.setName(name);
        this.start();
    }

    @Override
    public void run() {
        try{
            System.out.println(getName() + " waiting to access an ATM machine");
            machine.lock();
            System.out.println(getName() + " is accessing an ATM machine");
            Thread.sleep(1000); // simulate the time required for withdrawing amount
        } catch (InterruptedException e) {
            System.err.println(e);
        }finally {
            System.out.println(getName() + " is done using the ATM machine");
            machine.unlock();
        }

          //tryLock() example
//        System.out.println(getName() + " trying to access an ATM machine");
//        if (machine.tryLock()) {
//            try{
//                System.out.println(getName() + " is accessing an ATM machine");
//                Thread.sleep(1000); // simulate the time required for withdrawing amount
//            } catch (InterruptedException e) {
//                System.err.println(e);
//            }finally {
//                System.out.println(getName() + " is done using the ATM machine");
//                machine.unlock();
//            }
//        } else {
//            System.out.println(getName() + " failed to access ATM machine, " +
//                    "and trying another one around the corner");
//        }

    }
}
