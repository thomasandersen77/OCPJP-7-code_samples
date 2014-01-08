package no.bouvet.cert.tan.chapter3.polymorphism.dynamic;

/**
 * Created with IntelliJ IDEA.
 * User: thomasa
 * Date: 08.01.14
 * Time: 10:41
 * To change this template use File | Settings | File Templates.
 */
public class DerivedOverrider extends RuntimePolymorphismBase {

    @Override
    public void overrideMe(){
        // first print super (base) message
        super.overrideMe();
        // confirm that runtime instance prints correctly
        System.out.println("I come from Derived class");
    }

}
