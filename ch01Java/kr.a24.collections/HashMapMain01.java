package kr.a24.collections;

import java.util.HashMap;

public class HashMapMain01 {
	public static void main(String[] args) {
		//Map 구조 : key와 value의 쌍으로 저장
		//          key는 정렬 보장되지 않음
		HashMap<String,Integer> map = 
				new HashMap<String,Integer>();
		map.put("홍길동", 95);
		map.put("박문수", 100);
		map.put("장영실", 85);
		map.put("강호동", 93);
		map.put("유재석", 70);
		//key가 중복되면 마지막에 입력한 value를 인정
		map.put("장영실", 0);
		//HashMap은 key와 value에 null 인정
		map.put("김유신", null);
		map.put(null, 87);
		
		//저장된 key와 value의 목록
		System.out.println(map);
		System.out.println("-".repeat(20));
		
		//key를 이용해서 value 구하기
		Integer num = map.get("장영실");
		System.out.println(
				"장영실의 성적은 " + num);
		
	}
}



