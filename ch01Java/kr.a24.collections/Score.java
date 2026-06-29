package kr.a24.collections;

public class Score {
	/*
	 * [실습]
	 * 1.멤버변수:private - 이름(name),국어(korean)
	 *          영어(english),수학(math)
	 * 2.멤버메서드:get/set
	 *           int 총점구하기(makeSum())
	 *           double 평균구하기(makeAvg())
	 *           String 등급구하기(makeGrade())
	 */
	private String name;
	private int korean;
	private int english;
	private int math;
	
	//총점 구하기
	public int makeSum() {
		return korean + english + math;
	}
	//평균 구하기
	public double makeAvg() {
		return makeSum()/3.0;
	}
	//등급 구하기
	public String makeGrade() {
		String grade;
		switch((int)(makeAvg()/10)) {
		case 10:
		case 9: grade = "A";break;
		case 8: grade = "B";break;
		case 7: grade = "C";break;
		case 6: grade = "D";break;
		default: grade = "F";
		}
		return grade;
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
	
	
}










