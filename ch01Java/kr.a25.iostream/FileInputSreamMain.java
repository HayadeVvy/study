package kr.a25.iostream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileInputSreamMain {
	public static void main(String[] args) {
		FileInputStream fis = null;
		int readbyte;
		byte[] readbyte2;
		try {
			fis = new FileInputStream("file.txt");
			//파일의 정보를 한 문자씩 읽어들여 아스키 코드로
			//반환
			/*
			while((readbyte=fis.read())!=-1) {
				System.out.print((char)readbyte);
			}
			*/
			
			//영문이외의 문자도 처리 가능
			readbyte2 = new byte[fis.available()];
			//파일로부터 읽어들인 데이터를 byte배열에 저장
			fis.read(readbyte2);
			                   //byte[] -> String
			System.out.println(new String(readbyte2));
			
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}finally {
			//자원정리
			if(fis!=null)try {fis.close();}
			          catch(IOException e) {}
		}
	}
}



