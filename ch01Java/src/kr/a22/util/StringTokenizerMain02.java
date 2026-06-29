package kr.a22.util;

import java.util.StringTokenizer;

public class StringTokenizerMain02 {
	public static void main(String[] args) {
		String source = "2025-01-19 16:48:30";
		
		//여러개의 구분자 지정 가능
		StringTokenizer st = 
				new StringTokenizer(
						source,"- :");
		
		while(st.hasMoreTokens()) {
			System.out.println(st.nextToken());
		}
		
	}
}
