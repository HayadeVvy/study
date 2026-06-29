package kr.a07.objectbasic.constructor;

class Car{
	//멤버 필드
	String color;
	String gearType;
	int door;
	
	//생성자
	public Car() {} //생략 가능
}

public class ConstructorMain01 {
	public static void main(String[] args) {
		Car c1 = new Car();
		c1.color = "흰색";
		c1.gearType = "auto";
		c1.door = 4;
		
		System.out.println("색상 : " + c1.color);
		System.out.println("기어타입 : " + c1.gearType);
		System.out.println("문개수 : " + c1.door);
		
		
	}
}


