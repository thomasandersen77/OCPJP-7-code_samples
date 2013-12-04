package no.bouvet.cert.chapter4.acstractclasses;

/**
 * Created by thomasa on 03.12.13.
 */
public class MySubClass extends MyAbstractClass{
    private String echoMessage;
    public MySubClass(String echoMessage) {
        super();
        this.echoMessage = echoMessage;
    }

    public MySubClass() {
        super();
    }

    @Override
    public String echo() {
        return echoMessage != null && !echoMessage.isEmpty() ? echoMessage : "Hello from MySubClass";
    }

    @Override
    public String sayHello() {
        return "I am instance of " + getClass().getSimpleName();
    }
}
