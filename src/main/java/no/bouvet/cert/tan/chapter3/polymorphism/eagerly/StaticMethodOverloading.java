package no.bouvet.cert.tan.chapter3.polymorphism.eagerly;

/**
 * Created with IntelliJ IDEA.
 * User: thomasa
 * Date: 08.01.14
 * Time: 10:44
 * To change this template use File | Settings | File Templates.
 */
public class StaticMethodOverloading {

    public void overloaded(String s) {
        overloaded(s, null);
    }
    public void overloaded(double d) {
        System.out.printf("double method %f%n", d);
    }
    public void overloaded(int s) {
        System.out.printf("int method [%d]%n", s);
    }
    public void overloaded(short s) {
        System.out.printf("short method [%d]%n", s);
    }
    public void overloaded(String s, Integer i) {
        System.out.printf("String and int method [%s] [%d]%n", s, i);
    }

    public static void main(String[] args) {
        StaticMethodOverloading methodOverloading = new StaticMethodOverloading();
        methodOverloading.overloaded(2.2);
        methodOverloading.overloaded("test");
        methodOverloading.overloaded(100);
        methodOverloading.overloaded("two params", 2);
        methodOverloading.overloaded((short)1);
    }

}
