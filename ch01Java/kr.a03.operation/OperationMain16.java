package kr.a03.operation;

public class OperationMain16 {
	public static void main(String[] args) {
		for(int i=5;i>=1;i--) {
			System.out.print(i + "\t");
		}
		System.out.println();
		System.out.println("-".repeat(20));
		
		for(int i=0;i<=10;i+=2) {
			System.out.print(i + "\t");
		}
		System.out.println();
		System.out.println("-".repeat(20));
		
		for(int i=0;i<=10;i++) {
			if(i%2==0) {
				System.out.print(i + "\t");
			}
		}
		
	}
}



