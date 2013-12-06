package no.bouvet.cert.gau.chapter12.FormattingForLocalCulture.NumberFormat;

import java.text.*;

/**
 * Created by gaute.lyngstad on 06.12.13.
 */
public class FractionDigits {
    public static void main(String[] args) throws ParseException{
        String [] numbers = {"1.222", "0.12345F"};
        double [] doubles = {1.222, 0.12345F};

        NumberFormat numberFormat = NumberFormat.getInstance(); //get a default instance of NumberFormat
        numberFormat.setMaximumFractionDigits(2); // set max decimals that will be shown
        System.out.println("Using format method");
        for(double val: doubles){
            //format double values into String
            System.out.println(numberFormat.format(val)); // 1.222 -> 1.22 , 0.12345 -> 0,12
        }
        System.out.println("Using parse method: ");
        for(String number : numbers){
            //parse String values into Number
            System.out.println(numberFormat.parse(number)); //parse does not use setMaximumFractionDigits()
//            System.out.println(numberFormat.format(number));
        }
    }
}
