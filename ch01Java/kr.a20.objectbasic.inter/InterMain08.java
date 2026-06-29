package kr.a20.objectbasic.inter;

interface RemoteControl2{
	//추상메서드
	void turnOn();
	void turnOff();
	//디폴트 메서드는 인스턴스 메서드와 동일한데,
	//default 키워드 붙는다.디폴트 메서드는 
	//public 특성을 갖기 때문에 public을 
	//생략하더라도 자동적으로 컴파일 과정에 붙게 됨
	default void setMute(boolean mute) {
		if(mute) {
			System.out.println("무음 처리합니다");
		}else {
			System.out.println("무음 해제합니다.");
		}
	}
	
}
class Audio implements RemoteControl2{
	//인터페이스 추상메서드 구현
	@Override
	public void turnOn() {
		System.out.println("Audio를 켭니다.");
	}
	@Override
	public void turnOff() {
		System.out.println("Audio를 끕니다.");
	}
	//인터페이스의 default 메서드를 재정의
	@Override
	public void setMute(boolean mute) {
		if(mute) {
			System.out.println(
					"Audio를 무음 처리합니다.");
		}else {
			System.out.println(
					"Audio를 무음 해제합니다.");
		}
	}
}

public class InterMain08 {
	public static void main(String[] args) {
		Audio au = new Audio();
		au.turnOn();
		au.setMute(true);
		au.turnOff();
	}
}



