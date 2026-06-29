package kr.a11.objectbasic.thistest;

class ThisTest{
	//은닉화
	private int a;
	
	public void setA(int a) {
		//멤버변수와 지역변수명이 동일할 경우
		//지역변수로 인식하기 때문에 멤버변수로
		//인식시키기 위해서 this 활용.
		//this.멤버변수
		//멤버변수=지역변수
		this.a = a;
	}
	
	public int getA() {
		return a;
	}
	
}

public class ThisMain02 {
	public static void main(String[] args) {
		ThisTest tt = new ThisTest();
		//a의 접근 지정자가 private이기 때문에
		//다른 클래스에서는 호출 불가
		//tt.a = 100;
		tt.setA(200);
		System.out.println(tt.getA());
	}
}



