package org.shopping.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.shopping.model.DataSourceManager;
import org.shopping.model.UserDAO;
import org.shopping.model.UserVO;

public class UserSingUpController implements Controller {

	public UserSingUpController() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String exectue(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//String telPattern = "(\\d{3})(\\d{4})(\\d{4})";
		String id= request.getParameter("id");
		String pass= request.getParameter("password");
		String name= request.getParameter("name");
		String tel= request.getParameter("tel");
		String arrayAddress[]= request.getParameterValues("address");
		String address = "";
		for(String addr  : arrayAddress) {
			address+= addr;
		}
		String email= request.getParameter("email");
		UserVO uvo = new UserVO();
		uvo.setId(id);
		uvo.setPassword(pass);
		uvo.setName(name);
		uvo.setTelephone(tel);
		uvo.setAddress(address);
		uvo.setEmail(email);
		
		UserDAO.getInstance().userSingUp(uvo);
		return "redirect:shopping?command=home";
	}

}
