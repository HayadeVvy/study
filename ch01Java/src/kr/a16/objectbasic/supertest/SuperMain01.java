package kr.a16.objectbasic.supertest;

//부모 클래스
class Mother{
	public String getLunch() {
		return "밥";
	}
}
//자식 클래스
class Daughter extends Mother{
	//메서드 오버라이딩
	@Override
	public String getLunch() {
		return "빵";
	}
	public String getRice() {
		//부모 클래스의 getLunch메서드를 호출
		return super.getLunch();
	}
}

public class SuperMain01 {
	public static void main(String[] args) {
		Daughter d = new Daughter();
		System.out.println(
			"딸은 " + d.getLunch() + "을 먹습니다.");
		System.out.println(
			"딸은 오늘은 왠지 " + d.getRice() 
			+ "이 먹고 싶어졌습니다!");
	}
}



