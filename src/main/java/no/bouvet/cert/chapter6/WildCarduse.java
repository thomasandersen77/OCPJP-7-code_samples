package no.bouvet.cert.chapter6;

import java.util.ArrayList;
import java.util.List;

public class WildCarduse {

	static void printList(List<?> list){
		for(Object l:list){
			System.out.println("["+l+"]");
		}
	}
	
	public static void main(String args[]){
		List<Integer> list = new ArrayList<>();
		list.add(10);
		list.add(100);
		printList(list);
		
		List<String> strList = new ArrayList<>();
		strList.add("10");
		strList.add("100");
		printList(strList);
	}
}
