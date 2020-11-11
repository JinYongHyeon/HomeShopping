package org.shopping.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.shopping.model.ProductDAO;
import org.shopping.model.ProductVO;

public class ProductDetailController implements Controller {

	@Override
	public String exectue(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String productNo= request.getParameter("productNo");
		
		ProductVO pvo = ProductDAO.getInstance().productDetail(productNo);
		
		request.setAttribute("product", pvo);
		request.setAttribute("url", "/views/product/productDetail.jsp");
		
		return "/views/template/layout.jsp";
	}

}
