package no.bouvet.cert.tan.chapter3.polymorphism.dynamic;

/**
 * Created with IntelliJ IDEA.
 * User: thomasa
 * Date: 08.01.14
 * Time: 10:40
 * To change this template use File | Settings | File Templates.
 */
public class RuntimePolymorphismBase {

    public void overrideMe(){
        System.out.println("I come from Base class");
    }

    public void overrideObject(String object) {
        System.out.println("Base overrideObject: " + object);
    }

}
