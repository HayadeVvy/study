package kr.a25.iostream;

import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class MovieMain {
	/*
	 * [실습]
	 * 메뉴 : 1.영화정보입력,2.영화정보출력,3.파일생성,
	 *       4.파일읽기,5종료
	 * 메서드명: 메뉴 -> callMenu(),
	 *         영화정보입력 -> inputMovie()
	 *         영화정보출력 -> printMovie()
	 *         파일 생성 -> writeFile()
	 *         파일 읽기 -> readFile()
	 *         상영시간 조건체크 -> 
	 *                parseInputData(String title)
	 */
	private ArrayList<Movie> list;
	private BufferedReader br;
	
	public MovieMain() {
		list = new ArrayList<Movie>();
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
			"1.영화정보입력,2.영화정보출력,3.파일생성,4.파일읽기,5.종료>");
			try {
				int num = Integer.parseInt(
						            br.readLine());
				if(num ==1) {
					inputMovie();
				}else if(num == 2) {
					printMovie();
				}else if(num == 3) {
					createFile();
				}else if(num == 4) {
					readFile();
				}else if(num == 5) {
					if(list.size()>0) {
						while(true) {
							System.out.print(
							"입력한 영화정보가 있습니다. 파일을 생성하시겠습니까?y/n:");
							String choice = br.readLine();
							if(choice.equals("y")) {
								createFile();
								break;
							}else if(choice.equals("n")) {
								break;
							}else {
								System.out.println("잘못 입력했습니다.");
							}
						}
					}
					System.out.println(
						"영화정보관리를 종료합니다.");
					break;
				}else {
					System.out.println(
							"잘못 입력했습니다.");
				}
			}catch(NumberFormatException e) {
				System.out.println("숫자만 입력 가능");
			}
		}
	}
	//영화정보입력
	public void inputMovie()throws IOException{
		Movie m = new Movie();
		System.out.print("영화제목:");
		m.setName(br.readLine());
		System.out.print("제작연도");
		m.setCreate_year(br.readLine());
		System.out.print("감독:");
		m.setDirector(br.readLine());
		System.out.print("배우:");
		m.setActor(br.readLine());
		System.out.print("장르:");
		m.setGenre(br.readLine());
		
		m.setTime(parseInputData("상영시간:"));
		
		//Movie를 ArrayList에 저장
		list.add(m);
		
		System.out.println(
				"영화정보 1건을 입력했습니다.");
	}
	
	//상영시간 조건체크
	public int parseInputData(String title)
	                        throws IOException{
		while(true) {
			System.out.print(title);
			try {
				int num = Integer.parseInt(
						         br.readLine());
				if(num<=0) {
					System.out.println(
							"0보다 크게 입력하세요");
					continue;
				}
				return num;
			}catch(NumberFormatException e) {
				System.out.println("숫자만 입력 가능");
			}
		}
	}
	
	//영화정보출력
	public void printMovie() {
		if(list.size()>0) {
			System.out.println("-".repeat(30));
			System.out.println(
			"영화제목\t제작연도\t감독\t배우\t장르\t상영시간");
			System.out.println("-".repeat(30));
			for(Movie m : list) {
				System.out.print(m.toString());
			}
		}else {
			System.out.println(
					"출력할 영화정보가 없습니다.");
		}
	}
	//파일생성
	public void createFile() {
		FileWriter fw = null;
		try {
			fw = new FileWriter("movie.txt");
			fw.write("=".repeat(30));
			fw.write("\n");
			fw.write("영화제목\t제작연도\t감독\t배우\t장르\t상영시간");
			fw.write("\n");
			fw.write("=".repeat(30));
			fw.write("\n");
			for(Movie m : list) {
				fw.write(m.toString());
			}
			fw.flush();
			System.out.println(
					"파일에 영화정보를 저장했습니다.");
		}catch(IOException e) {
			System.out.println(
					"파일 영화정보 저장 오류!");
		}finally {
			if(fw!=null)try {fw.close();}
			          catch(IOException e) {}
		}
	}
	//파일읽기
	public void readFile() {
		FileReader fr = null;
		int readChar;
		try {
			fr = new FileReader("movie.txt");
			while((readChar=fr.read())!=-1) {
				System.out.print((char)readChar);
			}
		}catch(FileNotFoundException e) {
			System.out.println(
					"생성된 파일이 없습니다.");
		}catch(IOException e) {
			System.out.println("파일 읽기 오류");
		}finally {
			if(fr!=null)try {fr.close();}
			          catch(IOException e) {}
		}
	}

	public static void main(String[] args) {
		new MovieMain();
	}
}
