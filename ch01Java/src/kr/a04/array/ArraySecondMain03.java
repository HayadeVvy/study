package kr.a04.array;

public class ArraySecondMain03 {
	public static void main(String[] args) {
		java.util.Scanner input =
				new java.util.Scanner(System.in);
		//과목명
		String[] course = {"국어","영어","수학"};
		//인원수(행의 길이)
		System.out.print("인원수:");
		int num = input.nextInt();
		//점수가 저장될 2차원 배열
		                    // 인원수    과목수
		                    //행의 길이   열의 길이
		int[][] score = new int[num][course.length];
		//총점
		int[] sum = new int[num];
		//평균
		float[] avg = new float[num];
		
		//성적을 입력 받고 총점과 평균 구하기
		for(int i=0;i<score.length;i++) {//i:행번호
			for(int j=0;j<score[i].length;j++) {//j:열번호
				//성적을 입력 받음
				do {
					//과목명 출력
					System.out.print(course[j] + "=");
					score[i][j] = input.nextInt();
				}while(score[i][j] < 0 || score[i][j] > 100);
				//총점 구하기
				sum[i] += score[i][j];
			}//end of inner for
			
			//평균 구하기
			avg[i] = sum[i]/(float)score[i].length;//=course.length
			
			System.out.println();//단순 줄바꿈
		}//end of outer for
		
		//총점과 평균 출력
		for(int i=0;i<num;i++) {
			System.out.println();//단순 줄바꿈
			System.out.printf(
					"총점 = %d%n", sum[i]);
			System.out.printf(
					"평균 = %.2f%n", avg[i]);
			System.out.println("-".repeat(15));
		}		
		input.close();
	}
}


