package kr.a11.objectbasic.thistest;

public class ThisMain03 {
	//생성자
	public ThisMain03() {
		//this() 호출 전에 수행문을 명시하면 오류 발생
		//System.out.println("생성자()");
		
		//생성자내에서 또 다른 생성자를 호출할 때
		//this를 사용
		this("바람");
		System.out.println("생성자()");
	}
	public ThisMain03(int a) {
		                  //int -> String
		this(String.valueOf(a));
	}
	public ThisMain03(String msg) {
		System.out.println(msg);
	}	
	public static void main(String[] args) {
		ThisMain03 tm = new ThisMain03();
		ThisMain03 tm2 = new ThisMain03(5000);
		ThisMain03 tm3 = new ThisMain03("자바");
		
	}
}


