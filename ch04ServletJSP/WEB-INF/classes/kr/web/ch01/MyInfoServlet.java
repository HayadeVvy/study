package kr.web.ch01;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

//호출할 주소 부여
@WebServlet("/myInfo")
public class MyInfoServlet extends HttpServlet{
	@Override
	public void doGet(HttpServletRequest request,
			          HttpServletResponse response)
	                   throws ServletException,
	                          IOException{
		String name = "홍길동";
		int age = 20;
		String job = "학생";
		String address = "서울시";
		
		//문서 타입 및 캐릭터셋 지정
		response.setContentType("text/html;charset=utf-8");
		
		//HTML 출력을 위한 출력 스트림 생성
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println(
			"<head><title>개인 정보</title></head>");
		out.println("<body>");
		out.println("이름 : " + name + "<br>");
		out.println("나이 : " + age + "<br>");
		out.println("직업 : " + job + "<br>");
		out.println("주소 : " + address);
		out.println("</body>");
		out.println("</html>");
		out.close();
		
	}
}



