package no.bouvet.cert.tan.chapter6.generics;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by thomasa on 09.12.13.
 */
public class GenericExtends {
    public static void main(String[] args) {
        PersonList<Person> list = new PersonList<>();
        list.add(new Student());
        list.add(new Teacher());
        System.out.println(list);
        // prints: [no.bouvet.cert.tan.chapter6.generics.Student@6d6f6e28, no.bouvet.cert.tan.chapter6.generics.Teacher@135fbaa4]
    }
}

// need ArrayList<T> to be generic, if not it's raw
class PersonList<T extends Person> extends ArrayList<T>  {

}

class Person {

}

class Student extends Person {

}

class Teacher extends Person {

}
