package kr.a01.basic;

public class VariableTypeMain02 {
	public static void main(String[] args) {
		//확장 특수 출력 문자(escape sequence)
		
		//특수 문자 '를 일반 문자로 변환 \'
		char single = '\'';
		System.out.println(single);
		
		//특수 문자 "를 일반 문자로 변환 \"
		String str = "오늘은 \"화요일\" 입니다.";
		System.out.println(str);
		
		//문자열에 '를 표시하면 자동으로 일반 문자로 변환		
		String str2 = "내일은 '수요일' 입니다.";
		System.out.println(str2);
		
		//특수 문자 \를 일반 문자로 변환 \\
		String str3 = "C:\\javaWork";
		System.out.println(str3);
		
		// \n 줄바꿈
		String str4 = "여기는 서울\n저기는 부산";
		System.out.println(str4);
		
		// \t 일정 간격을 띄움
		String str5 = "이름\t나이\t취미";
		System.out.println(str5);
		
	}
}




