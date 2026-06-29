package kr.a05.objectbasic.field;

/*
 * [실습]
 * 간단한 클래스 정의
 * 이름과 색깔, 속도, 승차인원 지정하고 Bus 클래스를
 * 정의하고 객체를 생성하시오. 객체 생성 이후에 데이터를
 * 할당하고 출력하시오.
 */
class Bus{
	String name;
	String color;
	int speed;
	int person;
}

public class TransportMain02 {
	public static void main(String[] args) {
		//객체 선언 및 생성
		Bus bus = new Bus();
		//멤버 변수에 값 할당
		bus.name = "강아지";
		bus.color = "흰색";
		bus.speed = 100;
		bus.person = 50;
		
		System.out.println("이름 : " + bus.name);
		System.out.println("색깔 : " + bus.color);
		System.out.println("속도 : " + bus.speed);
		System.out.println("승차인원 : " + bus.person);
	}
}




