package no.bouvet.cert.gau.chapter14.ConcurrentCollections;

import java.util.PriorityQueue;

/**
 * Created by gaute.lyngstad on 10.12.13.
 */

// this program expect to get a NoSuchElementException, as remove() is called on an empty queue
public class PriorityQueueExample {
    public static void main(String[] args) {
        final PriorityQueue<Integer>  priorityQueue = new PriorityQueue<>(); //diamond syntax
        // spawn a thread that removes an element from the priority queue
        new Thread(){
            @Override
            public void run() {
                // Use remove() method in PriorityQueue to remove the element if available
                System.out.println("The removed element is: " + priorityQueue.remove());
            }
        }.start();
    }
}
