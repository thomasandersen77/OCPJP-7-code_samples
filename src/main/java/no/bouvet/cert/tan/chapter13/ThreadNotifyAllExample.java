package no.bouvet.cert.tan.chapter13;

/**
 * Created with IntelliJ IDEA.
 * User: thomasa
 * Date: 27.01.14
 * Time: 13:05
 * To change this template use File | Settings | File Templates.
 */
public class ThreadNotifyAllExample {

    final public Mumbo mumbo = new Mumbo();
    final public Jumbo jumbo = new Jumbo();

    class Mumbo {
        public synchronized void doIt() {
            try{
                // LINE 1:
                wait();
                System.out.println("done");
            } catch(Exception e) {
            }
        }
    }
    class Jumbo extends Thread {
        public void run() {
            mumbo.doIt();
        }
    }

    public ThreadNotifyAllExample() throws Exception {

        jumbo.start();
        Thread.sleep(3000);
        synchronized (mumbo) {
            mumbo.notifyAll();
        }

    }

    public static void main(String[] args) throws Exception {
        new ThreadNotifyAllExample();
    }
}
