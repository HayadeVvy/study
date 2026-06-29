package kr.a24.collections;

import java.util.ArrayList;

public class ArrayListMain04 {
	public static void main(String[] args) {
		ArrayList<String> list = 
				new ArrayList<String>();
		list.add("강호동");
		list.add("유재석");
		list.add("박명수");
		list.add("홍길동");
		list.add("강호동");
		
		//반복문을 이용해서ArrayList의 요소 출력
		for(int i=0;i<list.size();i++) {
			String name = list.get(i);
			System.out.println(i + ":" + name);
		}
		System.out.println("-".repeat(20));
		
		//요소의 삭제
		//list.remove(2);//인덱스
		list.remove("강호동");//요소
		
		for(int i=0;i<list.size();i++) {
			String name = list.get(i);
			System.out.println(i + ":" + name);
		}
		System.out.println("-".repeat(20));
		
		ArrayList<Integer> list2 = 
				new ArrayList<Integer>();
		list2.add(40);
		list2.add(1);
		list2.add(3);
		list2.add(40);
		
		for(int i=0;i<list2.size();i++) {
			Integer num = list2.get(i);
			System.out.println(i + ":" + num);
		}
		System.out.println("-".repeat(20));
		
		//요소 삭제
		//list2.remove(2);//인덱스
		//list2.remove((Integer)40);//요소
		              //int -> Integer
		list2.remove(Integer.valueOf(40));//요소
		
		for(int i=0;i<list2.size();i++) {
			Integer num = list2.get(i);
			System.out.println(i + ":" + num);
		}
		System.out.println("-".repeat(20));
		
		//요소의 변경
		       //인덱스,데이터
		list2.set(1, 30);
		
		for(int i=0;i<list2.size();i++) {
			Integer num = list2.get(i);
			System.out.println(i + ":" + num);
		}
		System.out.println("-".repeat(20));
		
		//확장 for문을 이용한 요소의 출력
		for(Integer num : list2) {
			System.out.println(num);
		}
	}
}








