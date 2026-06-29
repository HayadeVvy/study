package kr.a02.operator;

public class OperatorMain02 {
	public static void main(String[] args) {
		System.out.println("===산술연산자===");
		System.out.println(1 + 1);
		System.out.println(3 - 2);
		System.out.println(4 * 2);
		//정수를 정수로 나누면 결과값은 정수
		System.out.println(10 / 3);
		//정수를 실수로 강제 형변환해서 실수를 정수로
		//나누면 정수가 실수로 자동 형변환 후 연산
		//결과값은 실수
		System.out.println((double)10 / 3);
		System.out.println(10.0 / 3);
		
		//나머지값
		System.out.println(10 % 3);
	}
}




