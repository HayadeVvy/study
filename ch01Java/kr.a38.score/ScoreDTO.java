package kr.a38.score;

import java.sql.Date;

/*
 * DTO : Data Transfer Object
 *       데이터베이스 연동시 사용하게 되는 데이터를 보관하는
 *       객체
 */
public class ScoreDTO {
	private int num;		//번호
	private String name; 	//이름
	private int korean;		//국어
	private int english;	//영어
	private int math;		//수학
	private Date reg_date;	//등록일
	
	//총점 구하기
	public int makeSum() {
		return korean + english + math;
	}
	
	//평균 구하기
	public int makeAvg() {
		return makeSum()/3;
	}
	
	//등급 구하기
	public String makeGrade() {
		String grade;
		switch(makeAvg()/10) {
		case 10:
		case 9: grade = "A"; break;
		case 8: grade = "B"; break;
		case 7: grade = "C"; break;
		case 6: grade = "D"; break;
		default: grade = "F";
		}
		return grade;
	}
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getKorean() {
		return korean;
	}
	public void setKorean(int korean) {
		this.korean = korean;
	}
	public int getEnglish() {
		return english;
	}
	public void setEnglish(int english) {
		this.english = english;
	}
	public int getMath() {
		return math;
	}
	public void setMath(int math) {
		this.math = math;
	}
	public Date getReg_date() {
		return reg_date;
	}
	public void setReg_date(Date reg_date) {
		this.reg_date = reg_date;
	}
	
}



