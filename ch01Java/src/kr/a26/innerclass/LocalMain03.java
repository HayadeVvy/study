package kr.a26.innerclass;

public class LocalMain03 {
	public void innerTest(int a) {
		//로컬내부클래스
		class Inner{
			public void getData() {
				//로컬내부클래스에서 innerTest의
				//지역변수를 호출하면 자동으로 상수화
				//상수화되어서 변경 불가능
				//a = 500;
				
				System.out.println("a : " + a);
			}
		}
		//로컬내부클래스 객체 생성
		Inner i = new Inner();
		i.getData();
	}	
	
	public static void main(String[] args) {
		LocalMain03 m = new LocalMain03();
		m.innerTest(100);
	}
}



