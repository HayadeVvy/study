package kr.spring.ch05;

public class MemberService {
	private MemberDAO memberDAO;
	
	public MemberService(MemberDAO memberDAO) {
		this.memberDAO = memberDAO;
	}
	
	public void send() {
		System.out.println(
				"MemberService의 send메서드 실행");
		memberDAO.register();
	}
	
}
