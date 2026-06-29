package kr.a17.objectbasic.poly;

class Product{
	int price;//제품의 가격
	int bonusPoint;//제품 구매시 제공하는 보너스점수
	public Product(int price) {
		this.price = price;
		bonusPoint = price/10;
	}
	public String getName() {
		return "상품";
	}
}

class Tv extends Product{
	//생성자
	public Tv() {
		//부모클래스의 인자가 있는 생성자를 호출
		super(100);//Tv의 가격 설정
	}
	//메서드 재정의
	@Override
	public String getName() {
		return "Tv";
	}
}
class Computer extends Product{
	//생성자
	public Computer() {
		//부모클래스의 인자가 있는 생성자를 호출
		super(200);//Computer의 가격 설정
	}
	//매서드 재정의
	@Override
	public String getName() {
		return "Computer";
	}
}

class Buyer{
	int money = 1000;//구매자가 보유한 금액
	int bonusPoint = 0;//상품 구매 보너스 포인트
	
	//상품 구매하기
	public void buy(Product p) {
		if(money < p.price) {
			System.out.println(
			"잔액이 부족하여 물건을 구매할 수 없습니다.");
			return;
		}
		
		//상품 구매 가능
		money -= p.price;//보유 금액 차감
		bonusPoint += p.bonusPoint;//보너스점수 누적
		System.out.println(
				p.getName() + "을/를 구매했습니다.");
		System.out.println(
			"현재 남은 돈은 " + money + "만원입니다.");
		System.out.println(
			"현재 보너스점수는 " + bonusPoint 
			                 + "점입니다.");
		System.out.println("-".repeat(20));
	}

}

public class PolyMain05 {
	public static void main(String[] args) {
		Buyer b = new Buyer();
		Tv tv = new Tv();
		Computer com = new Computer();
		
		//상품 구매
		b.buy(tv);//Tv -> Product 자동적으로 형변환
		b.buy(com);//Computer -> Product 자동적으로 형변환
	}
}





