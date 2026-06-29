package kr.a17.objectbasic.poly;

class A{
	public void make() {
		System.out.println("make 메서드");
	}
}
class B extends A{
	public void play() {
		System.out.println("play 메서드");
	}
}

public class PolyMain02 {
	public static void main(String[] args) {
		B bp = new B();
		bp.make();
		bp.play();
		
		//자식클래스타입 -> 부모클래스타입 형변환
		//업캐스팅, 자동적으로 형변환
		A ap = bp;
		ap.make();
		//호출범위를 벗어나서 호출 불가
		//ap.play();
		
		//부모클래스타입 -> 자식클래스타입 형변환
		//다운캐스팅, 명시적으로 형변환
		B bp2 = (B)ap;
		bp2.make();
		bp2.play();
		
	}
}



