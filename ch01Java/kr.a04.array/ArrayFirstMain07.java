package kr.a04.array;

public class ArrayFirstMain07 {
	public static void main(String[] args) {
		/*
		 * [실습]
		 * 1. 배열을 역순으로 출력하시오.
		 * array = {1,2,3,4,5}
		 * 출력 5 4 3 2 1
		 */
		int[] array = {1,2,3,4,5};
		for(int i=array.length-1;i>=0;i--) {
			System.out.print(array[i] + "\t");
		}
		
		System.out.println();
		System.out.println("-".repeat(20));
		
		/*
		 * 2.배열에서 특정 값이 있는지 확인하시오.
		 * array2 = {3,7,11,15,19}
		 * 찾는 값 : 11
		 * [출력] 찾았다(or 없다)
		 * 
		 */
		int[] array2 = {3,7,11,15,19};
		int target = 11;
		boolean found = false;
		
		for (int i=0;i<array2.length;i++) {
			if(array2[i] == target) {
				found = true;
				break;
			}
		}
		
		if(found) {
			System.out.println("찾았다");
		}else {
			System.out.println("없다");
		}
		
		System.out.println("-".repeat(20));
		
		/*
		 * 3. 특정 값의 인덱스 찾기
		 * 배열에서 특정 값의 인덱스를 찾으시오.
		 * array3 = {10,20,30,40,50}
		 * 찾는 값 : 30
		 * [출력 예시]
		 * 2
		 */
		int[] array3 = {10,20,30,40,50};
		int target2 = 30;
		int index = -1;
		
		for(int i=0;i<array3.length;i++) {
			if(array3[i] == target2) {
				index = i;
				break;
			}
		}
		
		System.out.println(index);
		
	}
}



