package kr.a20.objectbasic.inter;

interface I{
	public abstract void play();
}

class Pianist implements I{
	@Override
	public void play() {
		System.out.println("피아노를 연주하다");
	}
}

class Cellist implements I{
	@Override
	public void play() {
		System.out.println("첼로를 연주하다");
	}
}

class Stage{
	public void autoPlay(I i) {
		i.play();
	}
}

public class InterMain06 {
	public static void main(String[] args) {
		Stage a = new Stage();
		a.autoPlay(new Pianist());//Pianist->I
		a.autoPlay(new Cellist());//Cellist->I
	}
}




