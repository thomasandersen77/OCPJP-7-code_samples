package no.bouvet.cert.tan.chapter3.polymorphism.constructor;

/**
 * Created with IntelliJ IDEA.
 * User: thomasa
 * Date: 08.01.14
 * Time: 12:47
 * To change this template use File | Settings | File Templates.
 */
public class OverloadConstructor {

    private String field1;
    private String field2;

    public OverloadConstructor() {
        this(null, null);
    }

    public OverloadConstructor(String field1, String field2) {
        this.field1 = field1;
        this.field2 = field2;
    }

    @Override
    public String toString() {
        return "OverloadConstructor{" +
                "field1='" + field1 + '\'' +
                ", field2='" + field2 + '\'' +
                '}';
    }

    public static void main(String[] args) {
        System.out.println( new OverloadConstructor() );
        System.out.println( new OverloadConstructor("param1", "param2") );
    }
}
