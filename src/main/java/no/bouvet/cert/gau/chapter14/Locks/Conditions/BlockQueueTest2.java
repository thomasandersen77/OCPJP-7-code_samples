package no.bouvet.cert.gau.chapter14.Locks.Conditions;

import no.bouvet.cert.gau.chapter14.Locks.Conditions.BlockerQueue;

/**
 * Created by gaute.lyngstad on 10.12.13.
 */
public class BlockQueueTest2{
    public static void main(String[] args) {
        final BlockerQueue blockerQueue = new BlockerQueue(3);
        blockerQueue.insert("one");
        blockerQueue.insert("two");
        blockerQueue.insert("three");
        new Thread(){
            @Override
            public void run() {
                System.out.println("Thread2: attempting to insert an item to the queue");
                blockerQueue.insert("four");
            }
        }.start();
        new Thread(){
            @Override
            public void run() {
                System.out.println("Thread1: attempting to remove an item from the queue");
                Object o = blockerQueue.remove();
            }
        }.start();
    }
}