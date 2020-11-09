package org.shopping.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.shopping.model.ProductDAO;
import org.shopping.model.ProductVO;
import org.shopping.model.UserVO;

public class ProductListController implements Controller {

	public ProductListController() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String exectue(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession(false);
		if(session == null || session.getAttribute("user") == null) {
			return "redirect:shopping?command=home";
		}else {
			UserVO uvo =(UserVO) session.getAttribute("user");
			if(!uvo.getId().equals("admin")) {
				return "redirect:shopping?command=home";
			}
		}
		ArrayList<ProductVO> list = ProductDAO.getInstance().productList();
		request.setAttribute("productList", list);
		request.setAttribute("url", "/views/admin/admin.jsp");
		return "/views/template/layout.jsp";
	}

}
