package no.bouvet.cert.tan.chapter6.generics;

/**
 * A little weakness, probably because of compiler complexity
 *
 * You may add illegal arguments if you leave out the <> operator, but
 *
 * Created by thomasa on 05.12.13.
 */
public class Pair<T1, T2> {
    T1 object1;
    T2 object2;

    public Pair(T1 object1, T2 object2) {
        this.object1 = object1;
        this.object2 = object2;
    }

    public void setObject1(T1 object1) {
        this.object1 = object1;
    }

    public void setObject2(T2 object2) {
        this.object2 = object2;
    }

    public T1 getObject1() {
        return object1;
    }

    public T2 getObject2() {
        return object2;
    }

    public static void main(String[] args) {
        // OBS! This corner case is important to be aware of
        Pair<String, Integer> invalid = new Pair(123, "234"); // this is ok, but wrong according to declaration
        String str = invalid.getObject1(); // this will throw a ClassCastException (object1 was an Integer)
    }
}
