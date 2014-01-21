package no.bouvet.cert.tan.chapter6.generics;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by thomasa on 05.12.13.
 */
public class DiamondOperator {

    public static void main(String[] args) {

        List<Integer> list = new ArrayList();
        // list.add(new Double(123)); // will not compile

        Map<String, Integer> invalidMap = new HashMap();
        invalidMap.put("test", 123); // will compile

        // type safe and correct
        List<Integer> typeSafeList = new ArrayList<>();
        typeSafeList.add(1);



    }
}
