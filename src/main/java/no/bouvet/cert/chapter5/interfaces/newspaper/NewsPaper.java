package no.bouvet.cert.chapter5.interfaces.newspaper;

/**
 * Created by thomasa on 04.12.13.
 */
public class NewsPaper extends Paper {
    private String name = "";

    public NewsPaper(String printMessage) {
        super(printMessage);
    }

    // overloading constructor
    public NewsPaper(String printMessage, String name) {
        this(printMessage);
        this.name = name;
    }

    @Override
    public void print() {
        System.out.println(getMessage() + ", and my name is " + name.toUpperCase());
    }
}
