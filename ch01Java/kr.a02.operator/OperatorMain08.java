package kr.a02.operator;

public class OperatorMain08 {
	public static void main(String[] args) {
		//[실습]
		//int 변수 num = 17에 대해 나머지 연산자를
		//사용하여 짝수인지 홀수인지 판별하여 출력
		//하시오. 
		int num = 16;
		boolean isEven = num % 2 == 0;
		System.out.println(
			num + "은(는) 짝수인가:" + isEven);
		
		//int 변수 num2 = 27에 대해 3의 배수인지
		//판별하여 출력하세요.
		
		int num2 = 27;
		boolean isMultiple = num2 % 3 == 0;
		System.out.println(
			num2 + "은(는) 3의 배수인가:" + isMultiple);
		
		
	}
}
