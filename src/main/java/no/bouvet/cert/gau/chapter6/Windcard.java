package no.bouvet.cert.gau.chapter6;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Windcard {
	public static void main(String args[]){
		List<? extends Number> intList = Collections.nCopies(5, new Integer(10));
		List<Object> objList = new ArrayList<Object>();
		for(Number i:intList){
			objList.add(new Object());
		}
		
		copy(objList, intList);
		System.out.println(objList);
	}
	
	private static <T> void copy(List<? super T> dest, List<? extends T> src){
				
		for(int i = 0; i<src.size();i++){
			dest.set(i, src.get(i));
		}
	}

}
