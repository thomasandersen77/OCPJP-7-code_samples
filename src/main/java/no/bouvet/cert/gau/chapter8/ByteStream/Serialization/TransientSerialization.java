package no.bouvet.cert.gau.chapter8.ByteStream.Serialization;

import java.io.*;

/**
 * Created with IntelliJ IDEA.
 * User: gaute.lyngstad
 * Date: 02.12.13
 * Time: 14:44
 * To change this template use File | Settings | File Templates.
 */

class USPresident implements Serializable{
    private static final long serialVersionUID = 1L;

    private String name;
    private String period;
    private transient String term;

    public USPresident(String name, String period, String term) {
        this.name = name;
        this.period = period;
        this.term = term;
    }

    @Override
    public String toString() {
        return "USPresident{" +
                "name='" + name + '\'' +
                ", period='" + period + '\'' +
                ", term='" + term + '\'' +
                '}';
    }
}

public class TransientSerialization {

    public static final String USPRESIDENT_DATA = "USPresident.data";

    public static void main(String[] args) {
        USPresident usPresident = new USPresident("Barack Obama", "2009 to --", "56th term");
        System.out.println(usPresident);

        //Serialize the Object

        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(USPRESIDENT_DATA))){
            oos.writeObject(usPresident);
        } catch (FileNotFoundException e) {
            System.err.println("cannot create a file with the given file name ");
        } catch (IOException e) {
            System.err.println("a I/O error occurred while processing the file");
        }

        // De-serialize the object

        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(USPRESIDENT_DATA))){
            Object obj = ois.readObject();
            if(obj != null && obj instanceof USPresident){
                USPresident presidentOfUS = (USPresident) obj;
                System.out.println(presidentOfUS);
            }

        } catch (FileNotFoundException e) {
            System.err.println("cannot create a file with the given file name");
        } catch (IOException e) {
            System.err.println("an I/O error occurred while processing the file");
        } catch (ClassNotFoundException e) {
            System.err.println("cannot recognize the class of the object - is the file corrupted?");
        }

    }
}
