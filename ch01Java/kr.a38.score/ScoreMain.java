package kr.a38.score;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ScoreMain {
	private BufferedReader br;
	private ScoreDAO dao;
	
	public ScoreMain() {
		try {
			br = new BufferedReader(
					new InputStreamReader(
							     System.in));
			dao = new ScoreDAO();
			callMenu();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			//자원정리
			if(br!=null)try {br.close();}
			            catch(IOException e) {}
		}
	}
	
	public void callMenu()throws IOException{
		while(true) {
			System.out.print("1.입력,2.목록,3.상세정보,4.수정,5.삭제,6.종료:");
			try {
				int no = Integer.parseInt(
						            br.readLine());
				if(no == 1) {//입력
					System.out.println("성적을 입력합니다.");
					System.out.print("이름:");
					String name = br.readLine();
					
					int korean = parseInputData("국어:");
					int english = parseInputData("영어:");
					int math = parseInputData("수학:");
					
					//DTO 생성
					ScoreDTO dto = new ScoreDTO();
					dto.setName(name);
					dto.setKorean(korean);
					dto.setEnglish(english);
					dto.setMath(math);
					
					int count = dao.insertInfo(dto);
					if(count > 0) {
						System.out.println(
							count + "개의 행을 삽입했습니다.");
					}else {
						System.out.println("작업 중 오류 발생");
					}
					
				}else if(no == 2) {//목록
					
				}else if(no == 3) {//상세정보
					
				}else if(no == 4) {//수정
					
				}else if(no == 5) {//삭제
					
				}else if(no == 6) {//종료
					System.out.println("프로그램 종료");
					break;
				}else {
					System.out.println("잘못 입력했습니다.");
				}
			}catch(NumberFormatException e) {
				System.out.println("[숫자만 입력 가능]");
			}
		}
	}
	
	//성적 범위 체크 (0~100)
	public int parseInputData(String course)
	                         throws IOException{
		while(true) {
			System.out.print(course);
			try {
				int num = Integer.parseInt(br.readLine());
				if(num<0 || num>100) {
					throw new ScoreValueException(
							"[0~100사이의 값만 인정!!]");
				}
				return num;
			}catch(NumberFormatException e) {
				System.out.println(
						"[숫자만 입력하세요!]");
			}catch(ScoreValueException e) {
				System.out.println(e.getMessage());
			}		
		}
	}
	
	public static void main(String[] args) {
		new ScoreMain();
	}
}
