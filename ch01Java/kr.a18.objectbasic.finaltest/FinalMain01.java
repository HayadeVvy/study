package kr.a18.objectbasic.finaltest;

class A{
	//멤버 필드
	//상수, 지정한 값은 변경 불가능
	final int NUM = 10;
	
	//static 상수
	public static final int NUMBER = 20;
}

public class FinalMain01 {
	public static void main(String[] args) {
		A ap = new A();
		//상수는 변경 불가능
		//ap.NUM = 20;
		System.out.println(ap.NUM);
		System.out.println("-".repeat(20));
		
		//static 상수
		System.out.println(A.NUMBER);
		System.out.println("-".repeat(20));
		
		//메서드 안에 상수 정의 가능
		final int NO = 30;
		System.out.println(NO);
		
	}
}



