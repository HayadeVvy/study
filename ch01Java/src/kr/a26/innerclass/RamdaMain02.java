package kr.a26.innerclass;

/*
 * 람다식을 사용하기 위한 조건
 * 인터페이스로 정의.
 * 추상메서드가 하나만 정의.
 * 인터페이스이며 추상메서드가 하나인 경우
 * 함수적 인터페이스(functional interface)라고 함
 */

//함수적 인터페이스인지 검증
@FunctionalInterface
interface MyFunctionalInterface{
	public void method();
	//public void play();
}

public class RamdaMain02 {
	public static void main(String[] args) {
		//람다식으로 익명 책체를 정의
		MyFunctionalInterface fi = () -> {
			System.out.println("method 실행");
		};
		fi.method();
		System.out.println("-".repeat(20));
		
		fi = () -> {System.out.println("method 실행2");};
		fi.method();
		System.out.println("-".repeat(20));
		
		//실행문이 하나라면 중괄호 {}는 생략 가능
		fi = () -> System.out.println("method 실행3");
		fi.method();
		
	}
}




