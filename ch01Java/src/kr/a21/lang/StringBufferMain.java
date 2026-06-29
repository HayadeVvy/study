package kr.a21.lang;

public class StringBufferMain {
	public static void main(String[] args) {
		StringBuffer sb = 
				new StringBuffer("여름 덥다!!");
		System.out.println("1:" + sb);
		
		sb.insert(2, '이');//지정한 인덱스에 문자 삽입
		System.out.println("2:" + sb);
		
		//기존에 문자열 뒤에 문자열 추가
		sb.append("가을은 ");
		System.out.println("3:" + sb);
		
		sb.append("시원하다");
		System.out.println("4:" + sb);
		
		//시작 인덱스부터 끝 인덱스전까지 문자열 대체
		sb.replace(0, 3, "여행가자!");
		System.out.println("5:" + sb);
		
		sb.deleteCharAt(0);//지정한 인덱스의 문자 삭제
		System.out.println("6:" + sb);
		
		//시작 인덱스부터 끝 인덱스전까지 문자열 삭제
		sb.delete(0, 3);
		System.out.println("7:" + sb);
		
		//StringBuffer -> String
		String str = sb.toString();
		System.out.println(str);
		
	}
}




