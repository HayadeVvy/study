package kr.spring.mvc12.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.spring.mvc11.vo.PageRank;

@Controller
public class PageReportController {

	@GetMapping("/pageJsonReport.do")
	@ResponseBody
	public List<PageRank> jsonReport(){
		List<PageRank> pageRanks = 
				   new ArrayList<PageRank>();
		pageRanks.add(new PageRank(1,"/file.do"));
		pageRanks.add(new PageRank(2,"/pageRanksExcel.do"));
		pageRanks.add(new PageRank(3,"/pageJsonReport.do"));		
		return pageRanks;
	}
}



