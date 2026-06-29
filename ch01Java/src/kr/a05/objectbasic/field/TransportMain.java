package kr.a05.objectbasic.field;

class Car{
	//멤버 필드
	String company = "현대자동차";
	String model = "그랜저"; 
	String color = "검정색";
	int maxSpeed = 350;
	int speed = 90;
}

public class TransportMain {
	public static void main(String[] args) {
		//객체 선언 및 생성
		Car myCar = new Car();
		//필드 값 읽기
		System.out.println(
				"제작회사 : " + myCar.company);
		System.out.println(
				"모델명 : " + myCar.model);
		System.out.println(
				"색깔 : " + myCar.color);
		System.out.println(
				"최고속도 : " + myCar.maxSpeed);
		System.out.println(
				"현재속도 : " + myCar.speed);
		
		//필드 값 변경
		myCar.speed = 60;
		System.out.println(
				"수정된 속도 : " + myCar.speed);
	}
}





