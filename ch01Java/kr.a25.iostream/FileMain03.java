package kr.a25.iostream;

import java.io.File;

public class FileMain03 {
	public static void main(String[] args) {
		//상대경로 지정
		String now_path = "sample.txt";//원래 파일명
		String new_path = "example.txt";//새 파일명
		
		File f1 = new File(now_path);
		
		System.out.println("===파일명 변경===");
		File f2 = new File(new_path);
		//파일명을 변경할 수 있으면 파일명을 변경하고
		//true반환, 변경할 수 없을 경우 false 반환
		System.out.println(f1.renameTo(f2));
		
	}
}



