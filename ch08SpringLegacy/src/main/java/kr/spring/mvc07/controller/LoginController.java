package kr.spring.mvc07.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import kr.spring.mvc07.service.LoginCheckException;
import kr.spring.mvc07.service.LoginService;
import kr.spring.mvc07.vo.LoginCommand;

@Controller
public class LoginController {

	@Autowired
	private LoginService loginService;
	
	//유효성 체크를 위한 자바빈 초기화
	@ModelAttribute
	public LoginCommand initCommand() {
		return new LoginCommand();
	}
	
	@GetMapping("/login/login.do")
	public String form() {
		return "login/form";
	}
	
	@PostMapping("/login/login.do")
	public String submit(@Valid LoginCommand loginCommand,
			             BindingResult result) {
		
		System.out.println("전송된 데이터 : " + loginCommand);
		
		//유효성 체크 결과 오류가 있으면 폼 호출
		if(result.hasErrors()) {
			return form();
		}
		
		//로그인 체크
		try {
			loginService.checkLogin(loginCommand);
			//로그인 성공
			return "redirect:/index.jsp";
		}catch(LoginCheckException e) {
			//로그인 실패
			//메시지          에러코드                 메시지에 전달될 인자                     default message
			//result.reject("invalidIdOrPassword",new Object[] {loginCommand.getUserId()}, null);
			result.reject("invalidIdOrPassword");
			return form();
		}	
	}	
}





