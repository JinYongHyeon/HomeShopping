package org.shopping.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.shopping.model.ProductDAO;
import org.shopping.model.ProductVO;

public class ProductUpdateFormController implements Controller {

	public ProductUpdateFormController() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String exectue(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ProductVO productFindList =ProductDAO.getInstance().productDetail(request.getParameter("no").trim());
		request.setAttribute("product", productFindList);
		request.setAttribute("url", "/views/product/productUpdateForm.jsp");

		return "/views/template/layout.jsp";
	}

}
