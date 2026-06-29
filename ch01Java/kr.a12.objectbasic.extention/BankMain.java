package kr.a12.objectbasic.extention;

import java.util.Scanner;

public class BankMain {
	public static void main(String[] args) {
		/*
		 * [실습]
		 * 1.Scanner 생성
		 * 2.while(true)
		 * 3.메뉴 : 1.계좌개설,2.입금,3.출금,
		 *         4.계좌정보보기,5.종료
		 *   1) BankAccount 생성
		 *   2) 입금(input.nextLong())
		 *   3) 출금(input.nextLong())
		 *   4) 계좌정보보기
		 *   5) 종료      
		 */
		BankAccount account = null;
		Scanner input = new Scanner(System.in);
		while(true) {
			System.out.println("-".repeat(30));
			System.out.println(
			"1.계좌 개설,2.입금,3.출금,4.계좌정보보기,5.종료");
			System.out.println("-".repeat(30));
			System.out.print("메뉴 선택>");
			int num = input.nextInt();
			
			if(num == 1) {
				if(account == null) {//계좌 미생성
					
					//계좌의 종류 선택(1.일반,2.마이너스)
					System.out.print(
						"계좌의 종류 선택(1.일반,2.마이너스)");
					int type = input.nextInt();
					
					System.out.print("계좌번호:");
					String number = input.next();
					System.out.print("예금주:");
					String name = input.next();
					System.out.print("잔고:");
					long balance = input.nextLong();
					
					if(type == 1) {
						//일반					
						account = new BankAccount(
						    		number,name,balance);
					}else {
						//마이너스
						//한도 입력
						System.out.print("한도:");
						long minusLimit = input.nextLong();
						//마이너스 계좌 생성
						account = new MinusAccount(number,name,
								     balance,minusLimit);
					}
				}
			}else if(num == 2) {
				if(account == null) {
					System.out.println("개설된 계좌가 없습니다.");
				}else {
					System.out.print("입금액:");
					account.deposit(input.nextLong());
				}
			}else if(num == 3) {
				if(account == null) {
					System.out.println("개설된 계좌가 없습니다.");
				}else {
					System.out.print("출금액:");
					account.withdraw(input.nextLong());
				}
			}else if(num == 4) {
				if(account == null) {
					System.out.println("개설된 계좌가 없습니다.");
				}else {
					account.printAccount();
				}
			}else if(num == 5) {
				System.out.println("프로그램 종료");
				break;
			}else {
				System.out.println("잘못 입력했습니다.");
			}			
		}
		input.close();
	}
}





