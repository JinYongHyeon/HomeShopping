package org.shopping.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ProductInsertFormController implements Controller {

	@Override
	public String exectue(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setAttribute("url", "/views/admin/productInsert.jsp");
		return "/views/template/layout.jsp";
	}

}
