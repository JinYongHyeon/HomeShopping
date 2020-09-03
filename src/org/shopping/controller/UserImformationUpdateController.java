package org.shopping.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.shopping.model.UserDAO;
import org.shopping.model.UserVO;

public class UserImformationUpdateController implements Controller {

	public UserImformationUpdateController() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String exectue(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession(false);
		if(session != null && session.getAttribute("user") != null) {
		String telPattern = "(\\d{3})(\\d{4})(\\d{4})";
		String id= request.getParameter("id");
		String pass= request.getParameter("password");
		String name= request.getParameter("name");
		String tel= request.getParameter("tel").replaceAll(telPattern,"$1-$2-$3");
		String address= request.getParameter("address");
		String email= request.getParameter("email");
		
		UserDAO.getInstance().userImformationUpdate(new UserVO(id,pass,name,tel,address,email));
		UserVO vo = UserDAO.getInstance().userFindByList(id);
		session.setAttribute("user", vo);
		}
	
		return "redirect:index.jsp";
	}

}
