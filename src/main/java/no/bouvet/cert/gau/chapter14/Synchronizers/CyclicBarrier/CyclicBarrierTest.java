package no.bouvet.cert.gau.chapter14.Synchronizers.CyclicBarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * Created by gaute.lyngstad on 09.12.13.
 */

// The run() method in this thread should be called only when four players are ready to start the game
class MixedDoubleTennisGame extends Thread{
    @Override
    public void run() {
        System.out.println("All four players ready, game starts \n Love all...");
    }
}

// This thread simulates arrival of a player.
// Once a player arrives, he/she should wait for other players to arrive
class Player extends Thread{
    CyclicBarrier waitPoint;

    Player(CyclicBarrier waitPoint, String name) {
        this.waitPoint = waitPoint;
        this.setName(name);
        this.start();
    }

    @Override
    public void run() {
        System.out.println("Player " + getName() + " is ready ");
        try{
            waitPoint.await(); // await for all four players to arrive
        } catch (InterruptedException | BrokenBarrierException e) {  // MultiCatch (chapter 11)
            System.out.println("An exception occurred while waiting... " + e);
        }
    }
}

public class CyclicBarrierTest {
    public static void main(String[] args) {
        // a mixed-double tennis game requires four players; so wait for four players
        // (i.e., four threads) to join to start the game
        System.out.println("Reserving tennis count \n As soon as four players arrive," +
                " game will start");
        CyclicBarrier barrier = new CyclicBarrier(4, new MixedDoubleTennisGame());
        new Player(barrier,"G I Joe");
        new Player(barrier, "Dor");
        new Player(barrier, "Tintin");
        new Player(barrier, "Barbie");
    }

}
