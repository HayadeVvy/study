package kr.a06.objectbasic.method;

public class MethodMain14 {
	//전달되는 인자의 타입을 모두 String으로
	//변환해서 문자열의 길이를 구하는 메서드 만들기
	public void getLength(int n) {
		//int -> String
		String s = String.valueOf(n);
		getLength(s);
	}
	public void getLength(float n) {
		//float -> String
		String s = String.valueOf(n);
		getLength(s);
	}
	public void getLength(String s) {
		System.out.println(
				s + "의 길이 : " + s.length());
	}
	public static void main(String[] args) {
		MethodMain14 me = 
				new MethodMain14();
		me.getLength(20000);//-> "20000"
		me.getLength(3.14f);//-> "3.14"
		me.getLength("Hello World");		
	}
}




