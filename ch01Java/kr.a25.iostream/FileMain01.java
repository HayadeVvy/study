package kr.a25.iostream;

import java.io.File;

public class FileMain01 {
	public static void main(String[] args) {
		String path = "C:\\";
		
		File f = new File(path);
		
		if(!f.exists() || !f.isDirectory()) {
			System.out.println(
				"유효하지 않은 디렉토리입니다.");
			System.exit(0);
		}
		
		//지정한 디렉토리의 하위디텍토리와 파일에 
		//대한 정보를 File 배열에 반환
		File[] files = f.listFiles();
		
		for(int i=0;i<files.length;i++) {
			File f2 = files[i];
			//디렉토리 여부 체크
			if(f2.isDirectory()) {
				System.out.println(
						"["+f2.getName()+"]");
			}else {
				System.out.print(f2.getName());
				System.out.printf(
				  "(%,dbytes)%n", f2.length());
			}
		}
	}
}



