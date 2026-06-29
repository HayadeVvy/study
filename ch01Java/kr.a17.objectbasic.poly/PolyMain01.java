package kr.a17.objectbasic.poly;

//부모 클래스
class Parent{
	int a = 100;
}
//자식 클래스
class Child extends Parent{
	int b = 200;
}

public class PolyMain01 {
	public static void main(String[] args) {
		Child ch = new Child();
		System.out.println(ch.a);
		System.out.println(ch.b);
		
		//자식클래스타입->부모클래스타입 형변환
		//업캐스팅, 자동적으로 형변환
		Parent p = ch;
		System.out.println(p.a);
		//호출 범위를 벗어나 호출 불가
		//System.out.println(p.b);
		
		//부모클래스타입->자식클래스타입 형변환
		//다운캐스팅, 명시적으로 형변환
		Child ch2 = (Child)p;
		System.out.println(ch2.a);
		System.out.println(ch2.b);	
		
	}
}




