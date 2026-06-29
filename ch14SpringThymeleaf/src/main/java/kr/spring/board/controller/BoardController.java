package kr.spring.board.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import jakarta.validation.Valid;
import kr.spring.board.service.BoardService;
import kr.spring.board.vo.BoardVO;
import kr.spring.util.PagingUtil;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class BoardController {

	@Autowired
	private BoardService boardService;
	
	//자바빈(VO) 초기화
	@ModelAttribute
	public BoardVO initCommand() {
		return new BoardVO();
	}
	
	//글 등록 폼
	@GetMapping("/insert.do")
	public String form() {
		return "insertForm";
	}
	
	//글 등록 처리
	@PostMapping("/insert.do")
	public String submit(@Valid BoardVO boardVO,
			             BindingResult result) {
		log.debug("<<글 등록 처리>> : " + boardVO);
		
		//유효성 체크 결과 오류가 있으면 폼 호출
		if(result.hasErrors()) {
			return form();
		}
		
		//글 등록
		boardService.insertBoard(boardVO);
		
		return "redirect:/list.do";
	}
	
	@GetMapping("/")
	public String init() {
		return "redirect:/list.do";
	}
	
	@GetMapping("/list.do")
	public ModelAndView getList(
			@RequestParam(defaultValue="1") int pageNum) {
		
		//총 레코드수
		int count = boardService.getBoardCount();
		
		//페이지 처리
		PagingUtil page = 
				new PagingUtil(pageNum,count,20,10,"list.do");
		
		//목록 호출
		List<BoardVO> list = null;
		if(count > 0) {
			Map<String,Integer> map = 
					new HashMap<String,Integer>();
			map.put("skip", page.getSkip());
			map.put("limit", page.getLimit());
			
			list = boardService.getBoardList(map);
		}
		
		ModelAndView mav = new ModelAndView();
		//뷰 이름 설정
		mav.setViewName("selectList");
		//데이터 저장
		mav.addObject("count", count);
		mav.addObject("list", list);
		mav.addObject("page", page.getPage());
		
		return mav;
	}
	
	//글 상세
	@GetMapping("/detail.do")
	public ModelAndView detail(long num) {
		BoardVO board = 
				boardService.getBoard(num);
		return new ModelAndView("selectDetail","board",board);
	}
	
	//수정 폼
	@GetMapping("/update.do")
	public String formUpdate(long num, Model model) {
		model.addAttribute("boardVO", 
				         boardService.getBoard(num));
		
		return "updateForm";
	}
	
	//글 수정 처리
	@PostMapping("/update.do")
	public String submitUpdate(@Valid BoardVO boardVO,
			                   BindingResult result) {
		log.debug("<<글 수정> : " + boardVO);
		
		//유효성 체크 결과 오류가 있으면 폼을 호출
		if(result.hasErrors()) {
			return "updateForm";
		}
		
		//비밀번호 일치 여부 체크
		BoardVO db_board = boardService.getBoard(
				                  boardVO.getNum());
		//비밀번호 체크
		if(!db_board.getPasswd().equals(
				                boardVO.getPasswd())) {
			result.rejectValue("passwd", "invalidPassword");
			return "updateForm";
		}
		
		boardService.updateBoard(boardVO);
		
		return "redirect:/detail.do?num="+boardVO.getNum();
	}
	
	//글 삭제 폼
	@GetMapping("/delete.do")
	public String formDelete(BoardVO boardVO) {
		return "deleteForm";
	}
	
	//글 삭제 처리
	@PostMapping("/delete.do")
	public String submitDelete(@Valid BoardVO boardVO,
			                   BindingResult result) {
		
		//유효성 체크 결과 오류가 있으면 폼을 호출
		//비밀번호의 전송 여부만 체크
		if(result.hasFieldErrors("passwd")) {
			return "deleteForm";
		}
		
		//비밀번호 일치 여부 체크
		//DB에 저장된 비밀번호 구하기
		BoardVO db_board = boardService.getBoard(
				                   boardVO.getNum());
		//비밀번호 체크
		if(!db_board.getPasswd().equals(
				           boardVO.getPasswd())) {
			result.rejectValue("passwd", "invalidPassword");
			return "deleteForm";
		}
		
		//글 삭제
		boardService.deleteBoard(boardVO.getNum());
		
		return "redirect:/list.do";
	}
	
}






