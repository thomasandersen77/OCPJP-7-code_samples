package no.bouvet.cert.chapter4.acstractclasses;

/**
 * Created by thomasa on 03.12.13.
 */
public class Main {
    public static void main(String[] args) {

        MyAbstractClass instance = new MySubClass();

        System.out.println(instance.echo());
    }
}
