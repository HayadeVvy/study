package kr.a21.lang;

public class WrapperMain01 {
	public static void main(String[] args) {
		boolean b = true;//기본자료형
		//기본자료형 데이터 -> 참조자료형 데이터
		//boxing
		Boolean wrap_b = new Boolean(b);
		
		//참조자료형 데이터 -> 기본자료형 데이터
		//unboxing
		boolean b2 = wrap_b.booleanValue();
		System.out.println(b2);
		
		//auto boxing/unboxing 사용 가능
		
		//기본자료형 데이터 -> 참조자료형 데이터
		//auto boxing
		Integer obj1 = 10;
		
		//참조자료형 데이터 -> 자료자료형 데이터
		//auto unboxing
		int num = obj1;
		
	}
}





