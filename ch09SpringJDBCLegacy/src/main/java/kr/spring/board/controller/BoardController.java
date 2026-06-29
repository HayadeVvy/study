package kr.spring.board.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kr.spring.board.service.BoardService;
import kr.spring.board.vo.BoardVO;
import kr.spring.util.PagingUtil;

@Controller
public class BoardController {

	@Autowired
	private BoardService boardService;
	
	//로그 처리(로그 대상 지정)
	private static final Logger log = 
			LoggerFactory.getLogger(BoardController.class);
	/*
	 * 로그 레벨
	 * FATAL : 가장 심각한 오류
	 * ERROR : 일반적인 오류
	 * WARN : 주의를 요하는 경우
	 * INFO : 런타임시 관심있는 내용
	 * DEBUG : 시스템 흐름과 관련된 상세 정보
	 * TRACE : 가장 상세한 정보
	 */
	
	//자바빈 초기화
	@ModelAttribute
	public BoardVO initCommand() {
		return new BoardVO();
	}
	
	@GetMapping("/insert.do")
	public String form() {
		
		log.info("<<글쓰기 폼 진입>>");
		
		return "insertForm";
	}
	
	@PostMapping("/insert.do")
	public String submit(@Valid BoardVO vo,BindingResult result) {
		
		log.info("<<전송된 데이터 : BoardVO>> : " + vo);
		
		//유효성 체크 결과 오류가 있으면 폼 호출
		if(result.hasErrors()) {
			return form();
		}
		
		//글 등록
		boardService.insertBoard(vo);
		
		return "redirect:/list.do";
	}
	
	
	@GetMapping("/list.do")
	public String getList(
			@RequestParam(defaultValue="1") int pageNum,
			             Model model) {
		
		int count = boardService.getBoardCount();
		
		log.info("<<pageNum>> : " + pageNum);
		log.info("<<count>> : " + count);
		
		PagingUtil page = 
				new PagingUtil(pageNum,count,10,10,"list.do");
		
		List<BoardVO> list = null;
		if(count > 0) {
			list = boardService.getBoardList(
					         page.getStartRow(),
					         page.getEndRow());
		}
		
		model.addAttribute("count", count);
		model.addAttribute("list", list);
		model.addAttribute("page", page.getPage());
		
		return "selectList";
	}
	
	@GetMapping("/detail.do")
	public ModelAndView processDetail(long num) {
		log.info("num : " + num);
		
		BoardVO board = boardService.getBoard(num);		
		                         //뷰 이름,속성명,속성값
		return new ModelAndView(
				     "selectDetail","board",board);
	}
	
	@GetMapping("/update.do")
	public String formUpdate(long num, Model model) {
		model.addAttribute("boardVO", 
				         boardService.getBoard(num));		
		return "updateForm";
	}
	
	@PostMapping("/update.do")
	public String submitUpdate(@Valid BoardVO boardVO,
			                   BindingResult result) {
		log.info("<<글 수정>> : " + boardVO);
		
		//유효성 체크 결과 오류가 있으면 폼 호출
		if(result.hasErrors()) {
			return "updateForm";
		}
		
		BoardVO db_board = 
				boardService.getBoard(boardVO.getNum());
		
		//비밀번호 일치 여부 체크
		if(!db_board.getPasswd().equals(boardVO.getPasswd())) {
			result.rejectValue("passwd", "invalidPassword");
			return "updateForm";
		}
		
		boardService.updateBoard(boardVO);
		
		return "redirect:/detail.do?num="+boardVO.getNum();
	}
	
	@GetMapping("/delete.do")
	public String formDelete(BoardVO vo) {
		return "deleteForm";
	}
	
	@PostMapping("/delete.do")
	public String submitDelete(@Valid BoardVO boardVO,
			                   BindingResult result) {
		//비밀번호만 유효성 체크 결과 오류가 있으면 폼 호출
		if(result.hasFieldErrors("passwd")) {
			//비밀번호가 전송되지 않으면 폼 호출
			return "deleteForm";
		}
		
		//DB에 저장된 비밀번호 구하기
		BoardVO db_board = 
				boardService.getBoard(boardVO.getNum());
		
		//비밀번호 일치 여부 체크
		if(!db_board.getPasswd().equals(
				                 boardVO.getPasswd())) {
			result.rejectValue("passwd", "invalidPassword");
			return "deleteForm";
		}
		
		boardService.deleteBoard(boardVO.getNum());
		
		return "redirect:/list.do";
	}
	
}















