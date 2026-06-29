package kr.a24.collections;

import java.util.ArrayList;

class CartItem{
	private String code;//상품코드
	private int num;//수량
	private int price;//단가

	public CartItem() {}

	public CartItem(String code, int num, 
			int price) {
		this.code = code;
		this.num = num;
		this.price = price;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
}

public class ArrayListMain08 {
	public static void main(String[] args) {
		//2차원 배열 형태를 ArrayList + CartItem으로
		//구현
		ArrayList<CartItem> list = 
				new ArrayList<CartItem>();
		list.add(new CartItem("A1001",2,2000));
		list.add(new CartItem("A1002",1,7000));
		list.add(new CartItem("A1003",3,2500));

		System.out.printf("%s %8s %8s%n",
				"상품코드","수량","가격");
		System.out.println("-".repeat(30));
		for(CartItem item : list) {
			System.out.printf("%s %8d %8d%n", 
					item.getCode(),
					item.getNum(),
					item.getPrice());
		}
		System.out.println("-".repeat(30));

		//요소의 삭제
		list.remove(1);//인덱스

		System.out.printf("%s %8s %8s%n",
				"상품코드","수량","가격");
		System.out.println("-".repeat(30));
		for(CartItem item : list) {
			System.out.printf("%s %8d %8d%n", 
					item.getCode(),
					item.getNum(),
					item.getPrice());
		}
		System.out.println("-".repeat(30));

		//데이터 추가
		list.add(new CartItem("B1001",10,6000));

		System.out.printf("%s %8s %8s%n",
				         "상품코드","수량","가격");
		System.out.println("-".repeat(30));
		for(CartItem item : list) {
			System.out.printf("%s %8d %8d%n", 
					item.getCode(),
					item.getNum(),
					item.getPrice());
		}
		System.out.println("-".repeat(30));

	}
}




