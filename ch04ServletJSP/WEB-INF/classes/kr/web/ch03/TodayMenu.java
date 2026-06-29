package kr.web.ch03;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/todayMenu")
public class TodayMenu extends HttpServlet{

	@Override
	public void doPost(HttpServletRequest request,
			           HttpServletResponse response)
	                    throws ServletException,
	                           IOException{
		//문서 타입 및 캐릭터셋 지정
		response.setContentType("text/html;charset=utf-8");
		
		//HTML 출력을 위한 출력스트림을 생성
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println(
			"<head><title>Lunch Menu</title></head>");
		out.println("<body>");
		out.println("<h3>오늘 점심은</h3>");
		
		//전송된 데이터를 String 배열로 반환
		String[] values = 
				  request.getParameterValues("lunch");
		if(values!=null) {
			for(int i=0;i<values.length;i++) {
				out.println(values[i] + "<br>");
			}
		}else {
			out.println("선택하지 않음");
		}
		out.println("</body>");
		out.println("</html>");
		out.close();		
	}
}





