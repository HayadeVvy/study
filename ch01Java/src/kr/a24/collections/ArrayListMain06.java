package kr.a24.collections;

import java.util.ArrayList;
import java.util.Collections;

public class ArrayListMain06 {
	public static void main(String[] args) {
		ArrayList<String> list = 
				new ArrayList<String>();
		list.add("머루");//0
		list.add("사과");//1
		list.add("앵두");//2
		list.add("자두");//3
		list.add("사과");//4
		//인덱스 탐색
		int index1 = list.indexOf("사과");
		System.out.println(
				"첫 번째 사과 : " + index1);
		
		int index2 = list.lastIndexOf("사과");
		System.out.println(
				"마지막 사과 : " + index2);
		
		int index3 = list.indexOf("망고");
		System.out.println("망고 : " + index3);
		
		boolean f1 = list.contains("머루");
		System.out.println("머루 : " + f1);
		
		System.out.println(list);
		System.out.println("-".repeat(20));
		
		//오름차순 정렬
		Collections.sort(list);
		System.out.println(list);
		
	}
}






