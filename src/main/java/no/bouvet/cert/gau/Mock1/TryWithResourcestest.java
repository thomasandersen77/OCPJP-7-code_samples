package no.bouvet.cert.gau.Mock1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by gaute.lyngstad on 12.12.13.
 */
public class TryWithResourcesTest {

    public static void main(String[] args) {
        method1();
        method2();
    }

    public static void method1(String... args) {
        try( Person p = new Person()) {
            //..
        } catch (Exception e) {
            e.printStackTrace();
        }finally{/*...*/}
    }

    public static void method2(String... args) {
        try( Person p = new Person();) {
            //..
        }
    }

    static class Person implements AutoCloseable {

        @Override
        public void close()  {
            System.out.println("im closing");
        }
    }
}


