package kr.a12.objectbasic.extention;

public class BankAccount {
	/*
	 * [실습]
	 * 1.멤버변수 : protected - 계좌번호(number),
	 *            예금주(name), 잔고(balance)
	 * 2.생성자를 통해서 계좌번호,예금주,잔고 셋팅
	 *   "1234(계좌번호) 계좌가 개설되었습니다."  
	 * 3.멤버 메서드
	 *    1) 입금하기 : deposit(long amount)
	 *    2) 출금하기 : withdraw(long amount)
	 *    3) 계좌정보 출력 : printAccount()          
	 */
	protected String number;
	protected String name;
	protected long balance;
	
	//생성자
	public BankAccount(String number, 
			            String name,
			            long balance) {
		this.number = number;
		this.name = name;
		this.balance = balance;
	}
	//입금하기
	public void deposit(long amount) {
		if(amount <= 0) {
			System.out.println(
			"0이하의 금액은 입금할 수 없습니다.");
			return;
		}
		balance += amount;
		System.out.printf(
				"%,d원이 입금되었습니다.%n",amount);
	}
	//출금하기
	public void withdraw(long amount) {
		if(amount <= 0) {
			System.out.println(
				"0이하의 금액은 출금할 수 없습니다.");
			return;
		}
		if(balance < amount) {
			System.out.println("잔액이 부족합니다.");
			return;
		}
		balance -= amount;
		System.out.printf(
			"%,d원이 출금되었습니다.%n", amount);
	}
	//계좌정보 출력
	public void printAccount() {
		System.out.println(
				"(일반)계좌번호: " + number);
		System.out.println("예금주 : " + name);
		System.out.printf(
				"잔고 : %,d원%n", balance);
		System.out.println("-".repeat(20));
	}
	
}


