package no.bouvet.cert.tan.chapter3.covariant;

/**
 * Created with IntelliJ IDEA.
 * User: thomasa
 * Date: 08.01.14
 * Time: 15:26
 * To change this template use File | Settings | File Templates.
 */
public abstract class BaseForCovariant {
    public abstract Object getObject();
}

class SubClassCovariant extends BaseForCovariant {
    @Override
    public String getObject() {
        return "String form SubClassCovariant";
    }

    public static void main(String[] args) {
        System.out.println(new SubClassCovariant().getObject());
    }
}