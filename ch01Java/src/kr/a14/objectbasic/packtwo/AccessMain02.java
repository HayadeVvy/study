package kr.a14.objectbasic.packtwo;

import kr.a13.objectbasic.packone.People;

public class AccessMain02 extends People{
	public static void main(String[] args) {
		AccessMain02 am = new AccessMain02();
		//private, 같은 클래스에서만 호출 가능
		//System.out.println(am.a);
		
		//default, 같은 패키지에서만 호출 가능
		//System.out.println(am.b);
		
		//protected, 같은 패키지가 아니어도 
		//상속관계이기 때문에 호출 가능
		System.out.println(am.c);
		
		//public, 접근 제한 없음
		System.out.println(am.d);
	}
}




