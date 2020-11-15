package org.shopping.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.shopping.model.PagingBean;
import org.shopping.model.ProductDAO;
import org.shopping.model.ProductVO;
import org.shopping.model.UserVO;

public class ProductFindByListController implements Controller {

	public ProductFindByListController() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String exectue(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession(false);
		if(session == null || session.getAttribute("user") == null) {
			return "redirect:shopping?command=home";
		}else {
			UserVO uvo = (UserVO)session.getAttribute("user");
			if(!uvo.getId().equals("admin")) {
				return "redirect:shopping?command=home";
			}
		}
		String name = request.getParameter("name").trim();
		int totalRow = ProductDAO.getInstance().productFindByListCount(name);
		PagingBean paging=null;
		if(request.getParameter("nowPage") == null) {
			paging = new PagingBean(totalRow);
		}else {
			paging = new PagingBean(Integer.parseInt(request.getParameter("nowPage")), totalRow);
		}
		
		ArrayList<ProductVO> productFindList =ProductDAO.getInstance().productFindByList(name,paging);
		request.setAttribute("productList", productFindList);
		request.setAttribute("paging", paging);
		request.setAttribute("productName", name);
		request.setAttribute("url", "/views/admin/adminProductList.jsp");
		return "/views/template/layout.jsp";
	}

}
