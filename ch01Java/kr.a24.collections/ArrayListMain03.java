package kr.a24.collections;

import java.util.ArrayList;

public class ArrayListMain03 {
	public static void main(String[] args) {
		//제네릭 표현 : 객체를 생성할 때 저장할 수 있는
		//            요소의 타입 지정
		ArrayList<String> list = 
				new ArrayList<String>();
		list.add("홍길동");
		list.add("박문수");
		list.add("김유신");
		//객체 저장할 수 있는 데이터의 타입을 String
		//으로 한정했기 때문에 Integer 데이터 저장
		//불가
		//list.add(500);
		list.add("이순신");
		
		//반복문을 이용한 요소의 출력
		for(int i=0;i<list.size();i++) {
			//지정한 타입으로 데이터 반환
			String name = list.get(i);
			System.out.println(name);
		}
		
	}
}





