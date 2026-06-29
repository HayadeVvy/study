package kr.a02.operator;

public class OperatorMain19 {
	public static void main(String[] args) {
		//[실습]
		//간단한 은행 프로그램 
		//예금액을 입력받아서 잔고 출력,
		//출금액을 입력받아서 잔고 출력
		//입력 : input.nextInt()
		java.util.Scanner input = 
			 new java.util.Scanner(System.in);
		
		int balance = 0;//잔고
		
		//예금하기
		System.out.print("예금액:");
		//balance = balance + input.nextInt()
		balance += input.nextInt();//누적		
		//잔고 출력
		System.out.printf("잔고 : %,d원%n", balance);
		
		//출금하기
		System.out.print("출금액:");
		//balance = balance - input.nextInt();
		balance -= input.nextInt();//차감
		//잔고 출력
		System.out.printf("잔고 : %,d원%n", balance);
		
		input.close();
	}
}
