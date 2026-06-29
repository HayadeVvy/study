package kr.a16.objectbasic.supertest;

//부모 클래스
class People{
	int a = 100;
	public People() {
		super();//Object의 default 생성자 호출
	}
}
//자식 클래스
class Student extends People{
	int b = 200;
	public Student() {
		super();//People의 default 생성자 호출
	}
}

public class SuperMain03 {
	public static void main(String[] args) {
		Student s = new Student();
		System.out.println(s.a);
		System.out.println(s.b);
	}
}





