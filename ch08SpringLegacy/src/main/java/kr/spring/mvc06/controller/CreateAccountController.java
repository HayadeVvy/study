package kr.spring.mvc06.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import kr.spring.mvc06.validator.MemberInfoValidator;
import kr.spring.mvc06.vo.MemberInfo;

@Controller
public class CreateAccountController {

	//유효성 체크를 할 경우 자바빈(VO) 초기화 필수
	@ModelAttribute("command")
	public MemberInfo initForm() {
		return new MemberInfo();
	}
	
	@GetMapping("/account/create.do")
	public String form() {
		return "account/createForm";
	}
	
	//어노테이션을 이용해서 유효성 체크할 경우 호출되는 메서드에
	//@Valid 어노테이션을 명시해야 유효성 체크가 됨
	@PostMapping("/account/create.do")
	public String submit(@Valid	@ModelAttribute("command") MemberInfo memberInfo,
			BindingResult result) {
		
		//전송된 데이터 출력
		System.out.println("데이터 전송 후 : " + memberInfo);
		
		//전송된 데이터 유효성 체크
		//new MemberInfoValidator().validate(memberInfo, result);
		//BindingResult에 유효성 체크 결과 오류에 대한
		//내용이 저장되어 있으면 폼을 다시 호출함
		if(result.hasErrors()) {
			return "account/createForm";
		}
		
		return "account/created";
	}
	
}





