package no.bouvet.cert.chapter4.acstractclasses;

/**
 * Created by thomasa on 03.12.13.
 */
public abstract class MyAbstractClass  {

    public MyAbstractClass() {
        System.out.println("MyAbstractClass.Constructor");
    }

    public abstract String echo();

    public String sayHello() {
        return "I am instance of " + this.getClass().getSuperclass().getSimpleName();
    }
}
