package kr.a24.collections;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class AccountMain {
	/*
	 * [실습]
	 * 1.메뉴 : 1.계좌생성,2.입금,3.출금,4.계좌정보,5.종료
	 * 2.메서드 : 메뉴 -> callMenu()
	 *          계좌생성 -> register()
	 *          입금 -> deposit()
	 *          출금 -> withdraw()
	 *          계좌정보 -> printAccount()
	 *          
	 */
	private ArrayList<Account> list;
	private BufferedReader br;
	
	//생성자
	public AccountMain() {
		list = new ArrayList<Account>();
		try {
			br = new BufferedReader(
					new InputStreamReader(
							      System.in));
			callMenu();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(br!=null)try {br.close();}
			           catch(IOException e) {}
		}
	}
	//메뉴
	public void callMenu()throws IOException{
		while(true) {
			System.out.print(
			"1.계좌생성,2.입금,3.출금,4.계좌정보,5.종료:");
			try {
				int num = Integer.parseInt(
						          br.readLine());
				if(num == 1) {
					register();//계좌생성
				}else if(num == 2) {
					deposit();//입금
				}else if(num == 3) {
					withdraw();//출금
				}else if(num == 4) {
					printAccount();//계좌정보 보기
				}else if(num == 5) {
					System.out.println("프로그램 종료");
					break;
				}else {
					System.out.println("잘못 입력했습니다.");
				}
			}catch(NumberFormatException e) {
				System.out.println("숫자만 입력 가능");
			}
		}
	}
	
	//동일계좌 유무 체크
	public String checkSameAccount(String title)
			        		  throws IOException{
		boolean flag = true;
		String account = null;
		while(flag) {
			System.out.print(title);
			account = br.readLine();
			
			//루프를 빠져나감
			if(account.equals("q")) {
				return null;
			}
			if(list.size()==0) {
				break;
			}
			for(Account ac : list) {
				if(account.equals(ac.getAccount())) {
					System.out.println(
						"계좌가 이미 존재합니다.");
					flag = true;
					break;
				}else {
					flag = false;
				}
			}
		}
		return account;
	}
	
	//0이하의 숫자 체크
	public int checkDataInputed(String title)
	                     throws IOException{
		while(true) {
			System.out.print(title);
			try {
				int num = Integer.parseInt(
						      br.readLine());
				if(num<=0) {
					System.out.println(
						"0이하의 수를 입력할 수 없습니다.");
					continue;
				}
				return num;
			}catch(NumberFormatException e) {
				System.out.println(
						  "숫자만 입력 가능");
			}
		}
	}
	
	//계좌생성
	public void register()throws IOException{
		System.out.println("신규계좌를 개설합니다.");
		Account ac = new Account();
		
		ac.setAccount(
				checkSameAccount(
						"계좌번호(취소 q):"));
		//입력을 취소하는 경우
		if(ac.getAccount()==null) {
			return;
		}
		
		System.out.print("이름:");
		ac.setName(br.readLine());
		
		ac.setBalance(
				checkDataInputed("입금액:"));
		
		//Account를 ArrayList에 저장
		list.add(ac);
		
		System.out.println(
			ac.getName()
			+"님의 계좌가 개설되었습니다.");
		System.out.println("-".repeat(20));
	}
	
	//계좌검색
	public Account getSameAccount(String title)
	                        throws IOException{
		String account = null;
		while(true) {
			System.out.print(title);
			account = br.readLine();
			
			//루프를 빠져나감
			if(account.equals("q")) {
				return null;
			}
			
			for(Account ac : list) {
				if(account.equals(
						ac.getAccount())) {
					return ac;
				}
			}
			System.out.println(
				"동일 계좌가 존재하지 않습니다.");
		}
	}
	
	//입금하기
	public void deposit()throws IOException{
		System.out.println("입금합니다.");
		Account tac = 
				getSameAccount(
						"계좌번호 (취소 q):");
		if(tac == null) {
			return;
		}
		
		System.out.printf(
				"현재 잔고는 %,d원입니다.%n", 
				            tac.getBalance()); 
		
		tac.deposit(checkDataInputed("입금액:"));
		
		System.out.printf(
				"입금 후 잔고는 %,d원입니다.%n", 
				    tac.getBalance());		
	}
	
	//출금하기
	public void withdraw()throws IOException{
		System.out.println("출금합니다.");
		Account tac = 
			getSameAccount("계좌번호 (취소 q):");
		if(tac == null) {
			return;
		}
		
		System.out.printf(
				"현재 잔고 %,d원입니다.%n", 
				       tac.getBalance());
		
		tac.withdraw(checkDataInputed(
				               "출금액 :"));
		
		System.out.printf(
				"출금 후 잔고 %,d원입니다.%n", 
				       tac.getBalance());		
	}
	
	//계좌정보 보기
	public void printAccount()
			           throws IOException{
		Account tac = 
				getSameAccount(
						"계좌번호 (취소 q):");
		if(tac == null) {
			return;
		}
		tac.printAccount();
	}
	
	public static void main(String[] args) {
		new AccountMain();
	}
	
}






