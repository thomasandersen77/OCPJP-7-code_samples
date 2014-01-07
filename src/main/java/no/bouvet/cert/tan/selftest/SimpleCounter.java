package no.bouvet.cert.tan.selftest;

/**
 * Created with IntelliJ IDEA.
 * User: thomasa
 * Date: 07.01.14
 * Time: 15:18
 * To change this template use File | Settings | File Templates.
 */
public class SimpleCounter<T> {
    private static int count = 0;

    public SimpleCounter(){
        count++;
    }

    static int getCount(){
        return count;
    }
}

class CounterTest {
    public static void main(String[] args) {
        SimpleCounter<Double> doubleCounter = new SimpleCounter<Double>();
        SimpleCounter<Integer> intCounter = null;
        SimpleCounter rawCounter = new SimpleCounter();
        System.out.println(doubleCounter.getCount());
        System.out.println(intCounter.getCount());
        System.out.println(rawCounter.getCount());
    }

}
