package kr.a19.objectbasic.abs;

//추상클래스
abstract class AbsEx1{
	//추상메서드
	public abstract int getA();
	abstract public int getB();
	public void make() {
		System.out.println("AbsEx1의 make");
	}
}

//추상클래스
abstract class AbsEx2 extends AbsEx1{
	//추상메서드 구현
	@Override
	public int getA() {
		return 10;
	}
	//추상메서드
	public abstract int getC();
}

public class AbstractMain03 extends AbsEx2{
	//추상메서드 구현
	@Override
	public int getB() {
		return 20;
	}
	@Override
	public int getC() {
		return 30;
	}
	public static void main(String[] args) {
		AbstractMain03 ab = 
				new AbstractMain03();
		System.out.println(ab.getA());
		System.out.println(ab.getB());
		System.out.println(ab.getC());
	}
}







