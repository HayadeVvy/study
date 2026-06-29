package kr.a24.collections;

import java.util.Stack;

public class StackMain {
	public static void main(String[] args) {
		//스택(stack) : 후입선출 
		//             LIFO(Last-In First-Out) 
	    //             자료구조
		String[] array = 
			{"진달래","백합","개나리","벚꽃","장미"};
		
		Stack<String> stk = new Stack<String>();
		
		for(int i=0;i<array.length;i++) {
			stk.push(array[i]);//객체 저장
		}
		
		//요소의 목록 출력
		System.out.println(stk);
		
		//반복문을 이용한 요소의 출력
		//스택이 비어 있지 있는지 체크
		while(!stk.isEmpty()) {
			//스택에 저장된 객체를 꺼내고 스택에서 삭제
			System.out.print(stk.pop() + "\t");
		}
		System.out.println();
		System.out.println("-".repeat(20));
		
		System.out.println(stk);
		
	}
}




