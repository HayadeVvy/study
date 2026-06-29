package kr.a17.objectbasic.poly;

//부모클래스
class Car{
	public void drive() {
		System.out.println("주행");
	}
	public void stop() {
		System.out.println("멈춤");
	}
	public void getPower() {
		System.out.println("일반 자동차");
	}
}
//자식클래스
class FireEngine extends Car{
	public void getWater() {
		System.out.println("water!!");
	}
	//메서드 오버라이딩
	@Override
	public void getPower() {
		System.out.println("소방설비를 갖춘 자동차!");
	}
}

public class PolyMain04 {
	public static void main(String[] args) {
		FireEngine fe = new FireEngine();
		fe.drive();
		fe.stop();
		fe.getWater();
		fe.getPower();
		
		System.out.println("-".repeat(20));
		
		//자식클래스타입 -> 부모클래스타입 형변환
		//업캐스팅, 자동적으로 형변환
		Car c = fe;
		c.drive();
		c.stop();
		//호출범위를 벗어나서 호출 불가
		//c.getWater();
		c.getPower();//재정의된 메서드 호출
	}
}




