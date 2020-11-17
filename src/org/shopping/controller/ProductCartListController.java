package org.shopping.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.shopping.model.PagingBean;
import org.shopping.model.ProductDAO;
import org.shopping.model.ShoppingBasket;

public class ProductCartListController implements Controller {

	@Override
	public String exectue(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession(false);
		if(session == null || session.getAttribute("user") == null)return "redirect:shopping?command=home";
		String id = request.getParameter("id");
		int totalCount = ProductDAO.getInstance().productCartListCount(id);
		PagingBean paging = null;
		if(request.getParameter("nowPage")==null) {
		paging = new PagingBean(totalCount);
		}else {
		paging = new PagingBean(Integer.parseInt(request.getParameter("nowPage")),totalCount);
		}
		ArrayList<ShoppingBasket> list = ProductDAO.getInstance().productCartList(id,paging);
		if(list.isEmpty())list=null;
		request.setAttribute("cartList", list);
		request.setAttribute("paging", paging);
		request.setAttribute("url", "/views/product/productCartList.jsp");
		return "/views/template/layout.jsp";
	}

}
