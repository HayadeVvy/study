package kr.a06.objectbasic.method;

class Tv{
	//멤버 필드(속성)
	boolean power;//전원상태(on/off)
	int channel;//채널
	
	//멤버 메서드
	public void isPower() {//Tv를 켜거나 끄는 기능
		power = !power;
	}
	public void channelUp() {//채널을 높이는 기능
		++channel;
	}
	public void channelDown() {//채널을 낮추는 기능
		--channel;
	}
}

public class MethodMain06 {
	public static void main(String[] args) {
		//객체 선언 및 생성
		Tv t = new Tv();
		t.isPower();//Tv 켜기
		System.out.println(
			"Tv 실행 여부 : " + t.power);
		System.out.println(
				"현재 채널 : " + t.channel);
		System.out.println("-".repeat(20));
		
		//채널 변경
		t.channel = 7;
		System.out.println(
			"첫 번째 변경된 채널 : " + t.channel);
		System.out.println("-".repeat(20));
		
		//채널 변경
		t.channelDown();
		System.out.println(
			"두 번째 변경된 채널 : " + t.channel);
		System.out.println("-".repeat(20));
		
		t.isPower();//Tv 끄기
		System.out.println(
				"Tv 실행 여부 : " + t.power);
	}
}



