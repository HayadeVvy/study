package kr.a01.basic;

public class VariableMain01 {
	public static void main(String[] args) {
		//변수(Variable)는 값을 저장할 수 있는 메모리의 공간
		
		//변수 선언
		int num;
		
		//변수의 초기화
		num = 17;
		
		//변수의 값 출력
		System.out.println(num);
		
		System.out.println("-".repeat(20));
		
		//변수 선언, 초기화
		int number = 20;
		
		//출력
		System.out.println(number);
		
		System.out.println("-".repeat(20));
		
		//데이터 변경
		number = 40;
		
		//출력
		System.out.println(number);
		
		System.out.println("-".repeat(20));
		
		//주의사항
		//동일한 변수명으로 변수를 선언하면 오류 발생
		//int number = 30;
		
		//동일한 자료형을 사용하기 때문에 두 번째 변수명
		//앞의 자료형은 생략함.
		int a = 10, b = 20;
		int result = a + b;
		
		System.out.println(result);
		System.out.printf("result = %d%n", result);
		
		/*
		 * + : 연산
		 * 숫자 + 숫자
		 * 
		 * + : 연결
		 * 
		 * -> 문자열과 숫자를 연결해서 새로운 문자열 생성
		 * 문자열 + 숫자 
		 * 숫자 + 문자열
		 * 
		 * -> 문자열과 문자열을 연결해서 새로운 문자열 생성
		 * 문자열 + 문자열
		 */
		
		System.out.println("result = " + result);
		
		System.out.println("-".repeat(20));
		
		//주의사항
		// + 연산자를 사용할 때 문자열과 함께 사용하면
		//연산를 하는 것이 아니라 연결 작업을 수행하기
		//때문에 최우선적으로 연산을 하려면 () 활용
		System.out.println("결과 : " + a + b);
		System.out.println("결과 : " + (a + b));
		
		//변수 선언
		int no;
		
		//변수 선언 후 출력 또는 연산하기 전에 반드시
		//초기화를 해야 함.
		//System.out.println(no);
	}
}






