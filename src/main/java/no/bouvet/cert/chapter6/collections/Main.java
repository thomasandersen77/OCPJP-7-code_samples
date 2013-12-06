package no.bouvet.cert.chapter6.collections;

import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by thomasa on 06.12.13.
 */
public class Main {
    /**
     * <pre>
     *     <ul>
     *     <li>A Deque does only provide traversal in the form of searching for elements from either front or back of queue<br /></li>
     *     <li>Not supposed to be either sortable or reversible. The {@link Collections#sort(java.util.List)} only takes a List as a parameter.</li>
     *     </ul>
     * </pre>
     *
     *
     * <br>Note</br>
     * - {@link java.util.Deque#forEach} is used with Java 8 Lambda for easy printing of list
     *
     */
    public void deQueueExample() {
        // Example of double ended queue
        Deque<String> deque = new LinkedList<>();
        deque.addLast("thomas"); // will be last (and first, because of only one element in {@java.util.Deque})
        deque.push("erik");
        deque.push(null); // allowed to add NULL values
        deque.addFirst("anne grete"); // will be first entry
        deque.push("gaute");
        deque.addLast("mark");   // will be last entry
        deque.push("henry"); // top of queue
        deque.forEach(e -> System.out.println((e != null ? "[" + e + "]" : "[** empty **]"))); // lambda -> NOT part of exams, but easy for traversal
    }

    public static void main(String[] args) {
        Main main = new Main();
        main.deQueueExample();


    }
}
