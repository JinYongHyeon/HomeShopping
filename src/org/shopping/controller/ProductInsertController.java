package org.shopping.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.shopping.model.ProductDAO;
import org.shopping.model.ProductVO;

public class ProductInsertController implements Controller {

	public ProductInsertController() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String exectue(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String name = request.getParameter("name");
		int price = Integer.parseInt(request.getParameter("price"));
		String content = request.getParameter("content");
		String imgPath = request.getParameter("imgPath");
		int count = Integer.parseInt(request.getParameter("count"));
		String kind = request.getParameter("kind");
		String productNew = request.getParameter("productNew");
		System.out.println(name);
		ProductVO vo = new ProductVO(name,price,content,imgPath,count,kind,productNew);
		//ProductDAO.getInstance().productInsert(vo);
		return "redirect:admin.jsp";
		
	}

}
