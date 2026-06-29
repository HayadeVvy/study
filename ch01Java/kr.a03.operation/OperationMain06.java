package kr.a03.operation;

public class OperationMain06 {
	public static void main(String[] args) {
		int a = 10;
		float b = 10.0f;
		
		if(a == b) {//a의 자료형 int -> float 자동 형변환
			System.out.println("10과 10.0f는 같다.");
		}
		
		char c = '0';//'0'의 아스키 코드 : 48
		int d = 0;
		
		if(c != d) {
			System.out.println("'0'과 0은 같지 않다.");
		}
		
		char e = 'A'; //'A'의 아스키 코드 : 65
		int f = 65;
		
		if(e == f) {
			System.out.println("'A'는 65와 같다");
		}
		
	}
}



