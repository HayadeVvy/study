package kr.a11.objectbasic.thistest;

public class LocalVariableMain {
	//멤버변수 : 클래스 블럭 내에서 정의된 변수
	int b = 200;
	
	//멤버메서드
	public void make() {
		//지역변수 : 메서드,생성자,제어문 블럭 내에서
		//         생성된 변수, 해당 블럭이 종료되면
		//         변수는 소멸함
		int a = 100;
		System.out.println("지역변수 a : " + a);
		System.out.println("멤버변수 b : " + b);
	}
	
	public void fun() {
		//fun메서드 안에 a가 정의되어 있지 않기 때문에
		//호출 불가
		//System.out.println("a : " + a);
		System.out.println("b : " + b);
	}
	
	public static void main(String[] args) {
		//지역변수
		int c = 300;
		System.out.println("c : " + c);
		
		//제어문 블럭에 정의한 변수는 지역변수
		for(int i=1;i<=5;i++) {
			System.out.print(i + "\t");
		}
		//제어문 블럭에서 정의된 지역변수는 제어문
		//밖에서 호출 불가
		//System.out.println("i : " + i);
		System.out.println();
		System.out.println("-".repeat(20));
		
		int a;
		for(a=1;a<=5;a++) {
			System.out.print(a + "\t");
		}
		System.out.println();
		System.out.println(a);
		
	}
}





