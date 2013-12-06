package no.bouvet.cert.gau.chapter7;

public class ParseString2 {

	public static void main(String[] args){
		String str = "C:\\work\\programs\\parser";
		String [] dirList = str.split("\\\\");
		for(String word : dirList){
			System.out.println(word);
		}
	}
}
