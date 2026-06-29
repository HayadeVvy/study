package kr.a01.basic;

public class VariableTypeMain05 {
	public static void main(String[] args) {
		System.out.println(
				"===명시적 형변환(강제 형변환)===");
		//더 작은 자료형으로 강등이 일어나는 형태,
		//정보의 손실이 발생할 수 있음.
		byte b1 = 127;
		byte b2 = 127;
		//연산에의해 자동적으로 int 형변환 된 것을
		//byte로 다시 강제 형변환
		byte b3 = (byte)(b1 + b2);
		System.out.println("b3 = " + b3);
		
		short s1 = 32767;
		short s2 = 32767;
		//연산에의해 자동적으로 int 형변환 된 것을
		//short로 다시 강제 형변환
		short s3 = (short)(s1 + s2);
		System.out.println("s3 = " + s3);
		
		int in1 = 123;
		long lg1 = 123L;
		//lg1의 자료형 long -> int로 강제 형변환
		int result = in1 + (int)lg1;
		System.out.println("result = " +result);
		
		int in2 = 123;
		float f1 = 123.56f;
		int result2 = in2 + (int)f1;
		System.out.println("result2 = " + result2);
		
	}
}



