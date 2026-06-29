package kr.a23.exception;

public class ExceptionMain01 {
	public static void main(String[] args) {
		int[] array = {10,20,30};
		
		//테스트용으로 인덱스 3을 호출해서 예외를 발생
		//시킴
		//예외가 발생하면 예외가 발생한 지점에서
		//프로그램이 강제 종료
		for(int i=0;i<=array.length;i++) {
			System.out.println(
					"array["+i+"]:"+array[i]);
		}
		System.out.println("프로그램 끝!");
		
	}
}




