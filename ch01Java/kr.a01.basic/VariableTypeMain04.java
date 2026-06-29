package kr.a01.basic;

public class VariableTypeMain04 {
	public static void main(String[] args) {
		System.out.println(
		  "===묵시적 형변환(자동 형변환)===");
		//더 큰 자료형으로 승격이 일어나는 형태,
		//정보의 손실이 전혀 없으며 자동적으로 발생
		
		byte b1 = 127; //byte 표현범위:-128~127
		byte b2 = 127;
		//32bit미만의 자료형 데이터를 연산하면 자료형이
		//32bit(int)로 변화됨
		int b3 = b1 + b2;
		System.out.println("b3 = " + b3);
		
		//short 표현범위 : -32,768 ~ 32,767
		short s1 = 32767;
		short s2 = 32767;
		//32bit미만의 자료형 데이터를 연산하면 자료형이
		//32bit(int)로 변화됨
		int s3 = s1 + s2;
		System.out.println("s3 = " + s3);
		
		int in1 = 234;
		long lg = in1;
		System.out.println("lg = " + lg);
		
		int in2 = 123;
		long lg2 = 123L;
		//in2의 자료형 int -> long으로 자동 형변환
		long result = in2 + lg2;
		System.out.println("result = " + result);
		
		int in3 = 123;
		double db1 = 10.3;
		//in3의 자료형 int -> double로 자동 형변환
		double result2 = in3 + db1;
		System.out.println("result2 = " + result2);
		
		long lg3 = 12345L;
		//정수 -> 실수로 자동 형변환
		float f1 = lg3;
		System.out.println("f1 = " + f1);
		
	}
}


