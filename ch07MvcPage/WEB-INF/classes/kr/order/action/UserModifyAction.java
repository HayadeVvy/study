package kr.order.action;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import kr.controller.Action;
import kr.order.dao.OrderDAO;
import kr.order.vo.OrderVO;

public class UserModifyAction implements Action{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		Long user_num = 
				(Long)session.getAttribute("user_num");
		if(user_num==null) {//로그인이 되지 않은 경우
			return "redirect:/member/loginForm.do";
		}
		//로그인이 된 경우
		long order_num = Long.parseLong(
				request.getParameter("order_num"));
		
		OrderDAO dao = OrderDAO.getInstance();
		//주문정보 호출
		OrderVO order = dao.getOrder(order_num);
		if(order.getMem_num()!=user_num) {
			//주문자 회원번호와 로그인한 회원번호가 불일치할 경우
			return "common/accessDenied.jsp";
		}
		
		//배송지 수정전 배송상태 한 번 더 체크할 것
		if(order.getStatus()>1) {
			//배송준비중 이상으로 관리자가 변경한 상품을 
			//주문자가 변경할 수 없음
			request.setAttribute("notice_msg", 
					 "배송상태가 변경되어 주문자가 배송지 변경 불가");
			request.setAttribute("notice_url", 
					request.getContextPath()
					                 +"/order/orderList.do");
			return "common/alert_view.jsp";
		}
		
		OrderVO orderVO = new OrderVO();
		orderVO.setOrder_num(order_num);
		orderVO.setReceive_name(
				 request.getParameter("receive_name"));
		orderVO.setReceive_post(
				 request.getParameter("receive_post"));
		orderVO.setReceive_address1(
				 request.getParameter("receive_address1"));
		orderVO.setReceive_address2(
				 request.getParameter("receive_address2"));
		orderVO.setReceive_phone(
				 request.getParameter("receive_phone"));
		orderVO.setNotice(request.getParameter("notice"));
		
		//배송지 수정
		dao.updateOrder(orderVO);
		
		request.setAttribute("notice_msg", 
				          "정상적으로 수정되었습니다.");
		request.setAttribute("notice_url", 
				request.getContextPath()
				  +"/order/orderDetail.do?order_num="+order_num);
		
		return "common/alert_view.jsp";
	}

}
