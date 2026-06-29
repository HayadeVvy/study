package kr.a02.operator;

public class OperatorMain11 {
	public static void main(String[] args) {
		//[실습]
		//정수 a = 10, b = 5 
		//a>5 && b>0 연산하고 결과 result에 담고
		//출력하시오.
		int a = 10, b = 5;
		boolean result = a > 5 && b > 0;
		System.out.println("result = " + result);
		
		//정수 a2 = 3, b2 = 7
		//a2 > 5 || b2 > 5 연산하고 result2에 담고
		//출력하시오.
		int a2 = 3, b2 = 7;
		boolean result2 = a2 > 3 || b2 > 5;
		System.out.println("result2 = " + result2);
		
	}
}
