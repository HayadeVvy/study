package kr.a01.basic;

public class VariableTypeMain06 {
	public static void main(String[] args) {
		//[실습]
		//double 타입 변수 pi를 3.14159로 초기화하고,
		//이를 int 타입으로 형변환하여 int z에 저장 후
		//출력하세요.
		double pi = 3.14159;
		int z = (int)pi;
		System.out.println(z);
		
		//int 타입 변수 a에 20를 저장하고 long 타입
		//변수 b에 30을 저장하고 long 타입 변수 
		//result에 a와 b를 합산해서 저장 후 출력
		int a = 20;
		long b = 30L;
		long result = a + b;
		System.out.println("result = " + result);
		
		//double 타입 변수 c에 2.5를 저장하고 int 타입
		//변수 d에 30을 저장하고 int 타입 변수 
		//result2에 c와 d를 합산해서 저장 후 출력
		double c = 2.5;
		int d = 30;
		int result2 = (int)c + d;
		System.out.println("result2 = " + result2);		
		
		//byte 타입 변수 b1과 b2를 각각 50,60으로
		//초기화하고, 두 값을 더한 결과를 byte 타입
		//변수 b3에 저장하여 출력하세요.
		byte b1 = 50;
		byte b2 = 60;
		byte b3 = (byte)(b1 + b2);
		System.out.println("b3 = " + b3);		
	}
}




