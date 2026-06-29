package kr.spring.mvc08.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import kr.spring.mvc08.vo.MemberCommand;

@Controller
public class MemberWriteController {

	//자바빈(VO) 초기화
	@ModelAttribute("command")
	public MemberCommand initCommand() {
		return new MemberCommand();
	}
	
	@GetMapping("/member/write.do")
	public String form() {
		return "member/write";
	}
	
	@PostMapping("/member/write.do")
	public String submit(@ModelAttribute("command") @Valid
			             MemberCommand memberCommand,
			             BindingResult result) {
		System.out.println("데이터 전송 후 : " + memberCommand);
		
		//유효성 체크 결과 오류가 있으면 폼을 호출
		if(result.hasErrors()) {
			
			for(FieldError f : result.getFieldErrors()) {
				System.out.println("에러 필드 : " + f.getField());
			}
			
			return form();
		}
		
		return "redirect:/index.jsp";
	}
	
}







