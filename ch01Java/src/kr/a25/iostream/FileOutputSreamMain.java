package kr.a25.iostream;

import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputSreamMain {
	public static void main(String[] args) {
		FileOutputStream fos = null;
		try {
			//파일 생성
			//덮어쓰기
			//fos = new FileOutputStream("fileOut.txt");
			
			//이어쓰기
			fos = new FileOutputStream(
					     "fileOut.txt",true);
			
			String message = 
				"Hello File! 파일에 내용 기술";
			         //String -> byte[]
			fos.write(message.getBytes());
			
			System.out.println(
				"파일을 생성하고 내용을 기술했습니다.");
			
		}catch(IOException e) {
			e.printStackTrace();
		}finally {
			if(fos!=null)try {fos.close();}
			           catch(IOException e) {}
		}
	}
}




