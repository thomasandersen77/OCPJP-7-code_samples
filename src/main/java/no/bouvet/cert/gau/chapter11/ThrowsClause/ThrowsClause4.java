package no.bouvet.cert.gau.chapter11.ThrowsClause;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * User: gaute.lyngstad
 * Date: 05.12.13
 * Time: 14:18
 * To change this template use File | Settings | File Templates.
 */
interface IntReader {

    int readIntFromFile() throws IOException;
}

public class ThrowsClause4 implements IntReader{

    /**
     *
     * @return value of first integer in file
     * @throws IOException
     * @throws ArrayIndexOutOfBoundsException
     * @throws NullPointerException
     */
    @Override
    public int readIntFromFile() throws IOException, ArrayIndexOutOfBoundsException, NullPointerException{
        // a derived can add extra unchecked exceptions, but not more checked exceptions
        // as it has a contract with the class or interface it derived from of what checked
        // exceptions that can occur.
        Scanner scanner = new Scanner(new File("integer.txt"));
        return scanner.nextInt();
    }
}
