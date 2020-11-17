package org.shopping.controller;

import javax.print.DocFlavor.READER;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.shopping.model.ProductDAO;
import org.shopping.model.ProductVO;
import org.shopping.model.ShoppingBasket;
import org.shopping.model.UserVO;

public class ProductAddCartController implements Controller {

	@Override
	public String exectue(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession(false);
		if(session == null || session.getAttribute("user") == null)return "redirect:shopping?command=home";
		ShoppingBasket basket = new ShoppingBasket();
		ProductVO pvo = new ProductVO();
		pvo.setProductNo(request.getParameter("productNo"));
		pvo.setProductPrice(Integer.parseInt(request.getParameter("productPrice")));
		UserVO uvo = new UserVO();
		uvo.setId(request.getParameter("id"));
		
		basket.setProductVO(pvo);
		basket.setUserVO(uvo);
		int coin = ProductDAO.getInstance().productCartCheck(basket);
		System.out.println("coin : "+coin);
		if(coin<=0) {
			ProductDAO.getInstance().productAddCart(basket);
			request.setAttribute("responsebody", coin);
		}else {
			request.setAttribute("responsebody", coin);
		}
		return "/AjaxView";
	}

}
