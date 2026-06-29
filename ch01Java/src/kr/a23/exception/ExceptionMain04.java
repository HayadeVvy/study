package kr.a23.exception;

public class ExceptionMain04 {
	public static void main(String[] args) {
		int var = 50;
		//단일 catch문을 이용해서 다중 catch 효과 주기
		try {
			int data = Integer.parseInt(args[0]);
			System.out.println(var/data);
		}catch(Exception e) {
			if(e instanceof 
				ArrayIndexOutOfBoundsException) {
				System.out.println("입력한 데이터가 없습니다.");
			}else if(e instanceof NumberFormatException) {
				System.out.println("숫자가 아닙니다.");
			}else if(e instanceof ArithmeticException){
				System.out.println("0으로 나눌 수 없습니다.");
			}else {
				System.out.println("다른 예외는 여기로~~");
			}
		}
	}
}
