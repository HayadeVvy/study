package kr.a03.operation;

public class OperationMain13 {
	public static void main(String[] args) {
		/*
		 * [실습]
		 * 월에 따라 계절을 출력하시오.
		 * input.nextInt()
		 * (3~5:봄, 6~8:여름, 9~11:가을, 12~2:겨울)
		 */
		java.util.Scanner input =
				new java.util.Scanner(System.in);
		System.out.print("월 입력:");
		int month = input.nextInt();
		
		switch(month) {
		case 3: case 4: case 5: 
			System.out.println("봄");break;
		case 6: case 7: case 8: 
			System.out.println("여름");break;
		case 9: case 10:case 11: 
			System.out.println("가을");break;
		case 1:case 2:case 12: 
			System.out.println("겨울");break;
		default: System.out.println("잘못된 월");
		}		
		
		input.close();
		
	}
	
	
	
	
	
	
}
