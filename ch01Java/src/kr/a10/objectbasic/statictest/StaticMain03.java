package kr.a10.objectbasic.statictest;

public class StaticMain03 {
	
	//멤버 변수(인스턴스 변수)
	String s1 = "서울";
	//static(클래스) 변수
	static String s2 = "우주"; 
	
	//static 메서드
	public static String getString() {
		return s2;
	}	
	
	public static void main(String[] args) {
		//인스턴스 변수를 사용할 경우 객체 생성 후에
		//호출해야 함
		//System.out.println(s1);
		
		StaticMain03 sm = new StaticMain03();
		System.out.println(sm.s1);
		
		//static 메서드 호출
		System.out.println(getString());
		
	}
}




