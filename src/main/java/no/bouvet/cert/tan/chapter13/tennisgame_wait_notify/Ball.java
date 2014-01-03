package no.bouvet.cert.tan.chapter13.tennisgame_wait_notify;

/**
 * Created with IntelliJ IDEA.
 * User: thomasa
 * Date: 03.01.14
 * Time: 13:40
 * To change this template use File | Settings | File Templates.
 */
public class Ball {
    private static String turn;
    public static void hit(String otherPlayer) {
        System.out.println( getTurn() + " hits the ball back to " + otherPlayer);
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
