package no.bouvet.cert.gau.chapter6;

import java.util.TreeSet;

class Person implements Comparable{
	private static int count = 0 ;
	private String id = "0";
	private String interest;
	
	public Person(String interest){
		this.interest = interest; this.id = ""+ ++count;
	}
	public String getInterest(){ return interest;}
	public void setInterest(String interest){this.interest = interest;}
	public String toString(){return id;}
	@Override
	public int compareTo(Object o) {
		if(o instanceof Person){
			if(((Person)o).id == this.id)
				return 0;
			if(((Person)o).interest.equals(this.interest))
				return 1;	
		}
		return -1;
	}
}

public class StudyGroup {
	String name = "MATH";
	TreeSet<Person> set = new TreeSet<Person>();
	public void add(Person p){
		if(name.equals(p.getInterest())) set.add(p);
	}
	
	public static void main(String[] args){
		StudyGroup mathGroup = new StudyGroup();
		mathGroup.add(new Person("MATH"));
		System.out.println("A");
		mathGroup.add(new Person("MATH"));
		System.out.println("B");
		System.out.println(mathGroup.set);
	}
}
