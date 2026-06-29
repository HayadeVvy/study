package kr.a05.objectbasic.field;

public class Student03 {
	//멤버 필드
	String name;
	int korean;
	int math;
	int english;
	int sum;
	double average;
	
	public static void main(String[] args) {
		//객체 선언 및 생성
		Student03 student = new Student03();
		student.name = "홍길동";
		student.korean = 98;
		student.math = 97;
		student.english = 95;
		student.sum = student.korean 
				+ student.math + student.english;
		student.average = student.sum/3.0;
	}
}





