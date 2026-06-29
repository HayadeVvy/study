package kr.a01.basic;

public class VariableMain02 {
	public static void main(String[] args) {
		//[실습]
		//정수형 변수 age를 선언하고 25로 초기화한 후 출력
		int age = 25;
		System.out.println(age);
		System.out.println("age = " + age);
		System.out.printf("age = %d%n", age);
		
		System.out.println("-".repeat(20));
		
		//국어 점수 99는 변수 korean에 저장하고
		//영어 점수 80은 변수 English에 저장하고
		//수학 점수 95는 변수 math에 저장
		//국어,영어,수학을 합산해서 변수 sum에 저장
		//총점을 출력하시오.
		/*
		int korean = 99;
		int english = 80;
		int math = 95;
		*/
		
		int korean = 99, english = 80, math = 95;
		
		int sum = korean + english + math;
		
		System.out.printf("총점 = %d%n", sum);
		
		
	}
}




