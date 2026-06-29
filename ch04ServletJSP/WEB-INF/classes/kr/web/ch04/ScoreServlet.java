package kr.web.ch04;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/score")
public class ScoreServlet extends HttpServlet{
	@Override
	public void doPost(HttpServletRequest request,
			           HttpServletResponse response)
	                    throws ServletException,
	                           IOException{
		/*
		 * [실습]성적처리
		 * [출력예시]
		 * 국어:00
		 * 영어:00
		 * 수학:00
		 * 총점:000
		 * 평균:00
		 * 등급:A
		 */
		
		//문서 타입 및 캐릭터셋 지정
		response.setContentType("text/html;charset=utf-8");
		
		//전송된 데이터 반환
		int korean = Integer.parseInt(
				       request.getParameter("korean"));
		int english = Integer.parseInt(
				       request.getParameter("english"));
		int math = Integer.parseInt(
				        request.getParameter("math"));
		
		//총점 구하기
		int sum = korean + english + math;
		//평균 구하기
		int average = sum / 3;
		//등급 구하기
		String grade;
		switch(average/10) {
		case 10:
		case 9 : grade = "A"; break;
		case 8 : grade = "B"; break;
		case 7 : grade = "C"; break;
		case 6 : grade = "D"; break;
		default : grade = "F";
		}
		
		//HTML 출력을 위한 출력스트림을 생성
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println(
				"<head><title>성적처리</title></head>");
		out.println("<body>");
		out.println("국어 : " + korean + "점<br>");
		out.println("영어 : " + english + "점<br>");
		out.println("수학 : " + math + "점<br>");
		out.println("총점 : " + sum + "점<br>");
		out.println("평균 : " + average + "점<br>");
		out.println("등급 : " + grade + "학점<br>");
		out.println("</body>");
		out.println("</html>");
		out.close();		
	}
}





