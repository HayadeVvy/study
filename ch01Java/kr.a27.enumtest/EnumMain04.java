package kr.a27.enumtest;

enum Item{
	ADD,DEL,SEARCH,CANCEL
}

public class EnumMain04 {
	public static void main(String[] args) {
		System.out.println(
		Item.ADD + "," + Item.ADD.ordinal());
		System.out.println(
		Item.DEL + "," + Item.DEL.ordinal());
		System.out.println(
		Item.SEARCH + "," + Item.SEARCH.ordinal());
		System.out.println(
		Item.CANCEL + "," + Item.CANCEL.ordinal());
		System.out.println("-".repeat(20));
		
		//values():열거 타입의 모든 열거 객체들을 배열로
		//         만들어 반환
		Item[] items = Item.values();
		//저장되어 있는 정수값을 확인할 수 있음
		for(Item n : items) {
			System.out.println(n + ":" + n.ordinal());
		}
	}
}




