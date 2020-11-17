package org.shopping.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.shopping.model.PagingBean;
import org.shopping.model.ProductDAO;
import org.shopping.model.ProductVO;

public class UserProductFindByListController implements Controller {

	@Override
	public String exectue(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String name = request.getParameter("productName").trim();
		int totalRow = ProductDAO.getInstance().productFindByListCount(name);
		PagingBean paging=null;
		if(request.getParameter("nowPage") == null) {
			paging = new PagingBean(totalRow);
		}else {
			paging = new PagingBean(Integer.parseInt(request.getParameter("nowPage")), totalRow);
		}
		
		ArrayList<ProductVO> productFindList =ProductDAO.getInstance().productFindByList(name,paging);
		request.setAttribute("productList", productFindList);
		request.setAttribute("paging", paging);
		request.setAttribute("productName", name);
		request.setAttribute("url", "/views/product/productList.jsp");
		return "/views/template/layout.jsp";
	}

}
