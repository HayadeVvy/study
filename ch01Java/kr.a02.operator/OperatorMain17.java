package kr.a02.operator;

public class OperatorMain17 {
	public static void main(String[] args) {
		//문자형 변수 선언 및 초기화
		char ch = 'b';
		//String result = (ch >= 'A' && ch <= 'Z') ? "대문자임" : "대문자가 아님";
		String result = (ch >= 65 && ch <= 90) ? "대문자임" : "대문자가 아님";
		System.out.println(ch + " = " + result);
		
		System.out.println("-".repeat(20));
		
		//정수형 변수 선언 및 초기화
		int age = 29;
		String result2 = (age>=10 && age<=19)? "10대" : "10대 아님";
		System.out.println(age + " = " + result2);
		
	}
}



