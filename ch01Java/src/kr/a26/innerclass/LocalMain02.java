package kr.a26.innerclass;

public class LocalMain02 {
	//멤버변수
	int a = 100;
	
	//멤버메서드
	public void innerTest() {
		//로컬내부클래스
		class Inner{
			//로컬내부클래스의 메서드에서 멤버변수
			//호출 가능
			public void getData() {
				System.out.println("변경 전 : " + a);
				System.out.println("-".repeat(20));
				
				a = 200;
				System.out.println("변경 후 : " + a);
			}
		}
		//메서드내에서 로컬내부클래스의 객체를 생성한 후
		//메서드 호출
		Inner i = new Inner();
		i.getData();
	}
	
	public static void main(String[] args) {
		LocalMain02 m = new LocalMain02();
		m.innerTest();
	}
}


