package kr.a27.enumtest;

enum Item2{
	ADD(5),DEL(11),SEARCH(2),CANCEL(22);
	
	private final int var;
	//생성자
	Item2(int var){
		this.var = var;
	}
	
	public int getVar() {
		return var;
	}
}

public class EnumMain05 {
	public static void main(String[] args) {
		System.out.println(Item2.ADD);
		
		System.out.println(Item2.ADD.getVar());
		System.out.println(Item2.DEL.getVar());
		System.out.println(Item2.SEARCH.getVar());
		System.out.println(Item2.CANCEL.getVar());
		System.out.println("-".repeat(20));
		
		for(Item2 n : Item2.values()) {
			System.out.println(n + ":" + n.getVar());
		}
		
		
	}
}





