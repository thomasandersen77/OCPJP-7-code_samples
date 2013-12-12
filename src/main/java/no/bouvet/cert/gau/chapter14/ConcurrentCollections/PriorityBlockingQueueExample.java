package no.bouvet.cert.gau.chapter14.ConcurrentCollections;

import java.util.PriorityQueue;
import java.util.concurrent.PriorityBlockingQueue;

/**
 * Created by gaute.lyngstad on 10.12.13.
 */

// Illustrates the use of PriorityBlockingQueue. In this case,
// if there is no element available in the priority queue
// the thread calling take() method will block (i.e., wait) until
// another thread inserts an element
public class PriorityBlockingQueueExample {
    public static void main(String[] args) {
        final PriorityBlockingQueue<Integer> priorityBlockingQueue = new PriorityBlockingQueue<>(); //diamond syntax
        // spawn a thread that removes an element from the priority queue
        new Thread(){ //anonymous inner class
            @Override
            public void run() {
                try{
                    // use take() instead of remove8)
                    // note that take() blocks, whereas remove() doesn't block
                    System.out.println("The removed element is: "+
                    +priorityBlockingQueue.take());
                } catch (InterruptedException e) {
                    // its safe to ignore this exception
                    e.printStackTrace();
                }
            }
        }.start();
        new Thread(){//anonymous inner class

            @Override
            public void run() {
                // add an element with value 10 to the priority queue
                priorityBlockingQueue.add(10);
                System.out.println("Successfully added an element to the queue");
            }
        }.start();
    }
}
