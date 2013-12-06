package no.bouvet.cert.gau.chapter6;

import java.util.Arrays;
import java.util.Comparator;

public class ComparatorTest2 {
	public static void main(String args[]){
		Student []students = { new Student("cs011", "Lennon  ", 3.1),
				new Student("cs021", "McCartney", 3.4),
				new Student("cs012", "Harrison", 2.7),
				new Student("cs022", "Starr", 3.7)};
		System.out.println("Before sorting by student ID");
		System.out.println("Student -ID \t Name \t CGPA (for 4.0) ");
		System.out.println(Arrays.toString(students));
		
		Arrays.sort(students, new CGPAComparator());
		
		System.out.println("After sorting by student ID");
		System.out.println("Student -ID \t Name \t CGPA (for 4.0)");
		System.out.println(Arrays.toString(students));
	}
	
	static class Student implements Comparable<Student>{
		String id;
		String name;
		Double cgpa;
		public Student(String studentId, String studentName, double studentCGPA){
			id = studentId;
			name = studentName;
			cgpa = studentCGPA;
		}
		public String toString(){
			return "\n "+id+" \t "+name+" \t "+cgpa;
		}
		public int compareTo(Student that){
			return this.id.compareTo(that.id);
		}
	}

	static class CGPAComparator implements Comparator<Student>{
		public int compare(Student s1, Student s2){
			return s1.cgpa.compareTo(s2.cgpa);
		}
	}
		

}



