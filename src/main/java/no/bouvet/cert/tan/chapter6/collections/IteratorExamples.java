package no.bouvet.cert.tan.chapter6.collections;

import java.util.*;

/**
 * Created by thomasa on 06.12.13.
 */
public class IteratorExamples extends AbstractExample {

    /**
     *
     *     <ul>
     *      <li>The {@link java.util.Iterator} can only travers or search from the start og the Collection</li>
     *      <li>{@link java.util.Deque} has {@link java.util.Collection} as it's interface, and can therefor be iterated</li>
     *      <li>Can also remove elements, but remember to call the .next() method first!</li>
     *     </ul>
     *
     *
     */
    public void iteratorExample() {
        Deque<String> stringDeque = getDequeWithNamesAsString();

        Iterator<String> iterator = stringDeque.iterator();
        String str = null;
        while (iterator.hasNext()) { // if hasNext() == false > terminate loop
            str = iterator.next(); // returns next element in iteration
            System.out.println(str);
        }

        System.out.printf(getMessage(), "END iteratorExample");
    }

    public void testCollectionSort(){
        Deque<String> stringDeque = getDequeWithNamesAsString();
        Iterator<String> iterator = stringDeque.iterator();
        List<String> namesList = new ArrayList<>();
        while(iterator.hasNext()) {
            String name = iterator.next();
            if(name!=null)
                namesList.add(name);
        }

        Collections.sort(namesList);

        //easy print - not part of exam
//        namesList.stream().forEach(System.out::println);

    }

    private Deque<String> getDequeWithNamesAsString() {
        Deque<String> deque = new LinkedList<>();
        deque.addLast("thomas"); // will be last (and first, because of only one element in {@java.util.Deque})
        deque.push("erik");
        deque.push(null); // allowed to add NULL values
        deque.addFirst("anne grete"); // will be first entry (until a push comes or another addFirst call)
        deque.push("gaute");
        deque.addLast("mark");   // will be last entry
        deque.push("henry"); // top of queue
        return deque;
    }

    public static void main(String[] args) {
        IteratorExamples iteratorExamples = new IteratorExamples();
        iteratorExamples.iteratorExample();

        iteratorExamples.testCollectionSort();
    }

}
