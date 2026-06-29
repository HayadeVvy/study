package kr.a03.operation;

public class OperationMain25 {
	public static void main(String[] args) {
		java.util.Scanner input = 
				new java.util.Scanner(System.in);
		int a, total=0;
		
		while(true) {
			System.out.print("누적할 정수 입력>");
			a = input.nextInt();
			if(a==0) {
				break;//반복문을 빠져나감
			}
			total += a; //누적
		}
		
		System.out.println("total = " + total);		
		
		input.close();
	}
}



