package kr.a23.exception;

public class ExceptionMain07 {
	public static void main(String[] args) {
		//try~catch~finally
		//finally 영역은 예외가 발생하든 발행하지 않든
		//무조건 수행하는 부분
		System.out.println(
				"===예외가 발생하지 않는 경우===");
		try {
			System.out.println("1");
			System.out.println("2");
		}catch(Exception e) {
			System.out.println("3");
		}finally {
			System.out.println("4");
		}
		System.out.println("-".repeat(20));
		
		System.out.println(
				"===예외가 발생하는 경우===");
		try {
			System.out.println("1");
			System.out.println(10/0);
			System.out.println("2");
		}catch(Exception e) {
			System.out.println("3");
		}finally {
			System.out.println("4");
		}
	}
}






