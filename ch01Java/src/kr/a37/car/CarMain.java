package kr.a37.car;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CarMain {
	private BufferedReader br;
	private CarDAO dao;
	
	public CarMain() {
		try {
			br = new BufferedReader(
					new InputStreamReader(
							    System.in));
			dao = new CarDAO();
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
			System.out.print(
				"1.자동차정보등록,2.목록보기,3.상세정보,4.정보수정,5.정보삭제,6.종료>");
			try {
				int no = Integer.parseInt(
						         br.readLine());
				if(no == 1) {//자동차정보등록
					System.out.print("이름:");
					String name = br.readLine();

					System.out.print("색상:");
					String color = br.readLine();

					System.out.print("제조사:");
					String maker = br.readLine();

					int price = parseInputData("가격:");

					//NoteDao의 insertInfo메서드를 호출해서
					//입력받은 데이터 전달
					dao.insertCar(name, color, 
							            maker, price);
				}else if(no == 2) {//목록보기
					dao.selectCar();
				}else if(no == 3) {//상세정보
					dao.selectCar();
					
					System.out.print("선택한 자동차 관리 번호:");
					int num = Integer.parseInt(br.readLine());
					dao.selectDetailCar(num);
				}else if(no == 4) {//정보수정
					//글수정
					dao.selectCar();

					System.out.print(
							"수정할 자동차 정보의 관리 번호:");
					int num = Integer.parseInt(br.readLine());
					int count = dao.checkRecord(num);

					if(count == 1) {
						dao.selectDetailCar(num);
						
						System.out.print("이름:");
						String name = br.readLine();
						
						System.out.print("색상:");
						String color = br.readLine();
						
						System.out.print("제조사:");
						String maker = br.readLine();
						
						int price = parseInputData("가격:");
						
						dao.updateCar(num, name, color, 
								            maker, price);
					}else if (count == 0) {
						System.out.println("번호를 잘못 입력하셨습니다.");
					}else {
						System.out.println("정보 처리 중 오류 발생");
					}
				}else if(no == 5) {//정보삭제
					dao.selectCar();
					
					System.out.print("삭제할 정보의 관리 번호:");
					int num = Integer.parseInt(br.readLine());
					
					int count = dao.checkRecord(num);
					if(count==1) {
						dao.deleteCar(num);
					}else if(count == 0) {
						System.out.println("번호를 잘못 입력했습니다.");
					}else {
						System.out.println("정보 처리 중 오류 발생");
					}
					
				}else if(no == 6) {//종료
					System.out.println("프로그램을 종료합니다.");
					break;
				}else {
					System.out.println("잘못 입력했습니다.");
				}
			}catch(NumberFormatException e) {
				System.out.println("[숫자만 입력 가능]");
			}
		}
	}
	public static void main(String[] args) {
		new CarMain();
	}
	//자동차 가격 체크
	public int parseInputData(String item)
	                        throws IOException{
		while(true) {
			System.out.print(item);
			try {
				int num = Integer.parseInt(
						          br.readLine());
				//입력 가능한 범위를 넘어서는지 체크
				if(num<=0 || num > 999999999) {
					throw new NotAcceptableValueException(
							"[1~10억미만까지 입력 가능]");
				}
				return num;//정상 값 반환
			}catch(NumberFormatException e) {
				System.out.println("[숫자만 입력 가능]");
			}catch(NotAcceptableValueException e) {
				System.out.println(e.getMessage());
			}
		}		
	}
	
}




