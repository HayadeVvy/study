package kr.board.action;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.board.dao.BoardDAO;
import kr.board.vo.BoardVO;
import kr.controller.Action;
import kr.util.FileUtil;

public class DeleteAction implements Action{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		long num = Long.parseLong(
				  request.getParameter("num"));
		String passwd = request.getParameter("passwd");
		
		BoardDAO dao = BoardDAO.getInstance();
		//비밀번호 인증을 위해 한 건의 레코드를 자바빈에 담아서 반환
		BoardVO db_board = dao.getBoard(num);
		boolean check = false;
		if(db_board!=null) {
			check = db_board.isCheckedPassword(passwd);
		}
		if(check) {
			dao.delete(num);
			//파일 삭제
			FileUtil.removeFile(request, db_board.getFilename());
		}
		request.setAttribute("check", check);
		//JSP 경로 반환
		return "/WEB-INF/views/delete.jsp";
	}

}






