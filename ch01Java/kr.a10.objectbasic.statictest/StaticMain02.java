package kr.a10.objectbasic.statictest;

public class StaticMain02 {
	//static 메서드는 객체 생성과 무관하게 동작하며
	//호출하면 static 영역에 생성
	public static void print(String str) {
		System.out.println(str);
	}
	//멤버 메서드(인스턴스 메서드)
	public void make(String str) {
		System.out.println(str);
	}
	
	public static void main(String[] args) {
		//StaticMain02.print("겨울");
		print("가을");
		System.out.println("-".repeat(20));
		//멤버 메서드(인스턴스 메서드)는 객체 생성 후
		//호출 가능
		//make("서울");
		
		StaticMain02 sm = new StaticMain02();
		sm.make("부산");
	}
}



