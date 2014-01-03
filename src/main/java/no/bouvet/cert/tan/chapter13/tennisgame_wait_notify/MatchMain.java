package no.bouvet.cert.tan.chapter13.tennisgame_wait_notify;

/**
 * Created with IntelliJ IDEA.
 * User: thomasa
 * Date: 03.01.14
 * Time: 13:44
 * To change this template use File | Settings | File Templates.
 */
public class MatchMain {
    public static void main(String[] args) throws InterruptedException {
        Player player1 = new Player(Name.JOHN);
        Player player2 = new Player(Name.PAUL);
        Ball.setWhoServes(player1.getPlayerName());
        player2.start();
        player1.start();

        synchronized (MatchMain.class) {
            MatchMain.class.wait(10000);
            System.out.println("********* GAME OVER ************");
            System.exit(0);
        }


    }
}
