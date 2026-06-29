package kr.a26.innerclass;

class Outer2{
	private int x = 100;
	//멤버내부클래스
	class Inner2{
		private int y = 200;
		//내부클래스의 메서드에서 내부클래스를 감싸고
		//있는 클래스의 멤버변수 호출 가능
		public void make() {
			System.out.println("x = " + x);
			System.out.println("y = " + y);
		}
	}
}

public class MemberMain02 {
	public static void main(String[] args) {
		Outer2 ot = new Outer2();
		//멤버내부클래스를 객체로 생성
		Outer2.Inner2 oi = ot.new Inner2();
		oi.make();
	}
}


