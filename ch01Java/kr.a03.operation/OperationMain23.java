package kr.a03.operation;

public class OperationMain23 {
	public static void main(String[] args) {
		/*
		 * [실습]
		 * 단을 입력 받아서 입력 받은 단의 
		 * 1부터 9까지의
		 * 구구단 출력
		 * while문 이용
		 */
		java.util.Scanner input = 
				new java.util.Scanner(System.in);
		System.out.print("단 입력:");
		int dan = input.nextInt();
		
		System.out.println(dan + "단");
		System.out.println("-".repeat(10));
		
		int i=1;//곱해지는 수
		while(i<=9) {
			System.out.println(
					dan + "*" + i + "=" + dan * i);
			i++;
		}	
		
		input.close();		
	}
}




