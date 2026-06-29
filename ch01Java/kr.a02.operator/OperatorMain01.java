package kr.a02.operator;

public class OperatorMain01 {
	public static void main(String[] args) {
		System.out.println("===증감연산자===");
		
		//증가연산자
		int i=5;
		//1씩 증가
		System.out.println(++i);//6
		System.out.println(++i);//7
		
		System.out.println("-".repeat(20));
		
		//감소연산자
		int j=10;
		//1씩 감소
		System.out.println(--j);//9
		System.out.println(--j);//8
		
		System.out.println("-".repeat(20));
		
		//증가연산자
		int i2 = 5;
		System.out.println(i2++);//5
		System.out.println(i2);//6
		
		System.out.println("-".repeat(20));
		//감소연산자
		int j2 = 10;
		System.out.println(j2--);//10
		System.out.println(j2);//9
		
		
	}
}



