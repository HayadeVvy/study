package kr.a25.iostream;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class BufferedWriterMain {
	public static void main(String[] args) {
		FileWriter fw = null;
		BufferedWriter bw = null;
		try {
			fw = new FileWriter(
					"bufferedWriter.txt");
			bw = new BufferedWriter(fw);
			bw.write("BufferedWriter 테스트입니다.");
			bw.newLine();//줄바꿈
			bw.write("안녕하세요\n여기는 서울입니다.\n");
			bw.write("저기는 부산입니다." + 
			    System.getProperty("line.separator")
			         + "하하 호호");
			bw.flush();
			
			System.out.println(
					"파일을 생성하고 내용을 기술했습니다.");
		}catch(IOException e) {
			e.printStackTrace();
		}finally {
			//자원정리
			if(bw!=null)try {bw.close();}
			              catch(IOException e) {}
			if(fw!=null)try {fw.close();}
		                  catch(IOException e) {}
		}
	}
}







