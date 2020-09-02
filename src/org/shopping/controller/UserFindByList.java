package org.shopping.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.shopping.model.UserDAO;
import org.shopping.model.UserVO;

public class UserFindByList implements Controller {

	public UserFindByList() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String exectue(HttpServletRequest request, HttpServletResponse response) throws Exception {
		UserVO vo =UserDAO.getInstance().userFindByList(request.getParameter("id").trim());
		if(vo != null) {
			request.setAttribute("user", vo);
		}else {
			request.setAttribute("user", "null");
		}
		return "admin.jsp";
	}

}
