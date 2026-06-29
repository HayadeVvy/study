package kr.a07.objectbasic.constructor;

class Car2{
	String color;
	String gearType;
	int door;
	
	//생성자 
	public Car2(String c, String g, int d) {
		color = c;
		gearType = g;
		door = d;
	}
}

public class ConstructorMain02 {
	public static void main(String[] args) {
		Car2 c1 = new Car2("검정색","manual",5);
		System.out.println("색상 : " + c1.color);
		System.out.println("기어타입 : " + c1.gearType);
		System.out.println("문개수 : " + c1.door);
		
		
		
	}
}



