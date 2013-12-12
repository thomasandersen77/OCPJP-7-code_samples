package no.bouvet.cert.gau.chapter14.Locks;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by gaute.lyngstad on 10.12.13.
 */

// This class simulates a situation where only one ATM machine is available and
// five people are waiting to access the machine. Since only one person can
// access an ATM machine at a given time, others wait for their turn
public class ATMRoom {
    public static void main(String[] args) {
        // A person can use a machine again, and hench using a "reentrant lock"
        Lock machine = new ReentrantLock();

        // list of people waiting to access the machine
        new Person(machine, "Mickey");
        new Person(machine, "Donald");
        new Person(machine, "Tom");
        new Person(machine, "Jerry");
        new Person(machine, "Casper");
    }
}
