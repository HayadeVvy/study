package kr.a26.innerclass;

class Inner7{
	public void disp() {
		System.out.println("Inner7의 disp");
	}
}

public class AnonymousMain01 {
	public void make() {
		//익명내부클래스
		//클래스명이 없기 때문에 부모클래스명으로
		//객체 생성 및 클래스 정의를 합친 형태로
		//구현
		Inner7 i = new Inner7(){
			public void play() {
				System.out.println(
						"Inner6의 play");
			}
			@Override
			public void disp() {
				System.out.println(
						"자식클래스의 disp");
			}
		};
		//자료형이 Inner7이기 때문에 호출 범위를
		//벗어나 호출 불가
		//i.play();
		i.disp();
	}
	public static void main(String[] args) {
		AnonymousMain01 an = 
				new AnonymousMain01();
		an.make();
	}
}


