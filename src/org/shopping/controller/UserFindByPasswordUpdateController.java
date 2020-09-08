package org.shopping.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.shopping.model.UserDAO;

public class UserFindByPasswordUpdateController implements Controller {

	@Override
	public String exectue(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String id= request.getParameter("id");
		String pass = request.getParameter("password");
		
		UserDAO.getInstance().userFindByPasswordUpdate(id, pass);
		return "redirect:index.jsp";
	}

}
