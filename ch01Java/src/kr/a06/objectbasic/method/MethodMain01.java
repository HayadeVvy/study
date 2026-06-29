package kr.a06.objectbasic.method;

public class MethodMain01 {
	//기본적인 메서드의 이해
	
	//외부에서 전달한 데이터를 가공하고 데이터를
	//반환하는 형태
	public int add(int a, int b) {
		return a + b;
	}
	
	//외부에서 전달한 데이터를 메서드 내에서 처리
	public void print(String str) {
		System.out.println(str);
	}
	
	//외부에서 전달한 데이터가 없고 반환하는 데이터도 
	//없음
	public void print2() {
		System.out.println("겨울");
	}
	
	public static void main(String[] args) {
		MethodMain01 method = 
				new MethodMain01();
		int result = method.add(5, 7);
		System.out.println("result = " + result);
		
		method.print("서울");
		method.print2();
		
	}
}





