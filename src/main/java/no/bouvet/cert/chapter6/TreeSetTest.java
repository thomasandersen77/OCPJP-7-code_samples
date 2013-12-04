package no.bouvet.cert.chapter6;

import java.util.Set;
import java.util.TreeSet;

public class TreeSetTest {
	public static void main(String args[]){
		String pangram = "the quick brown fox jumps over the lazy dog";
		Set<Character> aToZee = new TreeSet<>();
		for(char gram: pangram.toCharArray()){
			aToZee.add(gram);
		}
		System.out.println("The pangram is: "+pangram);
		System.out.println("Sorted pangram characters are: "+aToZee);
	}
}
