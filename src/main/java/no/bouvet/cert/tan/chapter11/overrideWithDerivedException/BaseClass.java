package no.bouvet.cert.tan.chapter11.overrideWithDerivedException;

/**
 * Created with IntelliJ IDEA.
 * User: thomasa
 * Date: 07.01.14
 * Time: 18:32
 * To change this template use File | Settings | File Templates.
 */
public abstract class BaseClass {
    public abstract void testThrow() throws Exception;
}

class SubClass extends BaseClass {

    /**
     * this method overrides with a derived exception in method signature
     * @throws RuntimeException
     */
    @Override
    public void testThrow() throws RuntimeException {
        // throw new Exception(); // unhandled exception
    }
}
