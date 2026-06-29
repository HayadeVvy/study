package kr.a06.objectbasic.method;

public class MethodMain02 {
	/*
	 * [실습]
	 * 입력한 int형 정수값이 음수이면 -1을 0이면0,
	 * 양수이면 1을 반환하는 signOf 메서드를 작성하시오.
	 */
	//멤버 메서드
	public int signOf(int n) {
		/*
		if(n>0) {
			return 1;
		}else if(n < 0) {
			return -1;
		}else {
			return 0;
		}
		*/
		int sign = 0;
		if(n > 0) {
			sign = 1;
		}else if(n < 0) {
			sign = -1;
		}
		return sign;
	}
	public static void main(String[] args) {
		java.util.Scanner input = 
				new java.util.Scanner(System.in);
		System.out.print("정수 입력:");
		int x = input.nextInt();
		
		MethodMain02 m = new MethodMain02();
		int result = m.signOf(x);
		
		System.out.println(
				"singOf(x)는 " + result);
		
		input.close();
	}
}


