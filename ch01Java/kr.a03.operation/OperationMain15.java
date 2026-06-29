package kr.a03.operation;

public class OperationMain15 {
	public static void main(String[] args) {
		System.out.println("===for문===");
		   //초기식;조건식;증감식
		for(int i=1;i<=5;i++) {
			System.out.println(i);
		}
		
		System.out.println("-".repeat(20));
		
		//수행문이 한 줄일 경우 {} 생략 가능
		for(int i=1;i<=5;i++)
			System.out.println(i);
		
		
	}
}
