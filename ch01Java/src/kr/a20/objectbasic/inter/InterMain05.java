package kr.a20.objectbasic.inter;

interface InterP{
	public abstract void make();//추상메서드
}
//클래스에 인터페이스 구현
class Child implements InterP{
	@Override
	public void make() {
		System.out.println("make 메서드");
	}
	public void play() {
		System.out.println("play 메서드");
	}
}

public class InterMain05 {
	public static void main(String[] args) {
		Child ch = new Child();
		ch.make();
		ch.play();
		
		//클래스타입 -> 인터페이스타입 형변환
		//자동적으로 형변환
		InterP i = ch;
		i.make();
		//호출 범위를 벗어나서 호출 불가
		//i.play();
		
		//인터페이스타입 -> 클래스타입 형변환
		//명시적 형변환
		Child ch2 = (Child)i;
		ch2.make();
		ch2.play();
		
		
	}
}




