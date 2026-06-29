package kr.a17.objectbasic.poly;

//부모클래스
class Parent2{
	public void make() {
		System.out.println("부모클래스의 make");
	}
}
//자식클래스
class Child2 extends Parent2{
	//메서드 재정의
	@Override
	public void make() {
		System.out.println("자식클래스의 make");
	}
}

public class PolyMain03 {
	public static void main(String[] args) {
		Child2 ch = new Child2();
		ch.make();
		
		System.out.println("-".repeat(20));
		
		//자식클래스타입 -> 부모클래스타입 형변환
		//업캐스팅, 자동적으로 형변환
		Parent2 p = ch;
		p.make();
		
	}
}




