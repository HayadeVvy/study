package kr.a24.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class HashSetMain02 {
	public static void main(String[] args) {
		//로또 프로그램
		HashSet<Integer> hs = 
				new HashSet<Integer>();
		while(hs.size()<6) {
			//1~45 난수 발생
			Integer ir = 
					(int)(Math.random()*45)+1;
			//중복값을 허용하지 않음
			hs.add(ir);
		}
		//Set -> List
		List<Integer> list = 
				new ArrayList<Integer>(hs);
		
		//정렬
		Collections.sort(list);
		for(int num : list) {
			System.out.print(num + "\t");
		}
		
	}
}






