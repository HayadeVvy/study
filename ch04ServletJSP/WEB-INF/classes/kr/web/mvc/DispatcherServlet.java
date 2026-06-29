package kr.web.mvc;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class DispatcherServlet extends HttpServlet{

	@Override
	public void doGet(HttpServletRequest request,
			          HttpServletResponse response)
	              throws ServletException,IOException{
		requestPro(request,response);
	}
	
	@Override
	public void doPost(HttpServletRequest request,
			          HttpServletResponse response)
	              throws ServletException,IOException{
		requestPro(request,response);
	}
	
	//공통 작업 메서드
	private void requestPro(HttpServletRequest request,
			                HttpServletResponse response)
	                 throws ServletException,IOException{
		
		//모델 클래스가 객체 생성 후 저장되는 변수
		Action com = null;
		//뷰 경로가 저장되는 변수
		String view = null;
		
		String command = request.getRequestURI();
		System.out.println(command);
		
		if(command.indexOf(request.getContextPath())==0) {
			command = command.substring(
					request.getContextPath().length());
			System.out.println(command);
		}
		
		if(command.equals("/list.do")) {
			com = new ListAction();
		}else if(command.equals("/write.do")) {
			com = new WriteAction();
		}else if(command.equals("/detail.do")) {
			com = new DetailAction();
		}else if(command.equals("/update.do")) {
			com = new UpdateAction();
		}
		
		try {
			//데이터 처리 후 뷰 경로 반환
			view = com.execute(request, response);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		//forward 방식으로 View(JSP) 호출
		RequestDispatcher dispatcher = 
				request.getRequestDispatcher(view);
		dispatcher.forward(request, response);
		
	}
}



