package kr.a03.operation;

public class OperationMain08 {
	public static void main(String[] args) {
		/*
		 * [실습]
		 * 2개의 정수와 연산자를 입력 받아서 
		 * 연산의 결과를 출력
		 * 
		 * [입력 예시]
		 * 첫 번째 수:5    input.nextInt()
		 * 연산자:+ (+,-,*,/,%) input.next()
		 * 두 번째 수:7    input.nextInt()
		 * 
		 * [출력 예시]
		 * 5 + 7 = 12
		 * 
		 * [힌트]
		 * if(operator.equals("+")){
		 * 	덧셈
		 * }
		 */
		
		java.util.Scanner input = 
				new java.util.Scanner(System.in);
		int result = 0;
		
		System.out.print("첫 번째 수:");
		int first = input.nextInt();
		
		System.out.print("연산자:");
		String operator = input.next();
		
		System.out.print("두 번째 수:");
		int second = input.nextInt();
		
		if(operator.equals("+")) {
			//덧셈
			result = first + second;
		}else if(operator.equals("-")) {
			//뺄셈
			result = first - second;
		}else if(operator.equals("*")) {
			//곱셈
			result = first * second;
		}else if(operator.equals("/")) {
			if(second!=0) {
				//나누셈 - 몫
				result = first / second;
			}else {
				System.out.println(
						"0으로 나눌 수 없습니다.");
				//프로그램 종료
				System.exit(0);
			}
			
		}else if(operator.equals("%")) {
			if(second!=0) {
				//나누셈 - 나머지
				result = first % second;
			}else {
				System.out.println(
						"0으로 나눌 수 없습니다.");
				//프로그램 종료
				System.exit(0);
			}
		}else {
			System.out.println("잘못된 연산자 입력");
			//프로그램 종료
			System.exit(0);
		}
		
		System.out.println();//단순 줄바꿈
		System.out.printf("%d %s %d = %d", 
				first,operator,second,result);		
		
		input.close();
	}
}



