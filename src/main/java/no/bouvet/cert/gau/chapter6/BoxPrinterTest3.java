package no.bouvet.cert.gau.chapter6;

/**
 * Created with IntelliJ IDEA.
 * User: gaute.lyngstad
 * Date: 21.11.13
 * Time: 14:20
 * To change this template use File | Settings | File Templates.
 */

class BoxPrinter<K>{
    private K val;
    public BoxPrinter(K arg){
        val = arg;
    }
    public String toString(){
        return "["+val+"]";
    }
    public K getValue(){
        return val;
    }
}

public class BoxPrinterTest3 {
    public static void main(String []args){
        BoxPrinter<Integer> value1 = new BoxPrinter<>(new Integer(10));
        System.out.println(value1);
        Integer intValue1 = value1.getValue();

        BoxPrinter<String> value2 = new BoxPrinter<String>("Hello world");
        System.out.println(value2);
        String intValue2 = value2.getValue();
    }
}
