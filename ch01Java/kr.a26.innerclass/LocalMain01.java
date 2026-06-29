package kr.a26.innerclass;

public class LocalMain01 {
	//멤버메서드
	public void innerTest() {
		//로컬내부클래스
		class Inner {
			//멤버메서드
			public void getData() {
				System.out.println(
						"Local 내부클래스");
			}
		}
		//로컬내부클래스 객체 생성
		Inner i = new Inner();
		i.getData();
	}

	public static void main(String[] args) {
		LocalMain01 m = new LocalMain01();
		m.innerTest();
	}
}




