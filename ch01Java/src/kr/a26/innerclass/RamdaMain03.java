package kr.a26.innerclass;

@FunctionalInterface
interface MyFunctionalInterface2{
	public void method(int x);
}

@FunctionalInterface
interface MyFunctionalInterface3{
	public int make(int x, int y);
}

public class RamdaMain03 {
	public static void main(String[] args) {
		MyFunctionalInterface2 fi = (x) -> {
			int result = x * 5;
			System.out.println(result);
		};
		fi.method(10);
		System.out.println("-".repeat(20));
		
		MyFunctionalInterface3 fi2 = (x,y) -> {
			return x * y;
		};
		int result = fi2.make(5, 7);
		System.out.println(result);
		System.out.println("-".repeat(20));
		
		fi2 = (x,y) -> {return x * y;};
		result = fi2.make(2, 3);
		System.out.println(result);
		System.out.println("-".repeat(20));
		
		//return문만 있을 경우 중괄호 {}와 return문
		//생략 가능
		fi2 = (x,y) -> x + y;
		result = fi2.make(10, 2);
		System.out.println(result);
	}
}




