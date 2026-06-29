package kr.a11.objectbasic.thistest;

class Animal{
	private String name;//이름
	private int age;//나이
	private boolean fly;//비행여부
	
	//생성자
	public Animal() {}
	
	public Animal(String name, 
			         int age, boolean fly) {
		this.name = name;
		this.age = age;
		this.fly = fly;
	}
	
	public void setName(String name) {
		//멤버변수  = 지역변수
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public int getAge() {
		return age;
	}
	
	public void setFly(boolean fly) {
		this.fly = fly;
	}
	
	public boolean isFly() {
		return fly;
	}
}

public class AnimalMain {
	/*
	 * [실습]
	 * Animal 클래스
	 * 멤버변수 : private - 이름(name),나이(age),
	 *          비행여부(fly)
	 * 멤버메서드 : public - set/get 메서드
	 * 필요한 생성자 정의
	 * 
	 * AnimalMain 클래스
	 * 1)인자가 없는 생성자를 이용해서 객체 생성
	 *   이름,나이,비행여부 설정
	 *   이름,나이,비행여부를 출력
	 *   비행여부 true/false -> 가능/불가능
	 * 2)인자가 있는 생성자를 이용해서 객체 생성
	 *   이름,나이,비행여부를 출력
	 *   비행여부 true/false -> 가능/불가능
	 * 
	 */
	
	public static void print(Animal a) {
		System.out.println("이름 : " + a.getName());
		System.out.println("나이 : " + a.getAge());
		System.out.println(
			"비행여부 : " + (a.isFly() ? "가능" : "불가능"));
	}
	
	public static void main(String[] args) {
		//인자가 없는 생성자로 Animal 객체 생성
		Animal a1 = new Animal();
		a1.setName("기린");
		a1.setAge(12);
		a1.setFly(false);
		
		print(a1);
		
		System.out.println("-".repeat(20));
		
		//인자가 있는 생성자를 이용해서 Animal 객체 생성
		Animal a2 = new Animal("기러기",3,true);
		
		print(a2);
		
	}
}





