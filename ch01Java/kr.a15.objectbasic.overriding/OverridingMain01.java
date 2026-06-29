package kr.a15.objectbasic.overriding;

//부모 클래스
class GrandParent{
	public String getCar() {
		return "구형 자동차";
	}
}
//자식 클래스
class Father extends GrandParent{
	//Method Overriding(메서드 재정의)
	//상속관계에서 자식클래스에 메서드를 재정의하면
	//부모 클래스의 메서드가 호출되는 것이 아니라
	//자식 클래스의 메서드가 호출됨
	public String getCar() {
		return "신형 자동차";
	}
}

class Uncle extends GrandParent{

}

public class OverridingMain01 {
	public static void main(String[] args) {
		Father ft = new Father();
		System.out.println(
				"아버지는 " + ft.getCar() + "를 좋아합니다.");

		Uncle uc = new Uncle();
		System.out.println(
				"삼촌은 " + uc.getCar() + "를 좋아합니다.");
	}
}




