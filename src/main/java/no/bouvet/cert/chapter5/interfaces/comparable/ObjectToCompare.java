package no.bouvet.cert.chapter5.interfaces.comparable;

/**
 * Simple class that implements the Comparable interface
 * Created by thomasa on 04.12.13.
 */
public class ObjectToCompare implements Comparable<ObjectToCompare> {

    private int number;

    public ObjectToCompare(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public int compareTo(ObjectToCompare o) {
        return this.number - o.getNumber();
    }
}
