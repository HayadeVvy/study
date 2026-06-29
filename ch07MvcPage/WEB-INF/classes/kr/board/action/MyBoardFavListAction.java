package kr.board.action;

import java.util.List;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import kr.board.dao.BoardDAO;
import kr.board.vo.BoardVO;
import kr.controller.Action;
import kr.util.PagingUtil;

public class MyBoardFavListAction implements Action{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		Long user_num = 
				(Long)session.getAttribute("user_num");
		if(user_num == null) {//로그인이 되지 않은 경우
			return "redirect:/member/loginForm.do";
		}
		
		//로그인 된 경우		
		String pageNum = request.getParameter("pageNum");
		if(pageNum==null) pageNum = "1";
		
		BoardDAO dao = BoardDAO.getInstance();
		int count = dao.getBoardFavCount(user_num);
		
		//페이지 처리
		PagingUtil page = new PagingUtil(
				            Integer.parseInt(pageNum),
				            count,20,10,"myBoardFavList.do");
		List<BoardVO> list = null;
		if(count > 0) {
			list = dao.getListBoardFav(
					              page.getStartRow(),
					              page.getEndRow(),
					              user_num);
		}
		
		request.setAttribute("count", count);
		request.setAttribute("list", list);
		request.setAttribute("page", page.getPage());
		
		return "board/myBoardFav.jsp";
	}

}
