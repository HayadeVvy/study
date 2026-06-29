package kr.spring.board.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	
	//자바빈(VO) 초기화
	@ModelAttribute
	public BoardVO initCommand() {
		return new BoardVO();
	}
	
	//글쓰기 폼 호출
	@GetMapping("/insert.do")
	public String form() {
		return "insertForm";
	}
	
	@PostMapping("/insert.do")
	public String submit(@Valid BoardVO boardVO,
			             BindingResult result) {
		log.debug("<<글쓰기>> :" + boardVO);
		
		//유효성 체크 결과 오류가 있으면 폼 호출
		if(result.hasErrors()) {
			return form();
		}
		
		//글쓰기
		boardService.insertBoard(boardVO);
		
		return "redirect:/list.do";
	}
	
	//목록
	@GetMapping("/list.do")
	public String getList(
			  @RequestParam(defaultValue="1") int pageNum,
			                             Model model) {
		
		//총레코드 수
		int count = boardService.selectBoardCount();
		
		log.debug("목록 pageNum : " + pageNum);
		log.debug("목록 count :" + count);
		
		//페이지 처리
		PagingUtil page = 
			new PagingUtil(pageNum,count,10,10,"list.do");
		
		//목록 호출
		List<BoardVO> list = null;
		if(count > 0) {
			Map<String,Object> map = 
					         new HashMap<String,Object>();
			map.put("skip", page.getSkip());
			map.put("limit", page.getLimit());
			
			list = boardService.selectBoardList(map);
		}
		
		model.addAttribute("count", count);
		model.addAttribute("list", list);
		model.addAttribute("page", page.getPage());
			
		return "selectList";
	}
	
	//글 상세
	@GetMapping("/detail.do")
	public ModelAndView detail(long num) {
		BoardVO board = boardService.selectBoard(num);
		                        //뷰 이름,속성명,속성값
		return new ModelAndView("selectDetail","board",board);
	}
	
	//수정 폼
	@GetMapping("/update.do")
	public String formUpdate(long num, Model model) {
		
		model.addAttribute("boardVO", 
				boardService.selectBoard(num));
		
		return "updateForm";
	}
	
	//글 수정 처리
	@PostMapping("/update.do")
	public String submitUpdate(@Valid BoardVO boardVO,
			                   BindingResult result) {
		
		log.debug("<<글 수정 - BoardVO>> : " + boardVO);
		
		//유효성 체크 결과 오류가 있으면 폼을 호출
		if(result.hasErrors()) {
			return "updateForm";
		}
		
		//비밀번호 일치 여부 체크
		//DB에 저장된 비밀번호 구하기
		BoardVO db_board = boardService.selectBoard(
				                     boardVO.getNum());
		//비밀번호 체크
		if(!db_board.getPasswd().equals(boardVO.getPasswd())) {
			result.rejectValue("passwd", "invalidPassword");
			return "updateForm";
		}
		
		//글 수정
		boardService.updateBoard(boardVO);
		
		return "redirect:/detail.do?num="+boardVO.getNum();
	}
	
	//글 삭제 폼
	@GetMapping("/delete.do")
	public String formDelete(BoardVO vo) {
		return "deleteForm";
	}
	
	//글 삭제 처리
	@PostMapping("/delete.do")
	public String submitDelete(@Valid BoardVO boardVO,
			                   BindingResult result) {
		log.debug("<<글 삭제 - BoardVO>> : " + boardVO);
		
		//유효성 체크 결과 오류가 있으면 폼을 호출
		//비밀번호 전송 여부만 체크
		if(result.hasFieldErrors("passwd")) {
			return "deleteForm";
		}
		
		//비밀번호 일치 여부 체크
		//DB에 저장된 비밀번호 구하기
		BoardVO db_board = boardService.selectBoard(
				                     boardVO.getNum());
		//비밀번호 체크
		if(!db_board.getPasswd().equals(boardVO.getPasswd())) {
			result.rejectValue("passwd", "invalidPassword");
			return "deleteForm";
		}
		
		//글 삭제
		boardService.deleteBoard(boardVO.getNum());		
		
		return "redirect:/list.do";
	}
	
	
}






