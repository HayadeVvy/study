package kr.board.action;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.board.dao.BoardDAO;
import kr.board.vo.BoardVO;
import kr.controller.Action;
import kr.util.StringUtil;

public class DetailAction implements Action{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		long num = Long.parseLong(
				   request.getParameter("num"));
		BoardDAO dao = BoardDAO.getInstance();
		BoardVO boardVO = dao.getBoard(num);
		
		//HTML를 허용하지 않음
		boardVO.setTitle(StringUtil.useNoHtml(
				              boardVO.getTitle()));
		//HTML를 허용하지 않으면서 줄바꿈 처리
		boardVO.setContent(StringUtil.useBrNoHtml(
				               boardVO.getContent()));
		
		request.setAttribute("boardVO", boardVO);
		
		//JSP 경로 반환
		return "/WEB-INF/views/detail.jsp";
	}

}





