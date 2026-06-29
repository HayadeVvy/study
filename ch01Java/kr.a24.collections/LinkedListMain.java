package kr.a24.collections;

import java.util.LinkedList;

public class LinkedListMain {
	public static void main(String[] args) {
		//큐(queue) : 선입선출 
		//            FIFO(First-In First-Out) 
		//            자료구조
		String[] array = 
			{"서울","부산","대구","광주","인천"};
		
		LinkedList<String> st = 
				new LinkedList<String>();
		
		//반복문을 이용해서 요소 저장
		for(int i=0;i<array.length;i++) {
			st.offer(array[i]);//객체 저장
		}
		
		//요소의 목록 보기
		System.out.println(st);
		System.out.println("-".repeat(20));
		
		//반복문을 이용한 요소의 출력
		//큐에 저장된 첫 번째 요소를 검색
		while(st.peek()!=null) {
			//큐에 저장된 첫 번째 요소를 반환하고 큐에서 제거
			System.out.print(st.poll()+"\t");
		}
		System.out.println();
		System.out.println("-".repeat(20));
		System.out.println(st);
		
	}
}



