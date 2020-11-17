package org.shopping.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.shopping.model.UserDAO;

public class OrderController implements Controller {

	@Override
	public String exectue(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String id = request.getParameter("id");
		String productNo = request.getParameter("productNo");
		String productName = request.getParameter("productName");
		int productCount = Integer.parseInt(request.getParameter("productCount"));
		int productPrice = Integer.parseInt(request.getParameter("productPrice"));
		
		UserDAO.getInstance().userPointMinus(id, productPrice);
		
		
		return null;
	}

}
