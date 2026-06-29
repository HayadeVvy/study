package kr.a27.enumtest;

class Course{
	//문자열 상수
	public static final String JAVA = "JAVA";
	public static final String ORACLE = "ORACLE";
	public static final String JSP = "JSP";
}

public class EnumMain01 {
	public static void main(String[] args) {
		System.out.println(Course.JAVA);
		System.out.println(Course.ORACLE);
		System.out.println(Course.JSP);
	}
}


