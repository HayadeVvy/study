package kr.a01.basic;

public class VariableTypeMain03 {
	public static void main(String[] args) {
		//[실습]
		//double 타입 변수 두 개를 선언하고 각각
		//3.14, 2.5로 초기화 한 후 곱셈 결과를
		//변수에 담고 결과를 출력하시오.
		
		double num1 = 3.14;
		double num2 = 2.5;
		double result = num1 * num2;
		System.out.printf(
				"result = %.2f%n", result);
		
		System.out.println("-".repeat(20));
		
		//char 타입 변수에 'A'를 저장하고, 
		//String 타입 변수에 "Java"를 저장한 후
		//각각 출력하세요.
		char ch = 'A';
		String str = "Java";
		System.out.println(ch);
		System.out.println(str);
		
		System.out.println("-".repeat(20));
		//boolean 변수 isStudent를 선언하고
		//true로 초기화 한 후, "학생입니까?" 뒤에
		//변수 값을 출력하세요.
		boolean isStudent = true;
		System.out.println("학생입니까?" + isStudent);
		
		//int 변수 a를 10으로, b을 20으로 초기화 한 후,
		//두 변수의 값을 교환하여 출력하세요.
		int a = 10;
		int b = 20;
		int temp = a;
		a = b;
		b = temp;
		System.out.println("a = " + a);
		System.out.println("b = " + b);
	}
}




