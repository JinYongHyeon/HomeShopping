package org.shopping.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.shopping.model.ProductDAO;
import org.shopping.model.ProductVO;

public class OrderFormController implements Controller {

	@Override
	public String exectue(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int productCount = Integer.parseInt(request.getParameter("productCount"));
		String productNo = request.getParameter("productNo");
		
		ProductVO pvo = ProductDAO.getInstance().productFindByNo(productNo);
		pvo.setProductPrice(pvo.getProductPrice()*productCount);
		request.setAttribute("pvo", pvo);
		request.setAttribute("url", "/views/product/productPurchase.jsp");
		
		return "/views/template/layout.jsp";
	}

}
