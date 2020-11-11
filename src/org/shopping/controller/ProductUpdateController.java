package org.shopping.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.shopping.model.ProductDAO;
import org.shopping.model.ProductVO;

public class ProductUpdateController implements Controller {

	@Override
	public String exectue(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String no = request.getParameter("no");
		String name = request.getParameter("name");
		int price = Integer.parseInt(request.getParameter("price"));
		int count = Integer.parseInt(request.getParameter("count"));
		String kind = request.getParameter("kind");
		String content = request.getParameter("content");
		
		ProductVO pvo = new ProductVO();
		pvo.setProductNo(no);
		pvo.setProductName(name);
		pvo.setProductPrice(price);
		pvo.setProductPossesionCount(count);
		pvo.setKinds(kind);
		pvo.setProductContent(content);
		
		ProductDAO.getInstance().productUpdate(pvo);
		
		request.setAttribute("product", ProductDAO.getInstance().productDetail(no));
		request.setAttribute("url","/views/product/productDetail.jsp");
		
		return "/views/template/layout.jsp";
	}

}
