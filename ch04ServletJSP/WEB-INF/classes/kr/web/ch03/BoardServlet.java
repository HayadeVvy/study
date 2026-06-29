package kr.web.ch03;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/board")
public class BoardServlet extends HttpServlet{
	@Override
	public void doPost(HttpServletRequest request,
			           HttpServletResponse response)
	                    throws ServletException,
	                           IOException{
		/*
		 * [실습]
		 * [출력 예시]
		 * 이름 : 홍길동
		 * 제목 : 봄이 왔어요
		 * 내용 : 날씨가 더워요
		 */
		
		//전송된 데이터 반환
		String name = request.getParameter("name");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		//문서 타입 및 캐릭터셋 지정
		response.setContentType(
				"text/html;charset=utf-8");
		
		//HTML 출력을 위한 출력스트림을 생성
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println(
		 "<head><title>글쓰기 완료</title></head>");
		out.println("<body>");
		out.println("이름 : " + name + "<br>");
		out.println("제목 : " + title + "<br>");
		out.println("내용 : " + content);
		out.println("</body>");
		out.println("</html>");
		out.close();
	}
}



