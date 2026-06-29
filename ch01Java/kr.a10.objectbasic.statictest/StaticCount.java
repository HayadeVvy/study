package kr.a10.objectbasic.statictest;

public class StaticCount {
	int c;//인스턴스 변수 : 
	      //객체가 생성될 때 객체에 포함되는 변수
	
	//static(클래스) 변수
	//객체 생성과 무관하고, 호출되면 static 영역에 
	//변수가 생성
	static int count;
	
	//생성자
	public StaticCount() {
		c++;
		count++;
	}
}


