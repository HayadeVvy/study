package kr.member.action;

import org.mindrot.jbcrypt.BCrypt;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.controller.Action;
import kr.member.dao.MemberDAO;
import kr.member.vo.EmailVO;
import kr.member.vo.MemberVO;
import kr.util.EmailSenderUtil;
import kr.util.StringUtil;

public class SendPasswordAction implements Action{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String id = request.getParameter("id");
		String email = request.getParameter("email");
		
		MemberDAO dao = MemberDAO.getInstance();
		MemberVO member = dao.checkMember(id);
		boolean check = false;
		if(member!=null && member.getAuth() > 1
				&& member.getEmail().equals(email)) {
			check = true;
			//기본비밀번호를 임시비밀번호로 변경
			String passwd = 
					StringUtil.randomPassword(10);
			member.setPasswd(passwd);
			//변경된 임시비밀번호를 DB에 저장
			dao.updatePassword(
					BCrypt.hashpw(
							member.getPasswd(),BCrypt.gensalt()), 
					member.getMem_num());
			
			EmailVO emailVO = new EmailVO();
			emailVO.setContent(
					"임시 비밀번호는 " + passwd + " 입니다.");
			emailVO.setReceiver(member.getEmail());
			emailVO.setSubject(member.getId()
					           +" 님 비밀번호 찾기 메일입니다.");
			EmailSenderUtil.sendEmail(emailVO);
		}
		
		request.setAttribute("check", check);
		
		return "member/emailSendSuccess.jsp";
	}

}




