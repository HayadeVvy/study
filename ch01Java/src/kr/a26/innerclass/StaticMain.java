package kr.a26.innerclass;

public class StaticMain {
	//static내부클래스
	public static class StaticInner{
		int iv = 200;//인스턴스변수
		static int cv = 300;//static변수
		static void make() {//static메서드
			System.out.println("하하");
		}
	}
	
	public static void main(String[] args) {
		//static내부클래스는 내부클래스를 감싸고 있는
		//클래스를 객체 생성한 후 내부클래스를 객체
		//생성하는 것이 아니라
		//static내부클래스만으로 객체 생성 가능
		StaticMain.StaticInner i = 
				new StaticMain.StaticInner();
		
		//main이 StaticInner와 같은 클래스에 속에
		//있기 때문에 StaticMain은 생략 가능
		StaticInner i2 = new StaticInner();
		//iv는 인스턴스변수이기때문에 반드시 객체 생성
		//후 호출해야 함
		System.out.println(i2.iv);
		
		//static변수와 static메서드는 객체 생성 없이
		//호출
		System.out.println(StaticInner.cv);
		StaticInner.make();
		
	}
}



