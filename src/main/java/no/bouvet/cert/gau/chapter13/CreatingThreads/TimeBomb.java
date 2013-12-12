package no.bouvet.cert.gau.chapter13.CreatingThreads;

/**
 * Created by gaute.lyngstad on 09.12.13.
 */
public class TimeBomb extends Thread{
    String[] timeStr = { "Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};

    @Override
    public void run() {
        for(int i = 9; i>=0;i--){
            try{
                System.out.println(timeStr[i]);
                Thread.sleep(1000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        TimeBomb timer = new TimeBomb();
        System.out.println("Starting 10 second count down...");
        timer.start();
        try{
            timer.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Boom!!!");
    }
}
