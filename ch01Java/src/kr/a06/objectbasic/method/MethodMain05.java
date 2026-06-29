package kr.a06.objectbasic.method;

public class MethodMain05 {
	//배열이 인자로 전달되고 배열의 요소 중 최소값을
	//구하는 메서드
	public int minOf(int[] a) {
		int min = a[0];
		for(int i=1;i<a.length;i++) {
			if(a[i] < min) {
				min = a[i];
			}
		}
		return min;
	}
	
	public static void main(String[] args) {
		/*
		 * [실습]
		 * 배열 요소 수(사람 수)를 입력 받아서 배열
		 * weight 생성.
		 * 입력 받은 정수를 배열 weight에 저장하고
		 * 배열 weight가 가진 모든 요소의 수 중 
		 * 최소값을 구하는 minOf(int[] a) 메서드를 
		 * 작성하시오.
		 * 
		 */
		java.util.Scanner input = 
				new java.util.Scanner(System.in);
		System.out.print("사람 수:");
		int num = input.nextInt();
		
		int[] weight = new int[num];
		
		for(int i=0;i<num;i++) {
			System.out.print((i+1) + "번의 몸무게:");
			weight[i] = input.nextInt();
		}
		
		//객체 선언 및 생성
		MethodMain05 me = new MethodMain05();
		
		System.out.println(
			"가장 마른 사람의 몸무게는 " + me.minOf(weight));
		
		input.close();
	}
}




