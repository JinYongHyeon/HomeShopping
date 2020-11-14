package org.shopping.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.shopping.model.PagingBean;
import org.shopping.model.UserDAO;
import org.shopping.model.UserVO;

public class UserListController implements Controller {

	@Override
	public String exectue(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession(false);
		if (session == null || session.getAttribute("user") == null) {
			return "redirect:shopping?command=home";
		} else {
			UserVO uvo = (UserVO) session.getAttribute("user");
			if (!uvo.getId().equals("admin")) {
				return "redirect:shopping?command=home";
			}
		}
		int totalCount = UserDAO.getInstance().userListCount();
		PagingBean paging = null;
		if ( request.getParameter("nowPage") == null) {
			paging = new PagingBean(totalCount);
		} else {
			paging = new PagingBean(Integer.parseInt(request.getParameter("nowPage")),totalCount);
		}

		ArrayList<UserVO> list = UserDAO.getInstance().userList(paging);
		request.setAttribute("list", list);
		request.setAttribute("paging", paging);
		request.setAttribute("url", "/views/admin/admin.jsp");
		return "/views/template/layout.jsp";
	}

}
