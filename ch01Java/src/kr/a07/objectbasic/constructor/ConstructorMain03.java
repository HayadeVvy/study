package kr.a07.objectbasic.constructor;

class Student{
	int korean;
	int english;
	int math;
	int history;
	int science;
	int num; //과목수
	
	//생성자
	public Student(int k, int e, int m) {
		korean = k;
		english = e;
		math = m;
		num = 3;//과목수 지정
	}
	public Student(int k, int e, int m, 
			               int h, int s) {
		korean = k;
		english = e;
		math = m;
		history = h;
		science = s;
		num = 5;//과목수 지정
	}
	
	//총점을 구하는 메서드
	public int getTotal() {
		int total;
		if(num == 3) {
			total = korean + english + math;
		}else {
			total = korean + english + math 
					      + history + science;
		}
		return total;
	}
	//평균을 구하는 메서드
	public int getAverage() {
		return getTotal()/num;
	}	
}

public class ConstructorMain03 {
	public static void main(String[] args) {
		//3과목 성적 처리
		Student st = new Student(90,97,95);
		
		System.out.println(
				"총점 :" + st.getTotal());
		System.out.println(
				"평균 : " + st.getAverage());
		System.out.println("-".repeat(20));
				
		//5과목 성적 처리
		Student st2 = 
				new Student(88,82,83,90,98);
		
		System.out.println(
				"총점 :" + st2.getTotal());
		System.out.println(
				"평균 : " + st2.getAverage());
		System.out.println("-".repeat(20));
		
	}
}



