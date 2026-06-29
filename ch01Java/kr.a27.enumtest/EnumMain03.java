package kr.a27.enumtest;

enum Gender3{
	MALE,FEMAIL;
	
	//Object의 toString 재정의
	@Override
	public String toString() {
		switch(this) {
		case MALE:
			return "남자";
		default:
			return "여자";
		}
	}
	
}

public class EnumMain03 {
	public static void main(String[] args) {
		System.out.println(Gender3.MALE);
		System.out.println(Gender3.FEMAIL);
		System.out.println("-".repeat(20));
		
		System.out.println(Gender3.MALE.toString());
		System.out.println(Gender3.FEMAIL.toString());
	}
}




