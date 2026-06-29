package kr.a03.operation;

public class OperationMain03 {
	public static void main(String[] args) {
		System.out.println("===if~else===");
		
		java.util.Scanner input =
				new java.util.Scanner(System.in);
		
		System.out.print("정수 하나 입력:");
		int a = input.nextInt();
		if(a%2==1) {
			System.out.println("홀수이다.");
		}else {
			System.out.println("짝수이다.");
		}
		
		input.close();
		
	}
}
