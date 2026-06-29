package kr.a06.objectbasic.method;

class Worker{
	/*
	 * [실습]
	 * Worker
	 * 1)멤버 변수 : 직원 이름(name),급여(money),
	 *             계좌 잔고(balance)
	 * 2)멤버 메서드 : 
	 *  - work : 실행하면 money에 1000원 누적
	 *  - deposite : 실행하면 money의 돈을 
	 *               balance에 누적시키고
	 *               money는 0으로 처리
	 *               
	 * WorkMain의 main
	 * 1)Worker 객체 생성
	 * 2)직원의 이름 지정
	 * 3)10번 일하는데 번 돈이 3000원일 때마다 계좌에
	 *   저축
	 * 4)직원이름, 현재 계좌에 입금되지 않고 남아 있는
	 *   급여(money), 계좌 잔고(balance)를 출력하시오.               
	 */
	String name;
	int money;
	int balance;
	
	public void work() {
		money += 1000;
	}
	
	public void deposite() {
		balance += money;
		money = 0;
	}
	
}

public class MethodMain07 {
	public static void main(String[] args) {
		Worker worker = new Worker();
		worker.name = "홍길동";
		
		//10번 일하는데 번 돈이 3000원일 때마다 저축
		for(int i=1;i<=10;i++) {
			worker.work();
			if(worker.money>=3000) {
				//3000원일 때마다 저축
				//worker.money%3000==0
				worker.deposite();
			}
		}
		
		System.out.println("직원 이름:"+worker.name);
		System.out.printf(
			"현재 입금되지 않고 남아 있는 급여:%,d원%n",
			                      worker.money);
		System.out.printf("계좌 잔고 : %,d원%n",
				                  worker.balance);
		
	}
}





