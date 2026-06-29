package kr.web.ch03;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/greeting")
public class GreetingServlet extends HttpServlet{
	@Override
	public void doPost(HttpServletRequest request,
			          HttpServletResponse response)
	                   throws ServletException,
	                          IOException{
		//문서 타입 및 캐릭터셋 지정
		response.setContentType(
				"text/html;charset=utf-8");
		
		//전송된 데이터 반환
		String name = request.getParameter("name");
		
		//HTML 출력을 위한 출력스트림을 생성
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println(
		    "<head><title>Greeting</title></head>");
		out.println("<body>");
		out.println(name + "님의 방문을 환영합니다.");
		out.println("</body>");
		out.println("</html>");
		out.close();		
	}
}



