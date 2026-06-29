package kr.a24.collections;

import java.util.ArrayList;

class A{
	@Override
	public String toString() {
		return "A클래스";
	}
}
class B{}

public class ArrayListMain01 {
	public static void main(String[] args) {
		ArrayList list = new ArrayList();
		//ArrayList에 객체 저장
		list.add(new A());//A -> Object
		list.add(new B());//B -> Object
		list.add("박문수");//String -> Object
		list.add(20);//Integer -> Object
		
		//ArrayList에 저장된 요소의 목록
		System.out.println(list);
		
	}
}






