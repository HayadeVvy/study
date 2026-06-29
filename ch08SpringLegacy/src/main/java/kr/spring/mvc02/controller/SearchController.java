package kr.spring.mvc02.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SearchController {

	/*
	 * @RequestParam 어노테이션을 이용해서 HTTP 요청 파라미터
	 * 를 메서드의 인자로 전달 
	 * [형식]
	 * 1. @RequestParam(요청파라미터네임) 메서드의 인자(파라미터)
	 * 	  필수적으로 요청 파라미터를 전달해야 하고 전달하지 않으면
	 *    오류 발생
	 * 2  요청 파라미터가 없을 경우 오류가 나지 않게 처리
	 *    @RequestParam(value="query",required=false)  
	 * 3. 요청 파라미터명과 메서드의 인자명이 같으면 파라미터명 생략
	 *    @RequestParam String query  
	 * 4. 요청 파라미터명과 메서드의 인자명이 같으면 어노테이션 생략 
	 *    String query 
	 *    어노테이션을 생략하면 요청 파라미터가 필수적으로 전달되지 않아도
	 *    동작함. 
	 *    
	 *    [데이터가 숫자일 경우]
	 *    전송되는 데이터가 숫자일 경우 자동적으로 변환 처리
	 *    @RequestParam("p") int pageNumber
	 *    전송되는 파라미터가 없을 때 null로 처리되는 것이 아니라
	 *    오류 발생
	 *    
	 *    전송되는 파라미터가 없을 때 오류가 발생하지 않고
	 *    null로 처리
	 *    @RequestParam("p",required=false) Integer pageNumber
	 *    
	 *    전달되는 데이터가 없을 때 default 값 설정
	 *    @RequestParam(value="p",defaultValue="1") int pageNumber
	 *    	
	 */
	
	//요청URL과 실행 메서드 연결
	@RequestMapping("/search/internal.do")
	public ModelAndView searchInternal(String query) {
		
		System.out.println("query = " + query);
		
		                        //뷰이름
		return new ModelAndView("search/internal");
	}
	
	//요청 URL과 실행 메서드 연결
	@RequestMapping("/search/external.do")
	public ModelAndView searchExternal(
			@RequestParam(value="query",required=false) String query,
			@RequestParam(value="p",defaultValue="1") int pageNumber
			) {
		
		System.out.println("query = " + query);
		System.out.println("p = " + pageNumber);
		                         //뷰 이름
		return new ModelAndView("search/external");
	}
	
}






