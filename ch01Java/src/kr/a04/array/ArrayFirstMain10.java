package kr.a04.array;

public class ArrayFirstMain10 {
	public static void main(String[] args) {
		//두 개의 숫자를 전달해서 연산하려고 했지만
		//문자열로 인식해서 문자열 연결
		System.out.println(args[0] + args[1]);
		
		//문자열을 숫자로 변환해서 연산
		//String -> int
		int num1 = Integer.parseInt(args[0]);
		int num2 = Integer.parseInt(args[1]);
		
		System.out.println(
				"합계 = " + (num1+num2));
		
	}
}




