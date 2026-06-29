package kr.a25.iostream;

import java.io.File;

public class FileMain05 {
	public static void main(String[] args) {
		//String path = "C:\\javaWork\\javaSample";
		String path = "C:"+File.separator+"javaWork"
		                 +File.separator+"javaSample";
		
		File f1 = new File(path);
		
		System.out.println("==디렉토리 생성==");
		System.out.println(f1.mkdir());
		
		System.out.println("==디렉토리 삭제==");
		if(f1.delete()) {
			System.out.println(
					f1.getName()+" 디렉토리 삭제");
		}else {
			System.out.println(
					"디렉토리를 삭제할 수 없습니다.");
		}
		
		
	}
}




