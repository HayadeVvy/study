package kr.a12.objectbasic.extention;

//부모 클래스
class A{
	int x = 100;
	private int y = 200;//은닉화
	
	public int getY() {
		return y;
	}
}
//자식 클래스
class B extends A{
	int z = 300;
}

public class ExtentionMain03 {
	public static void main(String[] args) {
		B bp = new B();
		System.out.println(bp.x);
		//private 멤버변수는 다른 클래스에서 호출 불가능
		//System.out.println(bp.y);
		System.out.println(bp.getY());
		System.out.println(bp.z);
	}
}




