package kr.a21.lang;

import java.util.Scanner;

public class StringMain04 {
	public static void main(String[] args) {
		/*
		 * [실습]
		 * 입력받은 문자열을 한 문자씩 읽어서 역순으로
		 * 표시
		 * 
		 * [입력 예시]
		 * 문자열:hello (input.nextLine())
		 * 
		 * [출력 예시]
		 * olleh
		 */
		Scanner input = new Scanner(System.in);
		System.out.print("문자열:");
		String s = input.nextLine();
		
		for(int i=s.length()-1;i>=0;i--) {
			                //한 문자 반환
			System.out.print(s.charAt(i));
		}
		input.close();		
	}
}



