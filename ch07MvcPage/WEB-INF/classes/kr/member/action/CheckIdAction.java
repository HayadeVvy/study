package kr.member.action;

import java.util.HashMap;
import java.util.Map;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.controller.Action;
import kr.member.dao.MemberDAO;
import kr.member.vo.MemberVO;
import kr.util.StringUtil;

public class CheckIdAction implements Action{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		//전송된 데이터 반환
		String id = request.getParameter("id");
		
		MemberDAO dao = MemberDAO.getInstance();
		MemberVO member = dao.checkMember(id);
		
		Map<String,String> mapAjax = 
				          new HashMap<String,String>();
		if(member!=null) {//중복
			mapAjax.put("result", "duplicated");
		}else {//미중복
			mapAjax.put("result", "notFound");
		}
		
		//JSON 문자열로 변환하고 JSON 문자열을 클라이언트로
		//전송할 JSP 반환		
		return StringUtil.parseJSON(request, mapAjax);
	}

}



