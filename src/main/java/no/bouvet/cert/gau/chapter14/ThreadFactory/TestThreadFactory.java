package no.bouvet.cert.gau.chapter14.ThreadFactory;

import java.util.concurrent.ThreadFactory;

/**
 * Created by gaute.lyngstad on 10.12.13.
 */
class MaxPriorityThreadFactory  implements ThreadFactory{
    private static long count =0;
    @Override
    public Thread newThread(Runnable r) {
        Thread temp = new Thread(r);
        temp.setName("PriorityThread"+count++);
        temp.setPriority(Thread.MAX_PRIORITY);
        return temp;
    }
}

class ARunnable implements Runnable{

    @Override
    public void run() {
        System.out.println("Running the created thread");
    }
}

public class TestThreadFactory  {
    public static void main(String[] args) {
        ThreadFactory threadFactory = new MaxPriorityThreadFactory();
        Thread t1 = threadFactory.newThread(new ARunnable());
        System.out.println("The name of the thread is " + t1.getName());
        System.out.println("The priority of the thread is " +  t1.getPriority());
        t1.start();
    }
}
