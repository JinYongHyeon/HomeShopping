package org.shopping.controller;

import java.util.ArrayList;

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
		ProductVO productFindList =ProductDAO.getInstance().productUpdateFrom(request.getParameter("no").trim());
		request.setAttribute("product", productFindList);
		return "productUpdateForm.jsp";
	}

}
