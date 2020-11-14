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
		UserVO uvo = (UserVO)session.getAttribute("user");
		String telPattern = "(\\d{3})(\\d{4})(\\d{4})";
		String id= request.getParameter("id");
		String pass =null;
		String address = null;
		if(request.getParameter("password").trim().equals("")) {
		pass =  uvo.getPassword();
		}else {
		 pass= request.getParameter("password");
		}
		String name= request.getParameter("name");
		String tel= request.getParameter("tel").replaceAll(telPattern,"$1-$2-$3");
		if(request.getParameter("address").trim().equals("")) {
		 address = uvo.getAddress();
		}else {
		address= request.getParameter("address");
		}
		String email= request.getParameter("email");
		
		UserVO vo = new UserVO();
		vo.setId(id);
		vo.setPassword(pass);
		vo.setName(name);
		vo.setTelephone(tel);
		vo.setAddress(address);
		vo.setEmail(email);
		
		UserDAO.getInstance().userImformationUpdate(vo);
		UserVO userVO = UserDAO.getInstance().userLogin(new UserVO(id,pass));
		userVO.setTelephone(userVO.getTelephone().replace("-", ""));
		session.setAttribute("user", userVO);
		}
	
		return "redirect:index.jsp";
	}

}
