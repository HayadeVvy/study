package kr.a05.objectbasic.field;

public class Student01 {
	//멤버 필드
	String name;
	int age;
	String hobby;
	
	public static void main(String[] args) {
		//객체 선언 및 생성
		Student01 student = new Student01();
		//객체가 생성되면 객체의 멤버 변수는 기본값으로
		//초기화 됨
		System.out.println(
				student.name + "," 
		       + student.age + ","
		       + student.hobby);
		System.out.println("-".repeat(20));
		
		//객체의 멤버 변수에 값 할당
		student.name = "홍길동";
		student.age = 20;
		student.hobby = "축구";
		
		//객체의 멤버 변수의 값 출력
		System.out.println(student.name + ","
				+ student.age + ","
				+ student.hobby);
		
		
	}
}



