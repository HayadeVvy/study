package kr.a26.innerclass;

interface InterEx{
	//추상메서드
	public void input();
}

public class AnonymousMain02 {
	public void make() {
		//인터페이스를 구현한 익명내부클래스
		InterEx i = new InterEx() {
			//인터페이스의 추상메서드를 구현
			@Override
			public void input() {
				System.out.println(
						"구현된 input 메서드");
			}
		};
		i.input();//익명객체의 메서드 호출
	}
	
	public static void main(String[] args) {
		AnonymousMain02 an = 
				new AnonymousMain02();
		an.make();
	}
}




