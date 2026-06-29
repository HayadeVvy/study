package kr.a04.array;

public class ArraySecondMain02 {
	public static void main(String[] args) {
		//5행3열의 2차원 배열 생성
		int[][] score = {
				         {98,99,97},
				         {94,95,88},
				         {88,77,99},
				         {93,95,91},
				         {96,95,99}
		                };
		System.out.println("번호 국어 영어 수학 총점 평균");
		System.out.println("=".repeat(20));
		
		for(int i=0;i<score.length;i++) {//i:행번호
			int sum = 0;
			System.out.print(" " + (i + 1) + " ");
			for(int j=0;j<score[i].length;j++) {//j:열번호
				//총점 구하기
				sum += score[i][j];
				//과목 점수 출력
				System.out.print(score[i][j] + " ");
			}
			//총점 출력, 평균을 구하고 출력
			System.out.println(sum + " " + sum/score[i].length);
		}
		
	}
}


