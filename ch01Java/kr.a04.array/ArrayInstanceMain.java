package kr.a04.array;

class Book{
	private String category;
	private String name;
	private int price;
	private double discount;
	
	//생성자
	public Book() {}
	
	public Book(String category, String name, 
			    int price, double discount) {
		this.category = category;
		this.name = name;
		this.price = price;
		this.discount = discount;
	}
	
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public double getDiscount() {
		return discount;
	}
	public void setDiscount(double discount) {
		this.discount = discount;
	}
	
}

public class ArrayInstanceMain {
	public static void main(String[] args) {
		//배열 선언 및 생성
		Book[] bookArray = new Book[3];
		int total = 0;
		
		//Book 객체를 3개 생성해서 배열에 저장
		bookArray[0] = 
			new Book("IT","Java",50000,0.05);
		bookArray[1] = 
			new Book("IT","Oracle",40000,0.03);
		bookArray[2] =
			new Book("미술","반 고흐",60000,0.06);
		
		//반복문을 이용해서 정보 출력
		for(int i=0;i<bookArray.length;i++) {
			System.out.printf("%s\t", 
					bookArray[i].getCategory());
			System.out.printf("%s\t", 
					bookArray[i].getName());
			System.out.printf("%,d원\t", 
					bookArray[i].getPrice());
			System.out.printf("%.2f%%%n", 
					bookArray[i].getDiscount());
			//합계
			total += bookArray[i].getPrice();
		}
		//합계 출력
		System.out.printf(
				"책 가격의 합 : %,d원%n", total);
		
	}
}




