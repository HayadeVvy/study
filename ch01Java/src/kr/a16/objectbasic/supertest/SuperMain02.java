package kr.a16.objectbasic.supertest;

//부모 클래스
class Parent{
	public void play() {
		System.out.println(
				"Parent의 play 메서드");
	}
}
//자식 클래스
class Child extends Parent{
	
	//생성자
	public Child() {
		//부모 클래스의 play 호출
		super.play();
		System.out.println("-".repeat(20));
	}
	
	//메서드 재정의
	@Override
	public void play() {
		System.out.println(
				"Child의 play 메서드");
	}
}

public class SuperMain02 {
	public static void main(String[] args) {
		Child ch = new Child();
		ch.play();
	}
}





