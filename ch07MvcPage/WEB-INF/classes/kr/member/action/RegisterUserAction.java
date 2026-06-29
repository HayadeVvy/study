package kr.member.action;

import org.mindrot.jbcrypt.BCrypt;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.controller.Action;
import kr.member.dao.MemberDAO;
import kr.member.vo.MemberVO;

public class RegisterUserAction implements Action{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//자바빈(DTO) 생성
		MemberVO member = new MemberVO();
		member.setId(request.getParameter("id"));
		member.setName(request.getParameter("name"));
		/*
		 * 단방향 해시(hash)를 사용한 것이 표준.
		 * 핵심은 복호화가 불가능한 방식
		 * 
		 * 단방향 예시 : 입력값 -> 고정된 길의 문자열로 변환,
		 *             되돌릴 수 없음(복호화 불가능)
		 * Salt(솔트) : 비밀번호에 랜덤 문자열을 추가해서 해시하는 것
		 * 솔트를 사용함으로써 같은 비밀번호라도 완전히 다른 해시값            
		 */
		String hashedPassword = 
				 BCrypt.hashpw(
						 request.getParameter("passwd"), 
						 BCrypt.gensalt());
		member.setPasswd(hashedPassword);
		
		member.setPhone(request.getParameter("phone"));
		member.setEmail(request.getParameter("email"));
		member.setZipcode(request.getParameter("zipcode"));
		member.setAddress1(request.getParameter("address1"));
		member.setAddress2(request.getParameter("address2"));
		
		MemberDAO dao = MemberDAO.getInstance();
		dao.insertMember(member);
		
		request.setAttribute("result_title", "회원 가입 완료");
		request.setAttribute("result_msg", "회원 가입이 완료되었습니다.");
		request.setAttribute("result_url", 
				         request.getContextPath()+"/main/main.do");
		
		return "common/result_view.jsp";
	}
	
}



