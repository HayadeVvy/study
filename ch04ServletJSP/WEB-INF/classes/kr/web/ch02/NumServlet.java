package kr.web.ch02;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/num")
public class NumServlet extends HttpServlet{
	@Override
	public void doGet(HttpServletRequest request,
			          HttpServletResponse response)
	                   throws ServletException,
	                          IOException{
		/*
		 * [실습] 짝수/홀수 구하기
		 * [출력 예시]
		 * 전송된 숫자 : 5
		 * 홀수입니다.
		 */
		
		//전송된 데이터 전달
		          //String -> int
		int num = Integer.parseInt(
				     request.getParameter("num"));
		
		//문서 타입 및 캐릭터셋 지정
		response.setContentType(
				"text/html;charset=utf-8");
		
		//HTML 출력을 위한 출력 스트림 생성
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println(
		"<head><title>짝수/홀수 구하기</title></head>");
		out.println("<body>");
		
		out.println("전송된 숫자 : " + num + "<br>");
		
		if(num%2 == 0) {
			out.println("짝수입니다.");
		}else {
			out.println("홀수입니다.");
		}
		
		out.println("</body>");
		out.println("</html>");
		out.close();		
	}
}





