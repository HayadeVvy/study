package kr.a03.operation;

public class OperationMain33 {
	public static void main(String[] args) {
		//다중반복문에서 break 사용하기
		for(int i=0;i<3;i++) {
			for(int j=0;j<5;j++) {
				
				if(j == 3) {
					/*
					 * 특정 조건일 때 반복문을 
					 * 빠져나감
					 * 다중반복문일 때 전체 반복문을
					 * 빠져나가는 것이 아니라 break
					 * 가 포함되어 있는 반복문만 
					 * 빠져나감
					 */
					break;
				}
				
				System.out.println(
						  i + "," + j);
			}
		}
		
		System.out.println("-".repeat(20));
		//브레이크 레이블문 사용하기
		//다중반복문에서 특정 조건일 때 브레이크 레이블문을
		//사용하면 레이블문이 지정된 반복문을 빠져나갈 수 
		//있음
		exit_for: //레이블 설정
		for(int i=0;i<3;i++) {
			for(int j=0;j<5;j++) {
				
				if(j == 3) {
					//레이블이 지정된 for문 영역을
					//빠져나감
					break exit_for;
				}
				
				System.out.println(
						  i + "," + j);
			}
		}
		
	}
}
