package kr.a02.operator;

public class OperatorMain15 {
	public static void main(String[] args) {
		System.out.println("===조건(삼항)연산자===");
		
		int a = 5, b = 10;
		//최대값,최소값을 저장하는 변수를 선언
		int max;
		int min;
		max = a > b ? a : b;
		System.out.println("max = " + max);
		min = a < b ? a : b;
		System.out.println("min = " + min);
		
	}
}


