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
        FinalObject test = new Test(new FinalObject("test")).getReference();
        System.out.println(test.getField());
    }

}

class FinalObject {
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
    public Test(final FinalObject reference) {
        this.reference = reference;
        this.reference.setField("test2");
        //reference = new FinalObject("test"); // not legal because reference is final
        //this.reference = new FinalObject("test3"); // not legal because of final
    }

    // cannot be overridden
    public final FinalObject getReference() {
        return reference;
    }
}
