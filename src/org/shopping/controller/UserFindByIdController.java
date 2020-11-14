package org.shopping.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.shopping.model.UserDAO;

public class UserFindByIdController implements Controller {

	public UserFindByIdController() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String exectue(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		//String id = UserDAO.getInstance().userFindById(name, email);
		String url ="idFindByForm.jsp";
//		if(id != null) {
//			request.setAttribute("id",id);
//		}else {
//			url = "idFindByForm.jsp?fail=fail";
//		}
		return url;
	}

}
