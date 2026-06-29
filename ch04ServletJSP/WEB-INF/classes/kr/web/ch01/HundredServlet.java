package kr.web.ch01;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

//호출할 주소 부여
@WebServlet("/hundred")
public class HundredServlet extends HttpServlet{
	@Override
	public void doGet(HttpServletRequest request,
			          HttpServletResponse response)
	                   throws ServletException,
	                          IOException{
		/*
		 * [실습] 1부터 100까지의 합 출력(반복문 활용)
		 * 출력예시
		 * <body>
		 * 1부터 100까지의 합은 5050
		 * </body>
		 */
		
		int total = 0;
		for(int i=1;i<=100;i++) {
			total += i;
		}
		
		//문서 타입 및 캐릭터셋 지정
		response.setContentType(
				"text/html;charset=utf-8");
		
		//HTML 출력을 위한 출력 스트림을 생성
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println(
		 "<head><title>1부터 100까지 더하는 서블릿</title></head>");
		out.println("<body>");
		out.println("1부터 100까지 합은 " + total + "<br>");
		out.println("</body>");
		out.println("</html>");
		out.close();		
	}
}




