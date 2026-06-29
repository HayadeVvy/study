package kr.a20.objectbasic.inter;

interface Inter1{
	public int getA();//추상메서드
}
interface Inter2{
	public int getB();
}
//인터페이스간 다중 상속
interface Inter3 extends Inter1,Inter2{
	public int getC();
}

interface Inter4{
	public int getD();
}

//클래스에 인터페이스를 다중 구현
public class InterMain03 
                   implements Inter3,Inter4{
	//인터페이스의 추상메서드 구현
	@Override
	public int getA() {
		return 10;
	}
	@Override
	public int getB() {
		return 20;
	}
	@Override
	public int getC() {
		return 30;
	}
	@Override
	public int getD() {
		return 40;
	}
	public static void main(String[] args) {
		InterMain03 it = new InterMain03();
		System.out.println(it.getA());
		System.out.println(it.getB());
		System.out.println(it.getC());
		System.out.println(it.getD());
	}
}


