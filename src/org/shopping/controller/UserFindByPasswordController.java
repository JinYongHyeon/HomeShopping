package org.shopping.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.shopping.model.UserDAO;

public class UserFindByPasswordController implements Controller {

	public UserFindByPasswordController() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String exectue(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String userId= UserDAO.getInstance().userFindByPassword(id, name, email);
		String sql = null;
	
		if(userId != null) {
			sql =  "passwordUpdateForm.jsp";
			request.setAttribute("id", userId);
		}else {
			sql =  "passwordFindByForm.jsp";
			request.setAttribute("flag", false);
		}
		return sql;
	}

}
