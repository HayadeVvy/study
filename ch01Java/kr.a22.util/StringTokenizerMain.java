package kr.a22.util;

import java.util.StringTokenizer;

public class StringTokenizerMain {
	public static void main(String[] args) {
		String source = "100,200,300";
		
		StringTokenizer st = 
				new StringTokenizer(source,",");//대상문자열,구분자
		
		//구분자로 잘라낸 문자열 존재 여부 체크
		while(st.hasMoreTokens()) {
			                    //잘려진 문자열 반환
			System.out.println(st.nextToken());
		}
		
		
	}
}
