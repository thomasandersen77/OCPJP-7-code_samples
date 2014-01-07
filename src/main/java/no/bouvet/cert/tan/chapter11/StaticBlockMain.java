package no.bouvet.cert.tan.chapter11;

/**
 * Created with IntelliJ IDEA.
 * User: thomasa
 * Date: 07.01.14
 * Time: 18:27
 * To change this template use File | Settings | File Templates.
 */
public class StaticBlockMain {
    static {
        try {
            Exception e = new Exception();
            throw new RuntimeException(e); // this is legal
        } catch (Exception e) {
            // throw e; will not compile. static blocks cannot throw checked exceptions
            // throw new RuntimeException(e); // not legal
            // throw e; // not legal
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new StaticBlockMain();
    }
}
