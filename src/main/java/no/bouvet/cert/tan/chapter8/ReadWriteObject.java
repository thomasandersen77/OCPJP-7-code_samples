package no.bouvet.cert.tan.chapter8;

import java.io.*;

/**
 * Created by thomasa on 09.12.13.
 */
public class ReadWriteObject {

    public static final String FILE_NAME = "C:/temp/person.data";

    public static void main(String[] args) {
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME));
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            oos.writeObject(new Person("thomas", "andersen"));
            Object object = ois.readObject();
            System.out.println(object);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

class Person implements Serializable {
    String firstname;
    String lastname;

    Person(String firstname, String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;
    }



    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }
}
