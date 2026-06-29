package kr.a15.objectbasic.overriding;

//부모 클래스
class Mother{
	public String getLunch() {
		return "밥";
	}
}
//자식 클래스
class Son extends Mother{
	
}
class Daughter extends Mother{
	//메서드 재정의
	
	//@Override 어노테이션은 메서드 재정의 문법에
	//맞게 재정의가 되었는지를 검증, 문법에 맞게 
	//재정의되지 않으면 컴파일 오류가 발생
	@Override
	public String getLunch() {
		return "빵";
	}
}

public class OverridingMain02 {
	public static void main(String[] args) {
		Son s = new Son();
		System.out.println(
			"아들은 " + s.getLunch() +"을 먹는다.");
		
		Daughter d = new Daughter();
		System.out.println(
			"딸은 " + d.getLunch() +"을 먹는다.");
	}
}




