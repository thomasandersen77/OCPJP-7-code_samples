package no.bouvet.cert.chapter4.acstractclasses;

/**
 * Created by thomasa on 03.12.13.
 */
public class Main {
    public static void main(String[] args) {

        MyAbstractClass instance = new MySubClass();
        MyAbstractClass instance2 = new MySubClass("Message from parametrized Constructor");

        System.out.println(instance.sayHello());
        System.out.println(instance2.sayHello());
        System.out.println(instance.echo());
        System.out.println(instance2.echo());
    }
}
