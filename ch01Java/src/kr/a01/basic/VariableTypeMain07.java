package kr.a01.basic;

public class VariableTypeMain07 {
	public static void main(String[] args) {
		int a = 2;
		char b = 'A';
		//b가 char -> int 자동 형변환
		//    'A'    65
		int result = a + b;
		System.out.println("result = " + result);
		System.out.println("result = " + (char)result);
		
	}
}
