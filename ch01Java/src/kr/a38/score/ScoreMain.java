package kr.a38.score;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

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
					getList();
				}else if(no == 3) {//상세정보
					getList();
					System.out.print("번호:");
					int num = Integer.parseInt(
							      br.readLine());
					getDetail(num);
				}else if(no == 4) {//수정
					getList();
					
					System.out.print("수정할 성적의 번호:");
					int num = Integer.parseInt(
							            br.readLine());
					int count = dao.checkRecord(num);
					if(count == 1) {
						getDetail(num);
						
						System.out.println("-".repeat(30));
						
						System.out.print("이름:");
						String name = br.readLine();
						int korean = parseInputData("국어:");
						int english = parseInputData("영어:");
						int math = parseInputData("수학:");
						
						ScoreDTO dto = new ScoreDTO();
						dto.setNum(num);
						dto.setName(name);
						dto.setKorean(korean);
						dto.setEnglish(english);
						dto.setMath(math);
						
						int count2 = dao.updateInfo(dto);
						if(count2>0) {
							System.out.println(
								count2 + "개 행 정보를 수정했습니다.");
						}else {
							System.out.println(
									    "정보 처리 중 오류 발생");
						}						
					}else if(count == 0) {
						System.out.println("번호를 잘못 입력했습니다.");
					}else {
						System.out.println("정보 처리 중 오류 발생");
					}
					
				}else if(no == 5) {//삭제
					getList();
					
					System.out.print("삭제할 성적의 번호:");
					int num = Integer.parseInt(br.readLine());
					int count = dao.deleteInfo(num);
					if(count == 1) {
						System.out.println(
							count + "개의 행을 삭제했습니다.");
					}else if(count == 0) {
						System.out.println("번호를 잘못 입력했습니다.");
					}else {
						System.out.println("정보 처리 중 오류 발생");
					}
					
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
	
	//목록 보기
	private void getList() {
		List<ScoreDTO> list = dao.selectInfo();
		System.out.println("-".repeat(30));
		System.out.println("번호\t이름\t국어\t영어\t수학\t총점\t평균\t등급");
		for(ScoreDTO dto : list) {
			System.out.print(dto.getNum() + "\t");
			System.out.print(dto.getName() + "\t");
			System.out.print(dto.getKorean() + "\t");
			System.out.print(dto.getEnglish() + "\t");
			System.out.print(dto.getMath() + "\t");
			System.out.print(dto.makeSum() + "\t");
			System.out.print(dto.makeAvg() + "\t");
			System.out.print(dto.makeGrade() + "\n");
		}
		System.out.println("-".repeat(30));
	}
	
	//상세 정보
	private void getDetail(int num) {
		ScoreDTO dto = 
				dao.selectDetailInfo(num);
		if(dto!=null) {
			System.out.println(
					"번호:" + dto.getNum());
			System.out.println(
				  "이름:" + dto.getName());
			System.out.println(
					"국어:" + dto.getKorean());
			System.out.println(
					"영어:" + dto.getEnglish());
			System.out.println(
					"수학:" + dto.getMath());
			System.out.println(
					"총점:" + dto.makeSum());
			System.out.println(
					"평균:" + dto.makeAvg());
			System.out.println(
					"등급:" + dto.makeGrade());
			System.out.println(
					"등록일:" + dto.getReg_date());
		}else {
			System.out.println(
					"검색된 정보가 없습니다.");
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
