package no.bouvet.cert.gau.chapter13.CreatingThreads;

/**
 * Created by gaute.lyngstad on 09.12.13.
 */
public class SimpleThread2 {
    public static void main(String[] args) {
        Thread t = new Thread();
        t.setName("SimpleThread");
        t.setPriority(9);
        System.out.println(t);
    }
}
