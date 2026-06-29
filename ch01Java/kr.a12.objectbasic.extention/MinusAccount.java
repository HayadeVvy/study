package kr.a12.objectbasic.extention;

public class MinusAccount extends BankAccount{
	/*
	 * [실습]
	 * 1.한도를 의미하는 minusLimit 멤버 변수 정의
	 * 2.BankAccount를 상속 받는다.
	 * 3.생성자에서 number,name,balance,minusLimit
	 *   를 전달 받아서 멤버 변수에 저장
	 * 4.withdraw, printAccount 메서드 재정의
	 */
	private long minusLimit;
	//생성자
	public MinusAccount(String number,
			String name,long balance, 
			           long minusLimit) {
		super(number,name,balance);
		this.minusLimit = minusLimit;
	}
	//메서드 재정의
	@Override
	public void withdraw(long amount) {
		if(amount <= 0) {
			System.out.println(
				"0이하의 금액은 출금할 수 없습니다.");
			return;
		}
		if(balance + minusLimit < amount) {
			System.out.println(
				"한도 초과로 출금할 수 없습니다.");
			return;
		}
		balance -= amount;
		System.out.printf(
				"%,d원이 출금되었습니다.%n", amount);
	}
	
	@Override
	public void printAccount() {
		System.out.println(
			"(마이너스)계좌번호 : " + number);
		System.out.println("예금주 : " + name);
		System.out.printf(
				"잔고 : %,d원%n", balance);
		System.out.printf(
			"마이너스한도 : %,d원%n",minusLimit);
	}
	
}






