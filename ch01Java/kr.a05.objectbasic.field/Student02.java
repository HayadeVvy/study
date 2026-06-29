package kr.a05.objectbasic.field;

public class Student02 {
	//멤버 필드
	String name;
	int age;
	String hobby;
	String job;	
	
	public static void main(String[] args) {
		//객체 선언 및 생성
		//참조자료형  참조변수       생성자
		Student02 student = new Student02();
		System.out.println(student);//참조값
		
		student.name = "홍길동";
		student.age = 20;
		student.hobby = "축구";
		student.job = "대학생";
		
		System.out.println(student.name + ","
				+ student.age + ","
				+ student.hobby + ","
				+ student.job);
		
		System.out.println("-".repeat(20));
		
		Student02 student2 = new Student02();
		System.out.println(student2);//참조값
		
		student2.name = "박문수";
		student2.age = 19;
		student2.hobby = "야구";
		student2.job = "고등학생";
		
		System.out.println(student2.name + ","
				+ student2.age + ","
				+ student2.hobby + ","
				+ student2.job);
		
	}
}



