package kr.a17.objectbasic.poly;

//부모클래스
class People{
	//Object의 toString 재정의
	@Override
	public String toString() {
		return "People 클래스";
	}
}
//자식클래스
class Student extends People{
	@Override
	public String toString() {
		return "Student 클래스";
	}
}

public class InstanceMain01 {
	public static void main(String[] args) {
		People p = new People();
		
		//컴파일시 오류는 없지만 실행시 오류 발생
		//Student ch = (Student)p;
		
		//상속관계일 때 생성된 객체가 명시한 자료형을
		//사용할 수 있는지 체크
		//생성된 객체       자료형
		if(p instanceof Student) {
			Student ch2 = (Student)p;
			System.out.println(ch2);
			System.out.println("-".repeat(20));
		}else {
			System.out.println(p);
		}
		
	}
	
}


