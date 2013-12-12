package no.bouvet.cert.gau.chapter7.ProcessingStrings.StringSearching;

public class SearchString3 {
	public static void main(String args[]){
		String str = "I am a student. I am preparing for OCPJP";
		int fromIndex = 0;
		while(str.indexOf("am", fromIndex)>-1){
			fromIndex = str.indexOf("am", fromIndex);
			System.out.println("Substring \"am\" occurs at index: " + fromIndex	);
			fromIndex++;
		}
		
		System.out.println(str+ ", is starting with I am: "+str.startsWith("I am"));
		System.out.println(str+ ", is starting with \"I am\" starting from index 1: "+str.startsWith("I am", 1));
		
		System.out.println(str+ ", is ends with OCPJP: "+str.endsWith("OCPJP"));


	}
}
