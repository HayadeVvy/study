package kr.a04.array;

public class ArrayFirstMain03 {
	public static void main(String[] args) {
		int sum = 0;//총점
		float average = 0.0f;//평균
		
		//배열 선언, 생성, 초기화
		int[] score = {100,88,88,100,90};
		
		//총점 구하기
		for(int i=0;i<score.length;i++) {
			sum += score[i];//누적
		}
		
		//평균 구하기
		average = sum / (float)score.length;
		
		System.out.printf("총점 : %d%n", sum);
		System.out.printf("평균 : %.2f", average);
		
	}
}






