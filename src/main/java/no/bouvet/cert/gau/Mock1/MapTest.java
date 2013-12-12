package no.bouvet.cert.gau.Mock1;

import java.util.Hashtable;
import java.util.IdentityHashMap;
import java.util.Map;
import java.util.NavigableMap;
import java.util.concurrent.ConcurrentMap;

/**
 * Created by gaute.lyngstad on 11.12.13.
 */
public class MapTest {
    public static void main(String[] args) {

        //interface
//        Map<String, String> map1 = new NavigableMap<String, String>();

        Map<String,String> map2 = new IdentityHashMap<>();

        Map<String,String> map3 = new Hashtable<>();

        //interface
//        Map<String,String> map4 = new ConcurrentMap<String, String>();
    }
}
