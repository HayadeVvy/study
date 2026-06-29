package kr.a24.collections;

import java.util.ArrayList;

public class ArrayListMain02 {
	public static void main(String[] args) {
		//List 구조의 특징 : 저장되는 순서 유지,
		//                 중복 저장 허용
		ArrayList list = new ArrayList();
		list.add("홍길동");//String -> Object
		list.add("박문수");
		list.add("김유신");
		list.add("장영실");
		
		//반복문을 이용한 요소의 출력
		for(int i=0;i<list.size();i++) {
			              //Object -> String
			String name = (String)list.get(i);
			System.out.println(name);
		}
		
	}
}




