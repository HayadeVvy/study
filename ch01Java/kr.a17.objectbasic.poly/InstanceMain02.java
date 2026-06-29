package kr.a17.objectbasic.poly;

//부모클래스
class Car2{
	public void drive() {
		System.out.println("운전하다");
	}
	public void stop() {
		System.out.println("정지하다");
	}
}
//자식클래스
class FireEngine2 extends Car2{
	public void water() {
		System.out.println("물을 뿌리다");
	}
}

public class InstanceMain02 {
	public static void main(String[] args) {
		FireEngine2 fe = new FireEngine2();
		
		//상속관계일 때 생성된 객체가 명시한 자료형을
		//사용할 수 있는지 체크
		if(fe instanceof FireEngine2) {
			System.out.println(
					"FireEngine2 객체입니다.");
		}
		if(fe instanceof Car2) {
			System.out.println(
					"Car2 객체입니다.");
		}
		if(fe instanceof Object) {
			System.out.println(
					"Object 객체입니다.");
		}
		System.out.println("-".repeat(20));
		
		Car2 c = new Car2();
		
		if(c instanceof FireEngine2) {
			System.out.println(
					"FireEngine2 객체입니다.");
		}
		if(c instanceof Car2) {
			System.out.println(
					"Car2 객체입니다.");
		}
		if(c instanceof Object) {
			System.out.println(
					"Object 객체입니다.");
		}
		
	}
}



