package kr.a02.operator;

public class OperatorMain20 {
	public static void main(String[] args) {
		//[실습]
		//조건(삼항)연산자
		//정수가 짝수인지 홀수인지 출력
		//num = 17
		int num = 17;
		String result = (num%2 == 0) ? "짝수" : "홀수";
		System.out.println(num + "=>" + result);
		
		//평균 60점이상이면 합격, 아니면 불합격을 출력하시오.
		//korean = 70, english = 55, math = 65
		int korean = 70;
		int english = 55;
		int math = 65;
		int average = (korean + english + math)/3;
		String result2 = (average >= 60) ? "합격" : "불합격";
		System.out.println(average + "=>" + result2);
		
	}
}





