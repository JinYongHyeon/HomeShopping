package org.shopping.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.shopping.model.UserDAO;

public class UserIdCheckController implements Controller {

	@Override
	public String exectue(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("오는가??");
		String id = request.getParameter("id");
		request.setAttribute("responsebody", UserDAO.getInstance().userIdCheck(id));
		return "/AjaxView";
	}

}
