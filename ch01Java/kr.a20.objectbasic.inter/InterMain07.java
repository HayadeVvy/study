package kr.a20.objectbasic.inter;

interface RemoteControl{
	//정적 메서드
	//형태는 클래스의 정적 메서드와 완전히 동일함.
	//public 특성을 갖기 때문에 public을 생략
	//하더라도 자동적으로 컴파일 과정에서 붙게 됨
	static void chageBattery(){
		System.out.println("건전지를 교환합니다.");
	}
}

public class InterMain07 {
	public static void main(String[] args) {
		RemoteControl.chageBattery();
	}
}




