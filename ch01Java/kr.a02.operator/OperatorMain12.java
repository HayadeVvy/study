package kr.a02.operator;

public class OperatorMain12 {
	public static void main(String[] args) {
		/*
		 * 논리곱(&&)
		 * 선조건   &&   후조건    결과
		 * true         true    true
		 * true         false   false
		 * false        미실행    false
		 * 
		 * 논리합(||)
		 * 선조건    ||   후조건    결과
		 * true          미실행    true
		 * false         true     true
		 * false         false    false
		 */
		
		//증감연산자,비교연산자,논리연산자
		int a, b;
		a = b = 10;
		
		boolean c = a++ >= ++b && ++a > b++;
		//          10      11
		//              false
		System.out.println("a = " + a);//11
		System.out.println("b = " + b);//11
		System.out.println("c = " + c);//false
		
		int d,e;
		d = e = 10;
		
		boolean f = ++d > e++ || d++ >= ++e;
		//           11    10
		//             true
		System.out.println("d = " + d);
		System.out.println("e = " + e);
		System.out.println("f = " + f);
	}
}





