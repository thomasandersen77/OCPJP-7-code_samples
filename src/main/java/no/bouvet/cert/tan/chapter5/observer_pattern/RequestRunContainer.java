package no.bouvet.cert.tan.chapter5.observer_pattern;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Observable;
import java.util.Observer;

/**
 * Created with IntelliJ IDEA.
 * User: thomasa
 * Date: 29.04.14
 * Time: 12:21
 * To change this template use File | Settings | File Templates.
 */
public class RequestRunContainer implements Observer {
    private Collection<Observable> collection = new ArrayList();

    @Override
    public void update(Observable o, Object arg) {
        System.out.println("Observed a request running: " + o + ", arg: " +arg);
        collection.add(o);
    }


    public static void main(String[] args) {
        Observer observer = new RequestRunContainer();
        Request request1 = new Request("request 1");
        request1.addObserver(observer);
        request1.run();
    }

}
