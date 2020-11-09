package org.shopping.controller;

import java.util.ArrayList;

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
		ArrayList<UserVO> list =UserDAO.getInstance().userFindByList(request.getParameter("id").trim());
		if(list != null) {
			request.setAttribute("list", list);
		}else {
			request.setAttribute("list", "null");
		}
		request.setAttribute("url", "/views/admin/admin.jsp");
		return "/views/template/layout.jsp";
	}

}
