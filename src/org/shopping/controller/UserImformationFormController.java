package org.shopping.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserImformationFormController implements Controller {

	@Override
	public String exectue(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		request.setAttribute("url", "/views/user/userImformation.jsp");
		
		return "/views/template/layout.jsp";
	}

}
