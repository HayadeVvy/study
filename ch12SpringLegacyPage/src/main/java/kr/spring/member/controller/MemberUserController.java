package kr.spring.member.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.mindrot.bcrypt.BCrypt;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import kr.spring.member.service.MemberService;
import kr.spring.member.vo.MemberVO;
import kr.spring.util.AuthCheckException;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping("/member")
public class MemberUserController {
	@Autowired
	private MemberService memberService;
	
	//자바빈(VO) 초기화
	@ModelAttribute
	public MemberVO initCommand() {
		return new MemberVO();
	}
	
	//회원 등록 폼 호출
	@GetMapping("/registerUser.do")
	public String form() {
		return "memberRegiser";
	}
	
	//회원 가입 데이터 처리
	@PostMapping("/registerUser.do")
	public String submit(@Valid MemberVO memberVO,
			             BindingResult result,
			             Model model,
			             HttpServletRequest request) {
		
		log.debug("<<회원 가입>> : " + memberVO);
		
		//유효성 체크 결과 오류가 있으면 폼 호출
		if(result.hasErrors()) {
			return form();
		}
		
		//비밀번호 암호화
		String hashedPassword = 
				BCrypt.hashpw(memberVO.getPasswd(), 
						      BCrypt.gensalt());
		memberVO.setPasswd(hashedPassword);
		
		//회원 가입
		memberService.insertMember(memberVO);
		
		model.addAttribute("accessTitle", "회원 가입");
		model.addAttribute("accessMsg", 
				     "회원 가입이 정상적으로 완료되었습니다.");
		model.addAttribute("accessBtn", "홈으로");
		model.addAttribute("accessUrl", 
			request.getContextPath() + "/main/main.do");
		
		return "common/resultView";
	}
	
	//로그인 폼
	@GetMapping("/login.do")
	public String formLogin() {
		return "memberLogin";
	}
	
	//로그인 품에 전송된 데이터 처리
	@PostMapping("/login.do")
	public String submitLogin(@Valid MemberVO memberVO,
			         BindingResult result,
			         HttpSession session) {
		log.debug("<<회원 로그인>> : " + memberVO);
		
		//유효성 체크 결과 오류가 있으면 폼 호출
		//id와 passwd 필드만 체크
		if(result.hasFieldErrors("id") || 
				result.hasFieldErrors("passwd")) {
			return formLogin();
		}
		
		//로그인 체크(id,비밀번호 일치 여부 체크)
		MemberVO member = null;
		boolean check = false;
		try {
			member = memberService.selectCheckMember(
					                   memberVO.getId());
			if(member!=null) {
				//비밀번호 일치 여부 체크
				check = member.isCheckedPasswd(
						           memberVO.getPasswd());
			}
			if(check) {
				//인증 성공, 로그인 처리
				session.setAttribute("user", member);
				
				log.debug("<<인증 성공>>");
				log.debug("<<id>> : " + member.getId());
				log.debug("<<auth>> : " + member.getAuth());
				
				return "redirect:/main/main.do";
			}
			
			//인증 실패
			throw new AuthCheckException();
			
		}catch(AuthCheckException e) {
			if(member!=null && member.getAuth()==1) {
				//인증 실패로 로그인폼 호출
				result.reject("noAuthority");
			}else {
				//인증 실패로 로그인폼 호출
				result.reject("invalidIdOrPassword");
			}
			
			return formLogin();
		}
	}
	
	//로그아웃
	@GetMapping("/logout.do")
	public String processLogout(HttpSession session) {
		//로그아웃
		session.invalidate();
		
		return "redirect:/main/main.do";
	}
	
	//회원상세정보
	@GetMapping("/myPage.do")
	public String process(HttpSession session,
			              Model model) {
		MemberVO vo = 
				(MemberVO)session.getAttribute("user");
		
		//회원상세정보 반환
		MemberVO member = 
				memberService.selectMember(
						             vo.getMem_num());
		log.debug("<<회원상세정보>> : " + member);
		
		model.addAttribute("member", member);
		
		return "memberView";
	}
	
	//회원정보 수정 폼
	@GetMapping("/update.do")
	public String submitUpdate(HttpSession session,
			                   Model model) {
		MemberVO vo = 
				(MemberVO)session.getAttribute("user");
		
		MemberVO member = 
				memberService.selectMember(
						               vo.getMem_num());
		
		model.addAttribute("memberVO", member);
		
		return "memberModify";
	}
	
	//수정 폼에서 전송된 데이터 처리
	@PostMapping("/update.do")
	public String submitUpdate(@Valid MemberVO memberVO,
			                   BindingResult result,
			                   HttpSession session) {
		log.debug("<<회원정보 수정 처리>> : " + memberVO);
		
		//유효성 체크 결과 오류가 있으면 폼 호출
		if(result.hasErrors()) {
			return "memberModify";
		}
		
		MemberVO vo = 
				(MemberVO)session.getAttribute("user");
		memberVO.setMem_num(vo.getMem_num());
		
		//회원정보 수정
		memberService.updateMember(memberVO);		
		
		return "redirect:/member/myPage.do";
	}
	
	//비밀번호 변경 폼
	@GetMapping("/changePassword.do")
	public String formChangePassword() {
		return "memberChangePassword";
	}
	
	//비밀번호 변경 폼에서 전송된 데이터 처리
	@PostMapping("/changePassword.do")
	public String submitChangePassword(
			           @Valid MemberVO memberVO,
			           BindingResult result,
			           HttpSession session,
			           Model model,
			           HttpServletRequest request) {
		log.debug("<<비밀번호 변경 처리>> : " + memberVO);
		
		//유효성 체크 결과 오류가 있으면 폼 호출
		//now_passwd, passwd만 체크
		if(result.hasFieldErrors("now_passwd")
				   || result.hasFieldErrors("passwd")) {
			return formChangePassword();
		}
		
		MemberVO vo = 
				(MemberVO)session.getAttribute("user");
		memberVO.setMem_num(vo.getMem_num());
		
		MemberVO member = memberService.selectMember(
				                 memberVO.getMem_num());		
		//폼에서 전송한 현재 비밀번호와 DB에서 받아온 현재 비밀번호가
		//일치하는지 여부 체크
		if(!member.isCheckedPasswd(memberVO.getNow_passwd())) {
			result.rejectValue("now_passwd", 
					            "invalidPassword");
			return formChangePassword();
		}
		
		//비밀번호 암호화
		String hashedPassword = 
				BCrypt.hashpw(memberVO.getPasswd(), 
						      BCrypt.gensalt());
		memberVO.setPasswd(hashedPassword);
				
		//비밀번호 수정
		memberService.updatePassword(memberVO);
		
		model.addAttribute("message", 
				 "비밀번호가 정상적으로 변경되었습니다.");
		model.addAttribute("url", 
			request.getContextPath()+"/member/myPage.do");
		
		return "common/resultAlert";
	}
	
	//이미지 출력
	@GetMapping("/photoView.do")
	public ModelAndView viewImage(HttpSession session) {
		
		MemberVO user = 
				(MemberVO)session.getAttribute("user");
		MemberVO memberVO = memberService.selectMember(
				                    user.getMem_num());
		ModelAndView mav = new ModelAndView();
		mav.setViewName("imageView");
		mav.addObject("imageFile", memberVO.getPhoto());
		mav.addObject("filename", memberVO.getPhoto_name());
		
		return mav;
	}
	
}

















