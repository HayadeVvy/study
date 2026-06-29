package kr.a12.objectbasic.extention;

//부모 클래스
class Parent extends Object{//기본적으로 생략,
	                        //자동으로 Object가
	                        //상속됨
	int a = 100;
}
//Parent 클래스가 Child 클래스에 상속
//자식 클래스
class Child extends Parent{
	int b = 200;
}

public class ExtentionMain01 {
	public static void main(String[] args) {
		Child ch = new Child();
		System.out.println(ch.a);//Parent 클래스 a
		System.out.println(ch.b);
	}
}




