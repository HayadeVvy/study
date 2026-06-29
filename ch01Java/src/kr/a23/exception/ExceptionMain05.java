package kr.a23.exception;

public class ExceptionMain05 {
	public static void main(String[] args) {
		//멀티catch
		try {
			            //String -> int
			int data1 = Integer.parseInt(args[0]);
			int data2 = Integer.parseInt(args[1]);
			int result = data1 + data2;
			
			System.out.println(
			 data1 + "+" + data2 + "=" + result);			
		}catch(ArrayIndexOutOfBoundsException | 
				         NumberFormatException e) {
			if(e instanceof 
				 ArrayIndexOutOfBoundsException) {
				System.out.println(
						"입력한 데이터가 없습니다.");
			}else if(e instanceof NumberFormatException) {
				System.out.println("숫자가 아닙니다.");
			}
		}
	}
}



