package kr.a14.objectbasic.packtwo;

import kr.a13.objectbasic.packone.People;

public class AccessMain {
	public static void main(String[] args) {
		People p = new People();
		//private,같은 클래스에서만 호출 가능
		//System.out.println(p.a);
		
		//default,같은 패키지에서만 호출 가능
		//System.out.println(p.b);
		
		//proteced,상속관계이거나 같은 패키지에서만 호출 가능
		//System.out.println(p.c);
		
		//public,접근 제한이 없음
		System.out.println(p.d);
	}
}


