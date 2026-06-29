package kr.a06.objectbasic.method;

public class MethodMain10 {
	//인자 전달 방식 : 참조 호출(call by reference)
	//객체의 주소를 인자로 전달하는 방식
	public void increase(int[] n) {
		//배열의 요소를 1씩 증가시킴
		for(int i=0;i<n.length;i++) {
			n[i]++;
		}
	}
	public static void main(String[] args) {
		int[] ref1 = {100,200,300};
		System.out.println(
				"===데이터 변경 전===");
		for(int i=0;i<ref1.length;i++) {
			System.out.println(
					"ref1["+i+"]:" + ref1[i]);
		}
		
		//객체 선언 및 생성
		MethodMain10 me = new MethodMain10();
		//ref1 배열의 주소를 복사해서 메서드의 인자에 전달
		me.increase(ref1);
		
		System.out.println(
				"===데이터 변경 후===");
		for(int i=0;i<ref1.length;i++) {
			System.out.println(
					"ref1["+i+"]:" + ref1[i]);
		}
		
		
	}
}



