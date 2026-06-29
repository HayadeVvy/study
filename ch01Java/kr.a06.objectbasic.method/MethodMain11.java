package kr.a06.objectbasic.method;

public class MethodMain11 {
	//Variable Arguments
	//자료형이 일치할 때 전달하고자 하는 값의 개수를
	//다르게 지정할 수 있음.
	//전달되는 데이터는 내부적으로 배열로 인식함
	public void argTest(int ... n) {
		for(int i=0;i<n.length;i++) {
			System.out.println(
					"n["+i+"]:"+n[i]);
		}
	}
	
	public static void main(String[] args) {
		MethodMain11 me = new MethodMain11();
		me.argTest(10);
		System.out.println("-".repeat(20));
		me.argTest(10,20);
		System.out.println("-".repeat(20));
		me.argTest(10,20,30);
		System.out.println("-".repeat(20));
		me.argTest();
		System.out.println("-".repeat(20));
	}
}





