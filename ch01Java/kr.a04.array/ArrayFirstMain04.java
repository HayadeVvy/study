package kr.a04.array;

public class ArrayFirstMain04 {
	public static void main(String[] args) {
		//배열 선언, 생성, 초기화
		int[] score = {79,88,91,33,100,55,95};
		//초기 기준값 설정
		int max = score[0];
		int min = score[0];
		
		for(int i=1;i<score.length;i++) {
			//최대값 구하기
			if(score[i] > max) {
				max = score[i];
			}
			//최소값 구하기
			if(score[i] < min) {
				min = score[i];
			}
		}
		//최대값, 최소값 출력
		System.out.println("최대값 : " + max);
		System.out.println("최소값 : " + min);
		
		
	}
}



