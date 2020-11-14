package org.shopping.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
		UserVO vo = UserDAO.getInstance().userLogin(new UserVO(id, pass));
		response.setContentType("text/html;charset=utf-8");
		if (vo != null) {
			HttpSession session = request.getSession();
			session.setAttribute("user", vo);
		} else {
			return "redirect:views/user/login-fail.jsp"; //포워드 방식으로 값 하나  줘서 오류 알림 보내기
		}
		return "redirect:shopping?command=home";
	}

}
