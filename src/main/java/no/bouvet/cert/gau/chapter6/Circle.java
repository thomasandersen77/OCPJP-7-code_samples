package no.bouvet.cert.gau.chapter6;

import java.util.HashSet;
import java.util.Set;

class Circle {
	private int xPos, yPos, radius;
	public Circle(int x, int y, int r){
		xPos =x; yPos = y; radius = r;
	}
	
	@Override
	public boolean equals(Object arg) {
		if(this == arg) return true;
		if(arg instanceof Circle){
			Circle that = (Circle) arg;
			if((this.xPos == that.xPos)&&(this.yPos ==that.yPos)
					&&(this.radius == that.radius)){
				return true;
			}
		}
		return false;
	}
	@Override
	public int hashCode() {
		return (7 * xPos)^(11 * yPos)^(53 * yPos);
	}
	public static void main(String... args){
		Set<Circle> circleList = new HashSet<>();
		circleList.add(new Circle(10,20,5));
		System.out.println(circleList.contains(new Circle(10, 20, 5)));
	}
}

