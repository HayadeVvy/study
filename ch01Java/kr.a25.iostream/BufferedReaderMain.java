package kr.a25.iostream;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class BufferedReaderMain {
	public static void main(String[] args) {
		BufferedReader br = null;
		try {
			//바이트스트림 -> 문자스트림 -> 한 라인의 데이터 처리
			br = new BufferedReader(new InputStreamReader(System.in));
			
			System.out.print("당신의 이름:");
			String name = br.readLine();
			System.out.println(name);
			
			System.out.print("당신의 나이:");
			int age = Integer.parseInt(br.readLine());
			System.out.println(age);
			
		}catch(NumberFormatException e) {
			System.out.println(
					    "숫자를 입력하세요");
		}catch(IOException e) {
			System.out.println("입력시 오류 발생");
		}finally {
			//자원정리
			if(br!=null)try {br.close();}
			           catch(IOException e) {}
		}
	}
}




