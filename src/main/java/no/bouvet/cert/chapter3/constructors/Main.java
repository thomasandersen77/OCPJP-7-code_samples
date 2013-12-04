package no.bouvet.cert.chapter3.constructors;

/**
 * This class does not define a constructor, therefor Java creates one for you implicit
 * Created by thomasa on 03.12.13.
 */
public class Main {

    public static void main(String[] args) {
        /**
         * Since I can instantiate this class without defining a constructor, it is
         * because Java does it for me internally
         */
        Main constructor = new Main();
        System.out.println(constructor.toString()); // valid instance of object
    }
}
