package kr.a19.objectbasic.abs;

//일반적으로 추상클래스는 1개이상의 추상메서드를 정의함.
abstract class A2{
	private int x;
	//추상메서드(미구현 메서드)
	public abstract void make();
	public void setX(int x) {
		this.x = x;
	}
}

//자식클래스에 추상클래스 상속
class B2 extends A2{
	//부모클래스의 추상메서드는 반드시 구현
	@Override
	public void make() {
		System.out.println("make");
	}
}

public class AbstractMain02 {
	public static void main(String[] args) {
		B2 bp = new B2();
		bp.make();
	}
}


