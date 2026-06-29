package kr.a23.exception;

public class ExceptionMain08 {
	//throw 인위적 예외 발생
	public void methodA(String[] n)
			             throws Exception{
		if(n.length > 0) {
			for(String s : n) {
				System.out.println(s);
			}
		}else {
			//예외를 인위적으로 발생시킴
			throw new Exception(
					"입력한 데이터가 없습니다.");
		}
	}
	public static void main(String[] args) {
		ExceptionMain08 ex = 
				new ExceptionMain08();
		try {
			ex.methodA(args);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
