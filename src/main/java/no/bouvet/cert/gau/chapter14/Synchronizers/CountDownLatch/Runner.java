package no.bouvet.cert.gau.chapter14.Synchronizers.CountDownLatch;

import java.util.concurrent.CountDownLatch;

/**
 * Created by gaute.lyngstad on 09.12.13.
 */
public class Runner extends Thread {
    private CountDownLatch timer;

    public Runner(CountDownLatch timer, String name) {
        this.timer = timer;
        this.setName(name);
        System.out.println(this.getName() + " ready and waiting for the count down to start");
        start();
    }

    @Override
    public void run() {
        try {
            timer.await();
        } catch (InterruptedException e) {
            System.err.println("interrupted -- can't start running the race");
        }
        System.out.println(this.getName() + " started running");
    }
}
