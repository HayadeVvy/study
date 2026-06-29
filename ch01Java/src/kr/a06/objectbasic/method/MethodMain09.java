package kr.a06.objectbasic.method;

public class MethodMain09 {
	//인자 전달 방식 : 값에 의한 호출
	public int increase(int n) {
		++n;
		return n;
	}
	
	public static void main(String[] args) {
		//변수 선언 및 초기화
		int var1 = 100;
		
		//객체 선언 및 생성
		MethodMain09 me = new MethodMain09();
		int var2 = me.increase(var1);
		
		System.out.println(
		       "var1 : " + var1 + "," 
		                 + "var2 : " + var2);
		
	}
}




