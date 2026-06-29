package kr.a24.collections;

import java.util.Enumeration;
import java.util.Hashtable;

public class HashtableMain {
	public static void main(String[] args) {
		Hashtable<String,String> h =
				new Hashtable<String,String>();
		h.put("name", "홍길동");
		h.put("age", "27");
		h.put("tel", "010-1234-5678");
		h.put("hobby", "축구");
		//key가 중복되면 마지막에 입력한 value가 인정
		h.put("name", "박문수");
		//key와 value에 null을 불허
		//h.put("address", null);
		//h.put(null, "학생");
		
		//저장된 요소의 목록
		System.out.println(h);
		System.out.println("-".repeat(20));
		
		String name = h.get("name");
		System.out.println(name);
		
		//반복문을 이용한 요소의 출력
		Enumeration<String> en = h.keys();
		while(en.hasMoreElements()) {
			String key = en.nextElement();
			System.out.println(
				"key : " + key 
				+ ", value : " + h.get(key));
		}
	}
}





