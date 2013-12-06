package no.bouvet.cert.chapter6.collections;

import java.util.Collections;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * Created by thomasa on 06.12.13.
 */
public class DequeExample extends AbstractExample {

    /**
     *
     *  <ul>
     *     <li>A Deque does only provide traversal in the form of fetching elements from either front or back of queue<br /></li>
     *     <li>Not supposed to be either sortable or reversible. The {@link Collections#sort(java.util.List)} only takes a List as a parameter.</li>
     *  </ul>
     *
     * <br>Note</br>
     * - {@link java.util.Deque#forEach} is used with Java 8 Lambda for easy printing of list
     *
     */
    public Deque<String> deQueueExample() {
        // Example of double ended queue, with diamond operator
        Deque<String> deque = new LinkedList<>();
        deque.addLast("thomas"); // will be last (and first, because of only one element in {@java.util.Deque})
        deque.push("erik");
        deque.push(null); // allowed to add NULL values
        deque.addFirst("anne grete"); // will be first entry
        deque.push("gaute");
        deque.addLast("mark");   // will be last entry
        deque.push("henry"); // top of queue
        deque.forEach(e -> System.out.println((e != null ? "[" + e + "]" : "[** empty **]"))); // lambda -> NOT part of exams, but easy for traversal
        System.out.printf(getMessage(), "END deQueueExample");
        return deque;
    }



    public static void main(String[] args) {
        DequeExample dequeExample = new DequeExample();
        dequeExample.deQueueExample();
    }
}
