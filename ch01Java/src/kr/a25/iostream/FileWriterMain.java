package kr.a25.iostream;

import java.io.FileWriter;
import java.io.IOException;

public class FileWriterMain {
	public static void main(String[] args) {
		FileWriter fw = null;
		try {
			//덮어쓰기
			fw = new FileWriter("fileWriter.txt");
			
			String message = 
					   "안녕하세요!FileWriter 테스트";
			fw.write(message);
			fw.flush();
			
			System.out.println(
					"파일을 생성하고 내용을 기술합니다");			
			
		}catch(IOException e) {
			e.printStackTrace();
		}finally {
			//자원정리
			if(fw!=null)try {fw.close();}
			                catch(IOException e) {}
		}
		
	}
}




