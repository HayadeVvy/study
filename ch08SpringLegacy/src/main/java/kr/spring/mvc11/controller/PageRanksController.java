package kr.spring.mvc11.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import kr.spring.mvc11.vo.PageRank;

@Controller
public class PageRanksController {
	
	@GetMapping("/pageRanksExcel.do")
	public ModelAndView handleRequest() {
		List<PageRank> pageRanks = 
				            new ArrayList<PageRank>();
		pageRanks.add(new PageRank(1, "/board/list.do"));
		pageRanks.add(new PageRank(2, "/member/login.do"));
		pageRanks.add(new PageRank(3, "/cart/list.do"));
		                         //뷰 이름	  속성명         속성값
		return new ModelAndView("pageRanks", "pageRanks", pageRanks);
	}
}




