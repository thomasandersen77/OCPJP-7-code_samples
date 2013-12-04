package no.bouvet.cert.chapter7;

public class MatchRegionInString {

	public static void main(String args[]){
		String chat = "Tarzan: Hi Jane, wanna ride an Elephant? \n "
				+ "Jane: No thanks! I'm preparing for OCPJP now!";
		
		String matchString = "Jane: No thanks!";
		
		int startIndex = chat.indexOf('\n');
		System.out.println("Jane's respons starts at the index: "+ startIndex);
		
		if(startIndex>-1){
			boolean doesMatch = chat.regionMatches(startIndex+1+1, matchString, 0, matchString.length());
			if(doesMatch){
				System.out.println("Jane's respons matches with the string "+matchString);
			}
			else{
				System.out.println("Inner What");
			}
		}
		else{
			System.out.println("What");
		}
	}
}
