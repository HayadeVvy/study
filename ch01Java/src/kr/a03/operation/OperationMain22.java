package kr.a03.operation;

public class OperationMain22 {
	public static void main(String[] args) {
		int sum = 0, su = 1;
		      //조건식
		while(su <= 100) {
			sum += su;//누적
			su++; //증감식
		}
		
		System.out.println(
				"1부터 100까지의 합:" + sum);
		
	}
}
