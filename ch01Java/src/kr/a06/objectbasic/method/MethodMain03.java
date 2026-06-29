package kr.a06.objectbasic.method;

public class MethodMain03 {
	/*
	 * [실습]
	 * 1)배열의 요소의 수를 입력 받아서 int형 배열 x
	 *   생성
	 * 2)생성한 배열 x에 값을 입력
	 * 3)배열 x가 가진 모든 요소의 합을 구하는 
	 *   sumOf(int[] a) 메서드를 정의하시오.
	 *   
	 * [입력 예시]
	 * 요소의 수:3
	 * x[0]=1
	 * x[1]=2
	 * x[2]=3
	 * 
	 * [출력 예시]
	 * 모든 요소의 합은 6입니다.
	 */
	public int sumOf(int[] a) {
		int sum = 0;
		for(int i=0;i<a.length;i++) {
			sum += a[i];
		}
		return sum;
	}
	
	public static void main(String[] args) {
		java.util.Scanner input = 
				new java.util.Scanner(System.in);
		System.out.print("요소의 수:");
		int num = input.nextInt();
		//배열 선언 및 생성
		int[] x = new int[num];
		
		for(int i=0;i<num;i++) {//num == x.length
			System.out.print("x[" + i + "]:");
			x[i] = input.nextInt();
		}
		
		MethodMain03 me = new MethodMain03();
		
		System.out.println(
			"모든 요소의 합은 " + me.sumOf(x) + "입니다.");
		
		
		input.close();
	}
	
	
}




