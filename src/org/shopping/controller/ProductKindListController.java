package org.shopping.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.shopping.model.PagingBean;
import org.shopping.model.ProductDAO;
import org.shopping.model.ProductVO;

public class ProductKindListController implements Controller {

	@Override
	public String exectue(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String kind = request.getParameter("kind");
		int totalCount = ProductDAO.getInstance().productKindListCount(kind);
		PagingBean paging= null;
		if(request.getParameter("nowPage") == null) {
			paging = new PagingBean(totalCount);
		}else {
			paging = new PagingBean(Integer.parseInt(request.getParameter("nowPage")), totalCount);
		}
		ArrayList<ProductVO> productList = ProductDAO.getInstance().productKindList(kind, paging);
		request.setAttribute("productList", productList);
		request.setAttribute("paging", paging);
		request.setAttribute("url", "/views/product/productList.jsp");
		return "/views/template/layout.jsp";
	}

}
