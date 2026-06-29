package kr.a24.collections;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class HashMapMain02 {
	public static void main(String[] args) {
		String[] msg = 
			{"Berlin","Paris","Seoul",
					    "New York","London"};
		HashMap<Integer,String> map =
				new HashMap<Integer,String>();
		//반복문을 이용해서 요소 저장
		for(int i=0;i<msg.length;i++) {
			      //key,value
			map.put(i, msg[i]);
		}
		
		//HashMap에 저장된 요소의 목록
		System.out.println(map);
		System.out.println("-".repeat(20));
		
		//반복문을 이용해서 key와 value쌍으로 정보 구하기
		//Set<Integer> s = map.keySet();
		//Iterator<Integer> keys = s.iterator();
		Iterator<Integer> keys = 
				map.keySet().iterator();
		while(keys.hasNext()) {
			Integer key = keys.next();
			System.out.println(
				  key + ", " + map.get(key));
		}
	}
}









