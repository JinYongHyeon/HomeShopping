package org.shopping.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.shopping.model.ProductDAO;
import org.shopping.model.ProductVO;

public class ProductUpdateController implements Controller {

	public ProductUpdateController() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String exectue(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String no = request.getParameter("no");
		String name = request.getParameter("name");
		int price = Integer.parseInt(request.getParameter("price"));
		String imgPath = request.getParameter("imgPath");
		int count = Integer.parseInt(request.getParameter("count"));
		String kind = request.getParameter("kind");
		String productNew = request.getParameter("productNew");
				
		ProductDAO.getInstance().productUpdate(new ProductVO(no,name,price,imgPath,count,kind,productNew));
		
		return "redirect:shopping?command=productList";
	}

}
