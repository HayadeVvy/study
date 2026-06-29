package kr.a18.objectbasic.finaltest;

//부모클래스
class Me{
	//메서드에 final를 지정하면 자식클래스에서 
	//메서드 오버라이딩을 할 수 없음
	public final void play() {
		System.out.println("부모클래스의 play");
	}
}

public class FinalMain02 extends Me{
	/*
	public void play() {
		System.out.println("자식클래스의 play");
	}
	*/
	
	public static void main(String[] args) {
		FinalMain02 f = new FinalMain02();
		f.play();
	}
}



