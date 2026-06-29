package kr.a03.operation;

public class OperationMain20 {
	public static void main(String[] args) {
		char c = 'a';
		for(int i=0;i<26;i++) {
			//a부터 26개의 문자를 출력
			System.out.print(c++);
		}
		
		System.out.println();//단순 줄바꿈
		
		c = 'A';
		for(int i=0;i<26;i++) {
			System.out.print(c++);
		}
		
		System.out.println();
		
		c = '0';
		for(int i=0;i<10;i++) {
			System.out.print(c++);
		}
		
	}
}




