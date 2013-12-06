package no.bouvet.cert.tan.chapter3.constructors;

/**
 * This class does not define a constructor, therefor Java creates one for you implicit
 * <br/>
 * Created by thomasa on 03.12.13.
 */
public class DefaultConstructorExample {

    public static void main(String[] args) {
        /**
         * Since I can instantiate this class without defining a constructor, it is
         * because Java does it for me internally
         */
        DefaultConstructorExample constructor = new DefaultConstructorExample();
        System.out.println(constructor.toString()); // valid instance of object
    }
}
