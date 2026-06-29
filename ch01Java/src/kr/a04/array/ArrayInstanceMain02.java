package kr.a04.array;

class Car{
	//은닉화
	private String color;
	private int speed;
	
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public int getSpeed() {
		return speed;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}
}

public class ArrayInstanceMain02 {
	/*
	 * [실습]
	 * Car 클래스
	 * 1) 멤버변수 : private 색깔(color),속도(speed)
	 * 2) 멤버메서드 : get/set
	 * 
	 * ArrayInstanceMain02 클래스
	 * 1) Car형 배열 생성, 배열의 길이를 3
	 * 2) Car 객체 생성, 
	 *    객체의 멤버 변수를 초기화 후 배열에 저장
	 * 3) 반복문을 이용해서 배열의 요소가 접근
	 *    객체의 멤버 메서드를 호출해서 정보 출력 
	 */
	
	public static void main(String[] args) {
		Car[] carArray = new Car[3];
		
		carArray[0] = new Car();
		carArray[0].setColor("검정색");
		carArray[0].setSpeed(100);
		
		carArray[1] = new Car();
		carArray[1].setColor("흰색");
		carArray[1].setSpeed(200);
		
		carArray[2] = new Car();
		carArray[2].setColor("회색");
		carArray[2].setSpeed(300);
		
		//반복문을 이용해서 배열의 요소 정보 출력
		for(int i=0;i<carArray.length;i++) {
			System.out.println(
				"색상 : " + carArray[i].getColor());
			System.out.println(
				"속도 : " + carArray[i].getSpeed());
			System.out.println("-".repeat(20));
		}
		
		System.out.println();//단순 줄바꿈
		
		//확장for문
		for(Car car : carArray) {
			System.out.println(
					"색상 : " + car.getColor());
			System.out.println(
					"속도 : " + car.getSpeed());
			System.out.println("-".repeat(20));
		}
		
	}
	
}




