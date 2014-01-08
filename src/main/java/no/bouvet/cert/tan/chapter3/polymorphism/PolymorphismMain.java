package no.bouvet.cert.tan.chapter3.polymorphism;

import no.bouvet.cert.tan.chapter3.polymorphism.dynamic.DerivedOverrider;
import no.bouvet.cert.tan.chapter3.polymorphism.dynamic.RuntimePolymorphismBase;

/**
 * Created with IntelliJ IDEA.
 * User: thomasa
 * Date: 08.01.14
 * Time: 10:37
 * To change this template use File | Settings | File Templates.
 */
public class PolymorphismMain {
    public static void main(String[] args) {

        RuntimePolymorphismBase base = new DerivedOverrider();
        base.overrideMe();


    }
}
