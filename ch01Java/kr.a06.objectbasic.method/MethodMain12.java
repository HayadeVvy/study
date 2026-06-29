package kr.a06.objectbasic.method;

class Capsule{
	//접근 지정자 private : 같은 클래스에서 호출 
	//                    가능하지만 다른 클래스
	//                    에서 호출 불가능
	//은닉화
	private int a;
	
	//캡슐화
	public void setA(int n) {
		if(n>=0) {
			a = n;
		}else {
			System.out.println(
					"음수는 허용되지 않습니다.");
		}
	}
	
	public int getA() {
		return a;
	}
	
}

public class MethodMain12 {
	public static void main(String[] args) {
		Capsule cap = new Capsule();
		//a의 접근 지정자가 private이기 때문에
		//다른 클래스에서 호출 불가
		//cap.a = -100;
		//System.out.println(cap.a);
		
		cap.setA(-200);//음수는 허용하지 않음
		System.out.println(cap.getA());
		System.out.println("-".repeat(20));
		
		cap.setA(100);
		System.out.println(cap.getA());
	}
}





