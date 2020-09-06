package org.shopping.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.shopping.model.ProductDAO;
import org.shopping.model.ProductVO;

public class ProductFindByListController implements Controller {

	public ProductFindByListController() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String exectue(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ArrayList<ProductVO> productFindList =ProductDAO.getInstance().productFindByList(request.getParameter("name").trim());
		request.setAttribute("productList", productFindList);
		return "admin.jsp";
	}

}
