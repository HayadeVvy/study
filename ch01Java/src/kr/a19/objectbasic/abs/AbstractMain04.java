package kr.a19.objectbasic.abs;

abstract class Animal{
	public void breathe() {
		System.out.println("숨을 쉬다");
	}
	//추상메서드
	public abstract void sound();
}

class Dog extends Animal{
	//추상메서드 구현
	@Override
	public void sound() {
		System.out.println("개는 멍멍멍~~");
	}
}

class Cat extends Animal{
	//추상메서드 구현
	@Override
	public void sound() {
		System.out.println("고양이는 야옹야옹~~");
	}
}

public class AbstractMain04 {
	public static void main(String[] args) {
		Dog d = new Dog();
		d.breathe();
		d.sound();
		System.out.println("-".repeat(20));
		
		Cat c = new Cat();
		c.breathe();
		c.sound();
	}
}




