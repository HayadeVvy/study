package kr.a04.array;

public class ArrayFirstMain06 {
	public static void main(String[] args) {
		//배열 선언 및 생성
		String[] array = new String[3];
		
		//배열에 문자열 저장
		array[0] = "Java";
		array[1] = "Oracle";
		array[2] = "HTML";
		
		//반복문을 이용한 배열의 요소 출력
		for(int i=0;i<array.length;i++) {
			System.out.print(array[i] + "\t");
		}
		
		System.out.println();
		System.out.println("-".repeat(20));
		
		//확장 for문을 이용한 출력
		for(String str : array) {
			System.out.print(str + "\t");
		}
		
	}
}




