package no.bouvet.cert.tan.chapter4;

/**
 * Created with IntelliJ IDEA.
 * User: thomasa
 * Date: 07.01.14
 * Time: 16:08
 * To change this template use File | Settings | File Templates.
 */
public class FinalParameterExample {
    public static void main(String[] args) {
        FinalObject test = new Test(new FinalObject("test"), 1).getReference();
        Test t = new Test(new FinalObject("test2"), 1);
        t.setValue(4);  // legal
        t.setValue(5); // legal
        System.out.println(test.getField());
        System.out.println(t.getValue());

    }

}

final class FinalObject {
    private String field;

    FinalObject(String field) {
        this.field = field;
    }

    void setField(String field) {
        this.field = field;
    }

    String getField() {
        return field;
    }
}

class Test {
    private final FinalObject reference;
    private int value;
    public Test(final FinalObject reference, final int value) {
        this.reference = reference;
        // reference = new FinalObject("test"); // not legal because reference is final
        // this.reference = new FinalObject("test3"); // not legal because of final
        this.value = value;
        // value = value + 1; no
    }

    int getValue() {
        return value;
    }

    public final void setValue(int value) {
        this.value = value;
        value = 0;
    }

    // cannot be overridden
    public final FinalObject getReference() {
        return reference;
    }
}
