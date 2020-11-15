package org.shopping.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.shopping.model.UserVO;

public class ProductInsertFormController implements Controller {

	@Override
	public String exectue(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession(false);
		if(session == null || session.getAttribute("user") == null) {
			return "redirect:shopping?command=home";
		}else {
			UserVO uvo = (UserVO)session.getAttribute("user");
			if(!uvo.getId().equals("admin")) {
				return "redirect:shopping?command=home";
			}
		}
		request.setAttribute("url", "/views/product/productInsert.jsp");
		return "/views/template/layout.jsp";
	}

}
