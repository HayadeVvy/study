package kr.a24.collections;

public class Account {
	/*
	 * [실습]
	 * 1.멤버변수 : private - 계좌번호(account),
	 *            고객이름(name),잔고(balance)
	 * 2.멤버메서드 : get/set
	 *             예금하기(deposit(int amount)
	 *             출금하기(withdraw(int amount)
	 *             계좌정보출력(printAccount)
	 */
	private String account; //계좌번호
	private String name;//고객명
	private int balance;//잔고
	
	//예금하기
	public void deposit(int amount) {
		balance += amount;
		System.out.println(
				"입금이 완료되었습니다.");
	}
	
	//출금하기
	public void withdraw(int amount) {
		if(balance < amount) {
			System.out.println(
				"잔고 부족으로 출금할 수 없습니다.");
			return;
		}
		balance -= amount;
		System.out.println(
				"출금이 완료되었습니다.");
	}
	//계좌정보 보기
	public void printAccount() {
		System.out.println("계좌번호 : " + account);
		System.out.println("고객이름 : " + name);
		System.out.println("잔고 : " + balance);
	}
	
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
}



