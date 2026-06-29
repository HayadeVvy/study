package kr.a39.shop;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ShopUserMain {
	private BufferedReader br;
	private ShopDAO dao;
	private String cust_id;//로그인한 회원 아이디
	private boolean login;//로그인 여부(로그인:true,로그아웃:false)
	
	public ShopUserMain() {
		try {
			br = new BufferedReader(
					new InputStreamReader(
							     System.in));
			dao = new ShopDAO();
			callMenu();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			//자원정리
			if(br!=null)try {br.close();}
			           catch(IOException e) {}
		}
	}
	
	//메뉴
	private void callMenu()throws IOException{
		while(true) {
			System.out.print("1.로그인,2.회원가입,3.종료>");
			try {
				int no = Integer.parseInt(br.readLine());
				if(no == 1) {//로그인
					System.out.print("아이디(입력취소:0):");
					cust_id = br.readLine();
					
					//0이면 입력 취소
					if(cust_id.equals("0")) continue;
					
					System.out.print("비밀번호:");
					String me_passwd = br.readLine();
					
					login = dao.loginCheck(cust_id, 
							               me_passwd);
					if(login) {
						System.out.println(
							cust_id + "님 로그인 되었습니다.");
						break;
					}
					System.out.println(
							"아이디 또는 비밀번호가 불일치합니다.");
				}else if(no == 2) {//회원가입
					System.out.print("아이디(입력취소:0):");
					String cust_id = br.readLine();
					//0이면 입력 취소
					if(cust_id.equals("0")) continue;
					
					//아이디 중복 체크
					int check = dao.checkId(cust_id);
					if(check == 1) {
						System.out.println(
								"아이디가 중복되었습니다.");
					}else if(check == 0) {
						//아이디가 중복되지 않은 경우
						//회원 가입
						System.out.print("비밀번호:");
						String cust_passwd = br.readLine();
						System.out.print("이름:");
						String cust_name = br.readLine();
						System.out.print("주소:");
						String cust_address = br.readLine();
						System.out.print("전화번호:");
						String cust_tel = br.readLine();
						
						dao.insertCustomer(cust_id, 
							cust_passwd, cust_name, 
							cust_address, cust_tel);					
					}else {
						System.out.println(
								"아이디 중복 체크 오류 발생");
					}					
				}else if(no == 3) {//종료
					System.out.println("프로그램 종료");
					break;
				}else {
					System.out.println("잘못 입력했습니다.");
				}
			}catch(NumberFormatException e) {
				System.out.println("잘못 입력했습니다.");
			}
		}//end of while
		//로그인시 보여지는 메뉴
		while(login) {
			System.out.print(
			"1.회원 정보,2.상품 구매,3.구매 내역,4.종료>");
			try {
				int no = Integer.parseInt(
						           br.readLine());
				if(no == 1) {//회원 정보
					dao.selectDetailCustomer(cust_id);
				}else if(no == 2) {//상품 구매
					
				}else if(no == 3) {//구매 내역
					
				}else if(no == 4) {//종료
					//종료
					System.out.println("프로그램 종료");
					break;
				}else {
					System.out.println(
							"잘못 입력했습니다.");
				}
			}catch(NumberFormatException e) {
				System.out.println("[숫자만 입력 가능]");
			}
		}//end of while
	}
	
	public static void main(String[] args) {
		new ShopUserMain();
	}
}
