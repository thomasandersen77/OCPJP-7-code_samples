package no.bouvet.cert.tan.chapter13.tennisgame_wait_notify;

import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 * User: thomasa
 * Date: 03.01.14
 * Time: 13:40
 * To change this template use File | Settings | File Templates.
 */
public class Ball {
    private static String turn;
    static Random random = new Random(31);
    public static void hitTo(String otherPlayer) {
        try {
            // simulate a delay
            int wait = random.nextInt((10) + 1000);
            Thread.sleep(wait);
            System.out.println( getTurn() + " hits the ball back to " + otherPlayer);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized static String getTurn() {
        return turn;
    }

    public static void setTurn(String player) {
        turn = player;
    }

    public synchronized static void setWhoServes(String player) {
        System.out.println("player who serves = [" + player + "]");
        turn = player;
    }
}
