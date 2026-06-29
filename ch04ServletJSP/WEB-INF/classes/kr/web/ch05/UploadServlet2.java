package kr.web.ch05;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import kr.util.FileUtil;

@MultipartConfig(
		maxFileSize = 1024 * 1024 * 10,
		maxRequestSize = 1024 * 1024 * 50
		)
@WebServlet("/fileMultiUpload")
public class UploadServlet2 extends HttpServlet{
	@Override
	public void doPost(HttpServletRequest request,
			           HttpServletResponse response)
	                    throws ServletException,
	                           IOException{
		//컨텍스트 경로상의 절대 경로 구하기
		String realFolder = 
			request.getServletContext().getRealPath("/upload");
		
		//문서 타입 및 캐릭터셋 지정
		response.setContentType("text/html;charset=UTF-8");
		//HTML 출력을 위한 출력스트림을 생성
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println(
		  "<head><title>파일 다중 업로드</title></head>");
		out.println("<body>");
		out.println(
		"작성자 : " + request.getParameter("name") + "<br>");
		out.println(
		 "제목 : " + request.getParameter("title") + "<br>");
		out.println("-----------------------<br>");
		try {
			/*
			Part part1 = request.getPart("uploadFile1");
			String fileName = part1.getSubmittedFileName();
			if(!fileName.isEmpty()) {
				part1.write(realFolder + "/" + fileName);
				out.println("<img src=\"/ch04ServletJSP/upload/"+fileName+"\"><br>");
			}
			
			Part part2 = request.getPart("uploadFile2");
			String fileName2 = part2.getSubmittedFileName();
			if(!fileName2.isEmpty()) {
				part2.write(realFolder + "/" + fileName2);
				out.println("<img src=\"/ch04ServletJSP/upload/"+fileName2+"\"><br>");
			}
			*/
			
			Collection<Part> parts = request.getParts();
			for(Part p : parts) {
				String fileName = 
						FileUtil.getFilename(
							p.getHeader("Content-Disposition"));
				if(fileName!=null) {
					p.write(realFolder + "/" + fileName);
					out.println("<img src=\"/ch04ServletJSP/upload/"+fileName+"\"><br>");
				}
			}
			 
		}catch(IllegalStateException e) {
			out.println("용량 초과 : " + e.toString());
		}
		out.println("</body>");
		out.println("</html>");
		out.close();		
	}
}







