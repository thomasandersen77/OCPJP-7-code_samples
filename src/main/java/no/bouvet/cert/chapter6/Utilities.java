package no.bouvet.cert.chapter6;

import java.util.ArrayList;
import java.util.List;

public class Utilities {
	public static <T> void fill(List<T> list, T val){
		for(int i = 0; i<list.size();i++){
			list.set(i, val);
		}
	}
	public static void main(String args[]){
		List<Integer> intList = new ArrayList<>();
		intList.add(10);
		intList.add(20);
		System.out.println("The original list is: "+intList);
		Utilities.fill(intList, 100);
		System.out.println("The list after calling Utilities.fill(): "+intList);
		
	}
}

class UtilitiesTest{

}
