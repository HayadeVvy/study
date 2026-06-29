package kr.a21.lang;

public class StringMain05 {
	public static void main(String[] args) {
		/*
		 * [실습]
		 * 문자 개수 세기
		 * 문자열에서 특정 문자의 개수를 세시오.
		 * Hello World에서 l의 개수
		 * 
		 * [출력 예시]
		 * 출력 : 3
		 */
		String str = "Hello World";
		char target = 'l';
		int count = 0;
		
		for(int i=0;i<str.length();i++) {
			if(str.charAt(i) == target) {
				count++;
			}
		}
		System.out.println("출력 : " + count);
		
		/*
		 * [실습]
		 * 중복 문자 제거
		 * hello에서 중복된 문자를 제거하시오.
		 * [출력 예시]
		 * helo
		 */
		String str2 = "hello";
		String result = "";
		
		for(int i=0;i<str2.length();i++) {
			char ch = str2.charAt(i);
			if(result.indexOf(ch)==-1) {
				result += ch;
			}
		}
		System.out.println(result);
		
		/*
		 * [실습]
		 * 가장 긴 단어 찾기
		 * Java is a programming language
		 * 문장에서 가장 긴 단어를 찾으시오.
		 * [출력]
		 * 출력 : programming
		 */
		String str3 
		  = "Java is a programming language";
		String[] words = str3.split(" ");
		String longest = "";
		for(int i=0;i<words.length;i++) {
			if(words[i].length()>longest.length()) {
				longest = words[i];
			}
		}
		System.out.println("출력 : " + longest);
		System.out.println("-".repeat(20));
		
		for(String word : words) {
			if(word.length()>longest.length()) {
				longest = word;
			}
		}
		System.out.println("출력 : " + longest);
		
		/*
		 * [실습]
		 * 변수에 저장된 문자열 중 대문자는 소문자로 변경하고
		 * 소문자(97~122)는 대문자(65~90)로 변경하시오.
		 */
		String str4 = "abcMDye-4W?EWzz";
		String result2 = "";
		
		for(int i=0;i<str4.length();i++) {
			char c = str4.charAt(i);
			if(c>=65 && c<=90) {//대문자
				result2 += (char)(c + 32);
			}else if(c>=97 && c<=122) {//소문자
				result2 += (char)(c - 32);
			}else {
				result2 += c;
			}
		}
		System.out.println(result2);
		System.out.println("-".repeat(20));
		
		String result3 = "";
		for(int i=0;i<str4.length();i++) {
			char c = str4.charAt(i);
			if(c>=65 && c<=90) {//대문자
				result3 += 
				  String.valueOf(c).toLowerCase(); 
			}else if(c>=97 && c<=122) {//소문자
				result3 += 
				  String.valueOf(c).toUpperCase();				
			}else {
				result3 += c;
			}//end of if
		}//end of for
		System.out.println(result3);
		System.out.println("-".repeat(20));
		
		String result4 = "";
		             //char배열로 반환
		for(char c : str4.toCharArray()) {
			if(Character.isUpperCase(c)) {//대문자
				result4 += Character.toLowerCase(c);
			}else if(Character.isLowerCase(c)) {//소문자
				result4 += Character.toUpperCase(c);				
			}else {
				result4 += c;
			}
		}
		System.out.println(result4);
	}
}




