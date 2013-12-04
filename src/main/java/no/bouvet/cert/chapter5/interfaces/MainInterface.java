package no.bouvet.cert.chapter5.interfaces;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by thomasa on 04.12.13.
 */
public class MainInterface {
    public static void main(String[] args) {

        // Create comparable instances and add the to a list to find
        // the max value based on Collections.max(..) method and assert
        Comparable<ObjectToCompare> objectOne = new ObjectToCompare(1);
        Comparable<ObjectToCompare> objectTwo = new ObjectToCompare(2);
        List<Comparable> compareList = new ArrayList<>();
        compareList.add(objectOne);
        compareList.add(objectTwo);
        Comparable comparable = Collections.max(compareList);
        assert comparable instanceof ObjectToCompare;
        assert ((ObjectToCompare) comparable).getNumber() == 2;
        System.out.println("if this prints. Then Collections.max() found correct number");
    }
}
