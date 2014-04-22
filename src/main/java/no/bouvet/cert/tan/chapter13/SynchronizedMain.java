package no.bouvet.cert.tan.chapter13;

/**
 * Created with IntelliJ IDEA.
 * User: thomasa
 * Date: 24.01.14
 * Time: 15:07
 * To change this template use File | Settings | File Templates.
 */

class Lock{

}

public class SynchronizedMain extends Thread {
    final Lock lock = new Lock();

    static  {
        synchronized (SynchronizedMain.class) { // OK

        }
    }
    public SynchronizedMain() throws InterruptedException {
        synchronized (lock) { // | (this) // (SynchronizedMain.class)
            System.out.println("test");
            lock.wait(1000);
        }
    }

    public static synchronized void test(){

    }

    public static void main(String[] args) throws InterruptedException {

        SynchronizedMain t1 = new SynchronizedMain();
        t1.start();
        SynchronizedMain t2 = new SynchronizedMain();
        t2.start();
        Thread.sleep(1000);
        t1.join();
        t2.notifyAll();

        /* PRINTS
        test
        Exception in thread "main" java.lang.IllegalMonitorStateException
            at java.lang.Object.wait(Native Method)
            at no.bouvet.cert.tan.chapter13.SynchronizedMain.<init>(SynchronizedMain.java:19)
            at no.bouvet.cert.tan.chapter13.SynchronizedMain.main(SynchronizedMain.java:28)
            at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
            at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)
            at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
            at java.lang.reflect.Method.invoke(Method.java:483)
            at com.intellij.rt.execution.application.AppMain.main(AppMain.java:120)
         */
    }
}
