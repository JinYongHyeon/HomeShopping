package org.shopping.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.shopping.model.ProductDAO;

public class ProductDeleteCartController implements Controller {

	@Override
	public String exectue(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession(false);
		if(session == null || session.getAttribute("user") == null)return "redirect:shopping?command=home";
		String id=request.getParameter("id");
		String no=request.getParameter("productNo");
		ProductDAO.getInstance().productDeleteCart(no,id);
		return "redirect:shopping?command=productCartList&id="+id;
	}

}
