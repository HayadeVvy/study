package kr.a03.operation;

public class OperationMain21 {
	public static void main(String[] args) {
		//while문은 조건 비교에 만족할 때만 수행문을
		//실행하는 반복문
		int i = 1;//초기값
		    //조건식
		while(i<=10) {
			                 //증감식
			System.out.println(i++);
		}
		
		System.out.println("-".repeat(20));
		
		int j = 10;
		while(j >= 0) {
			System.out.println(j--);
		}
		
	}
}



