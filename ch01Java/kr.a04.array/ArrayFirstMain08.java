package kr.a04.array;

public class ArrayFirstMain08 {
	public static void main(String[] args) {
		java.util.Scanner input = 
				new java.util.Scanner(System.in);
		//과목명을 저장하는 배열 생성
		String[] course = {"국어","영어","수학"};
		//성적을 저장하는 배열 생성
		int[] score = new int[course.length];
		int sum = 0;
		float avg = 0.0f;
		
		//반복문을 이용해서 입력 처리(과목수에 맞게 반복 처리)
		for(int i=0;i<score.length;i++) {
			do {
				System.out.print(course[i] + "=");
				score[i] = input.nextInt();
			}while(score[i] < 0 || score[i] > 100);
			
			//총점 구하기
			sum += score[i];			
		}
		//평균 구하기
		avg = sum / (float)course.length;
		
		System.out.println();//단순 줄바꿈
		
		//과목 성적 출력
		for(int i=0;i<score.length;i++) {
			System.out.printf(
				"%s = %d%n", course[i],score[i]);
		}
		
		//총점, 평균 출력
		System.out.printf("총점 = %d%n", sum);
		System.out.printf("평균 = %.2f", avg);		
		
		input.close();
	}
}



