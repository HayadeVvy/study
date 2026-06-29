package kr.spring.mvc07.service;

import kr.spring.mvc07.vo.LoginCommand;

public class LoginService {

	public void checkLogin(LoginCommand loginCommand)
	                       throws LoginCheckException{
		//테스트용으로 아이디와 비밀번호가 일치하면 로그인 성공
		if(!loginCommand.getUserId().equals(
				        loginCommand.getPassword())) {
			System.out.println("인증 에러 - " + 
				        loginCommand.getUserId());
			throw new LoginCheckException();
		}
	}
}
