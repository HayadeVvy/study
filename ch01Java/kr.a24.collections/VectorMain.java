package kr.a24.collections;

import java.util.Vector;

public class VectorMain {
	public static void main(String[] args) {
		Vector<Double> v = new Vector<Double>();
		//자원 저장
		v.add(100.3);
		v.add(3.14);
		v.add(1000.);//=1000.0
		
		//확장 for문을 이용한 요소의 출력
		for(Double n : v) {
			System.out.println(n);
		}
		System.out.println("-".repeat(20));
		
		//자원검색
		double search = 1000.0;//검색할 요소
		int index = v.indexOf(search);//검색
		if(index != -1) {
			System.out.println(
					"검색요소 " + search
					          +"의 위치 : " + index);
		}else {
			System.out.println(
					"검색요소 " + search 
					           + "가 없습니다.");
		}
		
		//자원 삭제
		double del = 3.14;//삭제할 요소
		if(v.contains(del)) {
			v.remove(del);//삭제
			System.out.println(
					 del + " 삭제 완료");
		}
		
	}
}





