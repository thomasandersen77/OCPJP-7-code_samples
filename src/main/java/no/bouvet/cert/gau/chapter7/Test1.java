package no.bouvet.cert.gau.chapter7;

public class Test1 {
	
	//%[Flags][width][.precision]datatype_specifier
	
	public static void main(String args[]){
		
		
		//"%1$s[StringF: arg[0] String] %s %<s[StringF: last specified format(A) String]
		System.out.printf(" %s %3$s %s %<s %s", "A", "B", "C");
		System.out.println();
		
		System.out.printf("%4$-2s %3$2s %2$2s %1$2s", "a", "b", "c", "d");
		System.out.println();
		System.out.printf("This is %s %2$s %s", "what ", "it", "is");
		System.out.println();
		
		String [] words = "1 dan 2 dave 3 dick".split("\\d");
		for(String word:words){
			System.out.println(word);
		}
		
		System.out.printf("\"%-+5d4\"", 100);
		System.out.println();
	}
}
