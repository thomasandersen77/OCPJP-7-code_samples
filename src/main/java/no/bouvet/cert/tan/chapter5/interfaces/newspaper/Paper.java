package no.bouvet.cert.tan.chapter5.interfaces.newspaper;

/**
 * Created by thomasa on 04.12.13.
 */
public abstract class Paper implements Printable {

    private String message = "";

    protected Paper(String message) {
        this.message = message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
