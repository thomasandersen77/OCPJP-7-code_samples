package no.bouvet.cert.gau.chapter13.AsynchronousExecution;

/**
 * Created by gaute.lyngstad on 09.12.13.
 */
public class AsyncThread extends Thread {
    @Override
    public void run() {
        System.out.println("Starting the thread " + getName());
        for(int i = 0; i<3;i++){
            System.out.println("In thread "+ getName()+"; iteration "+1);
            try{
                //sleep for sometime before the next iteration
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        AsyncThread asyncThread1 = new AsyncThread();
        AsyncThread asyncThread2 = new AsyncThread();
        //start both threads around the same time
        asyncThread1.start();
        asyncThread2.start();
    }
}
