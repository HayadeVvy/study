package kr.a24.collections;

import java.util.HashSet;
import java.util.Iterator;

public class HashSetMain {
	public static void main(String[] args) {
		//HashSet:중복값 불허, 정렬을 보장하지 않음
		String[] str = 
			  {"Java","JSP","Java","Oralce"};
		HashSet<String> hs 
		            = new HashSet<String>();
		//반복문을 이용한 요소의 저장
		for(String n : str) {
			hs.add(n);//중복 불허
		}
		
		//HashSet에 저장된 요소의 목록
		System.out.println(hs);
		System.out.println("-".repeat(20));
		
		//Iterator 객체를 이용해서 요소의 출력
		Iterator<String> ir = hs.iterator();
		while(ir.hasNext()) {
			System.out.println(ir.next());
		}
		System.out.println("-".repeat(20));
		
		//확장 for문을 이용한 출력
		for(String s : hs) {
			System.out.println(s);
		}
		
	}
}




