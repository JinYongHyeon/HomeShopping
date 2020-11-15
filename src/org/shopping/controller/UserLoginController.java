package org.shopping.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;
import org.shopping.model.UserDAO;
import org.shopping.model.UserVO;

public class UserLoginController implements Controller {

	public UserLoginController() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String exectue(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String id = request.getParameter("id");
		String pass = request.getParameter("password");
		int coin = 0;
		UserVO vo = UserDAO.getInstance().userLogin(new UserVO(id, pass));
		if (vo != null) {
			HttpSession session = request.getSession();
			session.setAttribute("user", vo);
			coin = 1;
		} 
		
		request.setAttribute("responsebody", coin);
		return "/AjaxView";
	}

}
