package kr.main.action;

import java.util.List;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.controller.Action;
import kr.item.dao.ItemDAO;
import kr.item.vo.ItemVO;

public class MainAction implements Action{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		//신규 상품을 메인 페이지에 표시
		ItemDAO itemDAO = ItemDAO.getInstance();
		List<ItemVO> itemList = 
				itemDAO.getListItem(
						1,16,null,null,1);//표시 상품만 반환
		
		request.setAttribute("itemList", itemList);		
		
		//JSP 경로 반환
		return "main/main.jsp";
	}

}
