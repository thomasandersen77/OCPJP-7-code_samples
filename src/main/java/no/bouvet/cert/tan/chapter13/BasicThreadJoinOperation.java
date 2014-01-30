package no.bouvet.cert.tan.chapter13;

/**
 * Created by thomasa on 20.12.13.
 */
public class BasicThreadJoinOperation {

    public static void main(String[] args) {

        Thread counter = new Thread(new CountToTenThread());
        System.out.println("Start counting to 10... \nCurrentThread: " + Thread.currentThread().getName());
        counter.start();

        try {
            counter.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Finished counting...");

    }

}

class CountToTenThread implements Runnable {

    @Override
    public void run() {
        for(int i = 0; i < 10; i++) {
            System.out.printf("%s, %d%n", Thread.currentThread().getName(), (i+1));
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}