package kr.spring.ch07;

public class RegisterService {
	private RegisterDAO registerDAO;

	//의존관계 설정방식 : 프로퍼티
	public void setRegisterDAO(RegisterDAO registerDAO) {
		this.registerDAO = registerDAO;
	}
	
	public void write() {
		System.out.println(
				"RegisterService의 write메서드 실행");
		registerDAO.insert();
	}	
}




