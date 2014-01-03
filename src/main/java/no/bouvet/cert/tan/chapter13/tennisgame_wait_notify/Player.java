package no.bouvet.cert.tan.chapter13.tennisgame_wait_notify;

/**
 * Created with IntelliJ IDEA.
 * User: thomasa
 * Date: 03.01.14
 * Time: 13:41
 * To change this template use File | Settings | File Templates.
 */
public class Player extends Thread {
    private String currentPlayer;
    private String otherPlayer;

    public Player(String thisPlayer) {
        this.currentPlayer = thisPlayer;
        this.otherPlayer = thisPlayer.equals(Name.JOHN) ? Name.PAUL : Name.JOHN;
        System.out.println("thisPlayer = [" + currentPlayer + "]" + "\totherPlayer = [" + otherPlayer + "]");
    }

    public String getPlayerName(){
        return currentPlayer;
    }

    @Override
    public void run() {
       for (int i = 0; i < 5; i++){
            synchronized (Ball.class) {
                while(!Ball.getTurn().equals(currentPlayer)) {
                    try {
                        //sleep(500);
                        Ball.class.wait(1000);
                        System.out.println(currentPlayer + " wait's");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                Ball.hit(otherPlayer);
                Ball.setTurn(otherPlayer);
                Ball.class.notifyAll();

            }
        }

    }
}
