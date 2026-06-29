package kr.a24.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class ArrayListMain07 {
	public static void main(String[] args) {
		/*
		 * [실습]
		 * 로또 프로그램 제작
		 * 1~45까지 중복되지 않는 6개의 숫자를 구해서
		 * ArrayList에 저장하고 출력하시오.
		 * 출력할 때 오름차순 정렬
		 * 난수 생성:Math.random(), Random클래스
		 */
		ArrayList<Integer> list = 
				new ArrayList<Integer>();
		Random ra = new Random();
		while(list.size()<6) {
			int num = ra.nextInt(45)+1;//1~45
			//중복값 체크
			if(!list.contains(num)) {
				list.add(num);
			}
		}
		//오름차순 정렬
		Collections.sort(list);
		for(int num : list) {
			System.out.print(num + "\t");
		}
		
	}
}







