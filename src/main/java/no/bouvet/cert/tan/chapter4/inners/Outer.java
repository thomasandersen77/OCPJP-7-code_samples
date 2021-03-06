package no.bouvet.cert.tan.chapter4.inners;

/**
 * Created with IntelliJ IDEA.
 * User: thomasa
 * Date: 10.01.14
 * Time: 14:10
 * To change this template use File | Settings | File Templates.
 */
public class Outer {
    int field5 = 5;

    class Inner {

        final static int field10 = 10;
        public Inner(){
            System.out.println(this.getClass().getName() + "| " +Outer.this.field5);
        }
    }

    public void methodWithAnonymousLocalInner(){
        Object obj = new Object() {
            @Override
            public String toString() {
                // prints: no.bouvet.ce0rt.tan.chapter4.inners.Outer$1
                return this.getClass().getName() + "  |  " + Inner.field10;
            }
        };
        System.out.println(obj.toString());
    }

    static class StaticInner {

    }
}

class Main {
    public static void main(String[] args) {
        Outer outer = new Outer();
        Outer.Inner inner = outer.new Inner();
        //System.out.println( inner.getClass().getName() );

        Outer.StaticInner staticInner = new Outer.StaticInner();
        System.out.println(staticInner.getClass().getName());
        // Outer.StaticInner staticInner2 = Outer.StaticInner; // must have new keyword

        new Outer().methodWithAnonymousLocalInner();
    }
}
