package no.bouvet.cert.chapter7;

public class ParseString1 {

	public static void main(String[] s){
		String quote = "Never lend books-nobody ever returns them!";
		String [] words  = quote.split(" ");
		
		for(String w :words){
			System.out.println(w);
		}
	}
}
