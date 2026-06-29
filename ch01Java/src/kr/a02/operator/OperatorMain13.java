package kr.a02.operator;

public class OperatorMain13 {
	public static void main (String[] args) {
		char x = 'j';
		//a부터 z까지 문자 범위에 j에 포함되어있는지 검증
		boolean result = x >= 'a' && x <= 'z';
		System.out.println("result = " + result);
		
	}
}
