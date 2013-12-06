package no.bouvet.cert.gau.chapter6;

import java.util.List;

public class GenericTest<T> {

	public static void main(String... args){
		Nostaticmethod<String> nostatic = new Nostaticmethod<>();
		nostatic.setValue("Hello World");
		System.out.println(nostatic);
	}
	

}

class Nostaticmethod<T>{
	private T value;
	public void setValue(T val){
		value = val;
	}
	
	@Override
	public String toString() {
		return value.toString();
	}
}

class GenericStaticMethod<T>{
	
	T internal;
	
	static String output;
	
	public GenericStaticMethod(T inter){
		internal = inter;
	}
	public static <T> void setValue(T val){
		T value = val;
		output = value.toString();
	}
	public static <T> T getValue(T val){
		return val;
	}
}

class GenericNoStaticMethod<T>{
	List<? extends T> value;
	List<? super T> value2;
	
	public GenericNoStaticMethod(List<T> val){
		value = val;
		value2 = val;
	}
	
	public void setValue(List<? extends T>val){
		value = val;
	}
	public List<? extends T> getValue(){
		return value;
	}
}
