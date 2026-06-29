package kr.a02.operator;

public class OperatorMain05 {
	public static void main(String[] args) {
		//국어,영어,수학 점수를 입력하고 총점,평균을
		//구해서 출력
		java.util.Scanner input = 
				new java.util.Scanner(System.in);
		
		System.out.print("국어:");
		//입력된 정수를 변수에 대입
		int korean = input.nextInt();
		System.out.print("영어:");
		int english = input.nextInt();
		System.out.print("수학:");
		int math = input.nextInt();
		
		//총점 구하기
		int sum = korean + english + math;
		//평균 구하기
		//double avg = (double)sum / 3;
		double avg = sum / 3.0;
		
		System.out.printf("국어 = %d%n", korean);
		System.out.printf("영어 = %d%n", english);
		System.out.printf("수학 = %d%n", math);
		System.out.printf("총점 = %d%n", sum);
		System.out.printf("평균 = %.2f%n", avg);		
		
		input.close();
	}
}




