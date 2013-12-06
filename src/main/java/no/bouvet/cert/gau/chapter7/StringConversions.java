package no.bouvet.cert.gau.chapter7;

public class StringConversions {
	
	public static void main(String args[]){
		String str1 = String.valueOf(10);
		System.out.println(str1);
		
		//compiler error
//		String str2 = 10;
//		String str3 = (String)10;
		
		
		//compiler error
//		int i = "10";
//		int i = (int) "10";
		
		int i = Integer.parseInt("10");
		System.out.println(i);
		
		try{
			float f = Float.parseFloat("no such value");
			System.out.println(f);
		}catch(Exception e){
			System.out.println("No such value");
		}
	}
}
