package kr.a04.array;

public class ArrayFirstMain13 {
	public static void main(String[] args) {
		/*
		 * [실습]
		 * 1. 배열에서 짝수의 개수를 세시오.
		 * array = {1,2,3,4,5,6,7,8,9,10};
		 * 출력 : 5
		 */
		int[] array = {1,2,3,4,5,6,7,8,9,10};
		int count = 0;
		for(int num:array) {
			if(num%2==0) {
				count++;
			}
		}
		System.out.println(count);
		System.out.println("-".repeat(20));
		/*
		 * 2.배열에서 양수만 출력하시오.
		 * array2 = {-3,5,-1,8,-7,12};
		 * 출력:5 8 12 
		 */
		int[] array2 = {-3,5,-1,8,-7,12};
		for(int num : array2) {
			if(num > 0) {
				System.out.print(num + "\t");
			}
		}
		System.out.println();
		System.out.println("-".repeat(20));
		/*
		 * 3.배열 요소 수정
		 * 배열의 모든 요소에 2를 곱한 결과를 출력하시오.
		 * array3 = {1,2,3,4,5};
		 * 출력 : 2 4 6 8 10
		 */
		int[] array3 = {1,2,3,4,5};
		for(int i=0;i<array3.length;i++) {
			array3[i] *= 2;
			System.out.print(array3[i] + "\t");
		}
	}
}



