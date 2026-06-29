package kr.web.ch05;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

@MultipartConfig(
		maxFileSize = 1024 * 1024 * 5,
		maxRequestSize = 1024 * 1024 * 50
		)
@WebServlet("/profile")
public class UploadServlet3 extends HttpServlet{
	@Override
	public void doPost(HttpServletRequest request,
			           HttpServletResponse response)
	                    throws ServletException,
	                           IOException{
		//컨텍스트 경로상의 절대 경로 구하기
		String realFolder = 
		 request.getServletContext().getRealPath("/upload");
		try {
			//파일 업로드 처리
			Part part = request.getPart("file");
			String fileName = part.getSubmittedFileName();
			if(!fileName.isEmpty()) {
				part.write(realFolder+"/"+fileName);
				
				//포워드 되는 JSP와 데이터를 공유하기 위해
				//request에 데이터 저장
				request.setAttribute("fileName", fileName);
				
				//s04_profile.jsp로 포워드
				RequestDispatcher dispatcher = 
						request.getRequestDispatcher(
							"/ch08-fileupload/s04_profile.jsp");
				dispatcher.forward(request, response);
			}
		}catch(IllegalStateException e) {
			e.printStackTrace();
		}
	}
}





