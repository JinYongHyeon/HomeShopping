package org.shopping.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.shopping.model.ProductDAO;
import org.shopping.model.ProductVO;

public class HomeController implements Controller {

	@Override
	public String exectue(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ArrayList<ProductVO> hotList = ProductDAO.getInstance().hotProductList();
		ArrayList<ProductVO> newList = ProductDAO.getInstance().newProductList();
		request.setAttribute("hotList", hotList);
		request.setAttribute("newList", newList);
		request.setAttribute("url", "/views/home.jsp");
		return "/views/template/layout.jsp";
	}

}
