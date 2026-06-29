package kr.web.mvc;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

//모델 클래스
public class ListAction implements Action{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		//request를 공유하기 때문에 request에 데이터를 저장하면
		//JSP에서 가져다쓸 수 있음
		request.setAttribute("message", "게시판 목록 페이지입니다.");
		
		//JSP 경로 반환
		return "/views2/list.jsp";
	}

}



