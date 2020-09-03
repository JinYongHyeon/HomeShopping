package org.shopping.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.shopping.model.UserDAO;
import org.shopping.model.UserVO;

public class UserListController implements Controller {

	public UserListController() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String exectue(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ArrayList<UserVO> list= UserDAO.getInstance().userList();
		request.setAttribute("list", list);
		return "admin.jsp";
	}

}