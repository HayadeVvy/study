package kr.a21.lang;

public class ObjectMain {
	public static void main(String[] args) {
		ObjectMain om = new ObjectMain();
		//Object로부터 상속 받은 메서드를 호출
		//Class 객체 반환
		System.out.println(om.getClass());
		//클래스명 출력
		System.out.println(
				om.getClass().getName());
		//해시 코드값 출력
		System.out.println(om.hashCode());
		//해시 코드값을 16진수로 변환
		System.out.println(
				Integer.toHexString(
						om.hashCode()));
		//참조값 출력
		System.out.println(om.toString());
	}
}


