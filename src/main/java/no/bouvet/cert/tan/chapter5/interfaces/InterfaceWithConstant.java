package no.bouvet.cert.tan.chapter5.interfaces;

/**
 * Created with IntelliJ IDEA.
 * User: thomasa
 * Date: 28.04.14
 * Time: 12:57
 * To change this template use File | Settings | File Templates.
 */
public interface InterfaceWithConstant {
    int constant = 0; // implicit public static final
}

class Main {
    public static void main(String[] args) {
        final int constant = InterfaceWithConstant.constant;

    }
}
