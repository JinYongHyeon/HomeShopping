package org.shopping.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.shopping.model.ProductDAO;

public class ProductDeleteController implements Controller {

	@Override
	public String exectue(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String check[] = request.getParameterValues("productCk"); //체크박스 == 상품번호
		for(String no : check) {
		ProductDAO.getInstance().productDelete(no);
		}
		return "redirect:shopping?command=productList";
	}

}
