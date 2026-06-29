package kr.spring.main.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping("/main")
public class MainController {
	
	@GetMapping("/main.do")
	public String viewMain() {
		log.debug("<<메인 진입>>");
		 //타일스 설정명
		return "main";
	}
}


