package no.bouvet.cert.gau.chapter11.Assertions;

/**
 * Created with IntelliJ IDEA.
 * User: gaute.lyngstad
 * Date: 05.12.13
 * Time: 14:44
 * To change this template use File | Settings | File Templates.
 */
public class AssertionExample1 {

    //Hack to get assertions to work directly
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        ClassLoader loader = ClassLoader.getSystemClassLoader();
        loader.setDefaultAssertionStatus(true);
        Class<?> c = loader.loadClass("no.bouvet.cert.gau.chapter11.Assertions.MyClass");
        MyClass myObj = (MyClass) c.newInstance();
    }
}
class MyClass{

    MyClass(){
        int i = -10;
        if(i < 0){
            // if negative value, convert into positive value;
            i = -i;
        }
//        i = Integer.MIN_VALUE;
        System.out.println("the value of i is. " + i);

        //at this point the assumption is that i cannot be negative;
        //assert this condition since its an assumption that will always hold
        assert (i>=0) : "impossible: i is negative!";
    }
}

