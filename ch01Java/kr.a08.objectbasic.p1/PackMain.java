package kr.a08.objectbasic.p1;

import kr.a09.objectbasic.p2.PackTwo;
import java.util.Scanner;

public class PackMain {
	public static void main(String[] args) {
		kr.a08.objectbasic.p1.PackOne one = 
			new kr.a08.objectbasic.p1.PackOne();
		
		//같은 패키지에서 호출할 때는 패키지 생략
		PackOne one2 = new PackOne();
		PackThree three = new PackThree();
		
		//패키지가 다를 경우 패키지 생략 불가
		kr.a09.objectbasic.p2.PackTwo two =
			new kr.a09.objectbasic.p2.PackTwo();
		
		//import문을 이용해서 패키지와 클래스를 
		//등록하면 클래스 사용시 패키지 생략
		PackTwo two2 = new PackTwo();
		
		Scanner input = new Scanner(System.in);
	}
}





