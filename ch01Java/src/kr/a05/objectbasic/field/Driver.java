package kr.a05.objectbasic.field;

public class Driver {
	//멤버 필드(속성)
	String name;//멤버 변수
	String job;
	int age;
	
	public static void main(String[] args) {
		//객체 선언
		Driver d;
		//객체 생성
		d = new Driver();
		
		//객체의 멤버 변수에 값 할당
		d.name = "박문수";
		d.job = "운전기사";
		d.age = 40;
		
		//객체의 멤버 변수에 저장된 값 출력
		System.out.println("이름 : " + d.name);
		System.out.println("직업 : " + d.job);
		System.out.println("나이 : " + d.age);
		
	}
}





