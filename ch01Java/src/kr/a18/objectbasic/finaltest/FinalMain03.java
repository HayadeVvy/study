package kr.a18.objectbasic.finaltest;

//클래스에 final를 명시하면 상속 불가능
final class Me2{
	public void play() {
		System.out.println("부모클래스의 play");
	}
}

//public class FinalMain03 extends Me2{
public class FinalMain03{
	public static void main(String[] args) {
		FinalMain03 f = new FinalMain03();
		//f.play();
	}
}


