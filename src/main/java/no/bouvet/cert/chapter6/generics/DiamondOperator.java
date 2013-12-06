package no.bouvet.cert.chapter6.generics;

import javax.swing.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by thomasa on 05.12.13.
 */
public class DiamondOperator {
    public static void main(String[] args) {
        // compiles, but gives a compiler waring
        List<Integer> list = new ArrayList();
        // list.add(new Double(123));

        Map<String, Integer> invalidMap = new HashMap();
        // invalidMap.put(123, "string");

        // type safe and correct
        List<Integer> typeSafeList = new ArrayList<>();



    }
}
