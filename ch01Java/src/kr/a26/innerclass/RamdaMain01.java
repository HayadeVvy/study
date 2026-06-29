package kr.a26.innerclass;

interface MyInterface{
	public void make();
}

public class RamdaMain01 {
	
	public void play() {
		//익명내부클래스를 이용해서 익명 객체 생성
		MyInterface my = new MyInterface() {
			//인터페이스의 추상메서드를 구현
			@Override
			public void make() {
				System.out.println("익명 객체");
			}
		};
		my.make();
		
		System.out.println("-".repeat(20));
		
		//익명 객체를 람다(표현)식으로 변경
		//인터페이스로 구현된 익명 객체와 그 익명 객체가
		//하나의 메서드만 가질 경우 람다(표현)식으로
		//변경 가능 
		MyInterface my2 = () -> {
			System.out.println("람다식으로 표시");
		};
		my2.make();		
	}
	
	public static void main(String[] args) {
		RamdaMain01 r = new RamdaMain01();
		r.play();
	}
}



