package kr.board.action;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.board.dao.BoardDAO;
import kr.board.vo.BoardVO;
import kr.controller.Action;
import kr.util.StringUtil;

public class ModifyFormAction implements Action{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		long num = Long.parseLong(
				  request.getParameter("num"));
		BoardDAO dao = BoardDAO.getInstance();
		BoardVO boardVO = dao.getBoard(num);
		
		//큰 따옴표 처리(수정폼의 input태그에만 명시)
		boardVO.setTitle(StringUtil.parseQuot(
				              boardVO.getTitle()));
		
		request.setAttribute("boardVO", boardVO);	
		//JSP 경로 반환
		return "/WEB-INF/views/modifyForm.jsp";
	}

}




