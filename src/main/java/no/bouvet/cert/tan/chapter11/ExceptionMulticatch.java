package no.bouvet.cert.tan.chapter11;

/**
 * Created by thomasa on 19.12.13.
 */
public class ExceptionMultiCatch {
    public ExceptionMultiCatch() {
        System.out.println(this);
    }

    public static void main(String[] args) {
        try{
            new ExceptionMultiCatch();
            return; // no effect because of finally
        } finally {
            System.out.println("Finally...");
            return;
        }
    }
}
