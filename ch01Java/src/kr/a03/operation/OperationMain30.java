package kr.a03.operation;

public class OperationMain30 {
	public static void main(String[] args) {
		java.util.Scanner input = 
				new java.util.Scanner(System.in);
		int a = 0, total = 0;
		
		System.out.println(
			"0전까지 입력받은 정수로 합 구하기");
		
		do {
			total += a;
			System.out.print(
				"누적할 정수 데이터를 입력하세요!");
		}while((a = input.nextInt()) != 0);
		
		System.out.println("total = " + total);		
		
		input.close();
	}
}
