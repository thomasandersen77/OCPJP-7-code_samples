package no.bouvet.cert.tan.chapter5.observer_pattern;

import java.util.Observable;

/**
 * Created with IntelliJ IDEA.
 * User: thomasa
 * Date: 29.04.14
 * Time: 12:23
 * To change this template use File | Settings | File Templates.
 */
public class Request extends Observable {
    private String name;

    public Request(String name) {
        this.name = name;
    }

    public void run(){
        setChanged();
        notifyObservers(name);
    }

    @Override
    public String toString() {
        return "Request{" +
                "name='" + name + '\'' +
                '}';
    }
}
