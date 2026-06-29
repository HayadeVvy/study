package kr.a06.objectbasic.method;

public class MethodMain04 {
	//멤버 필드(속성)
	String name;
	int korean;
	int english;
	int math;
	
	//멤버 메서드(동작)
	//총점 구하기
	public int makeSum() {
		return korean + english + math;
	}
	//평균 구하기
	public int makeAverage() {
		return makeSum()/3;
	}
	//등급 구하기
	public String makeGrade() {
		String grade;
		switch(makeAverage()/10) {
		case 10:
		case 9: grade = "A"; break;
		case 8: grade = "B"; break;
		case 7: grade = "C"; break;
		case 6: grade = "D"; break;
		default: grade = "F";
		}
		return grade;
	}
	
	public static void main(String[] args) {
		//객체 선언 및 생성
		MethodMain04 me = new MethodMain04();
		me.name = "홍길동";
		me.korean = 98;
		me.english = 96;
		me.math = 97;
		
		System.out.println("이름 : " + me.name);
		System.out.println("국어 : " + me.korean);
		System.out.println("영어 : " + me.english);
		System.out.println("수학 : " + me.math);
		System.out.println(
				"총점 : " + me.makeSum());
		System.out.println(
				"평균 : " + me.makeAverage());
		System.out.println(
				"등급 : " + me.makeGrade());
		
		
	}
}





