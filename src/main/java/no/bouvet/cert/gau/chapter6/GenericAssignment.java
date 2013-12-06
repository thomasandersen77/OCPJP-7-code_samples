package no.bouvet.cert.gau.chapter6;

import java.util.List;

public class GenericAssignment<T> {
	
	private List<?> oneType;
	private List<? extends Animal> isAnimal;
	private List<? super Sheldon> shelOrLess;
	
	public List<?> get(List<? super Sheldon> shelOrLess, List<? extends Animal> isAnimal, List<?> oneType){
		List<? extends Animal> list = isAnimal;
		
		this.isAnimal = isAnimal;
		this.shelOrLess =shelOrLess;
		
		this.oneType = isAnimal;
		this.oneType= shelOrLess;
		
//		this.isAnimal = shelOrLess;
//		this.shelOrLess = isAnimal;
//		
//		this.shelOrLess = oneType;
//		this.isAnimal = oneType;
		return oneType;
		
		
	}

}

class Animal{
	
}

class Human extends Animal{
	
}

class Sheldon extends Human{
	
}
