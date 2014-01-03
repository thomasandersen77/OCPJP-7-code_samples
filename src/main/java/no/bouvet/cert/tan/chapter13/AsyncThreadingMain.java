package no.bouvet.cert.tan.chapter13;

/**
 * Created with IntelliJ IDEA.
 * User: thomasa
 * Date: 03.01.14
 * Time: 10:55
 * To change this template use File | Settings | File Templates.
 */
public class AsyncThreadingMain {

    public static void main(String[] args) throws InterruptedException {
        AsyncThread a = new AsyncThread();
        AsyncThread b = new AsyncThread();
        a.start();
        b.start();
    }

}

class AsyncThread extends Thread {

    @Override
    public void run() {
        System.out.println("Starting " + getName());
        for(int i = 1; i <= 5; i++) {
            System.out.printf("ThreadName: %s, i=%d%n", getName(), i);
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}