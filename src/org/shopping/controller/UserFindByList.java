package org.shopping.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.shopping.model.PagingBean;
import org.shopping.model.UserDAO;
import org.shopping.model.UserVO;

public class UserFindByList implements Controller {

	public UserFindByList() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String exectue(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int totalRow =UserDAO.getInstance().userFindByListCount(request.getParameter("id").trim());
		String id = request.getParameter("id").trim();
		PagingBean paging = null;
		if(request.getParameter("nowPage")==null) {
			paging =new PagingBean(totalRow);
		}else {
			paging = new PagingBean(Integer.parseInt(request.getParameter("nowPage")),totalRow);
		}
		ArrayList<UserVO> list =UserDAO.getInstance().userFindByList(id,paging);
		request.setAttribute("list", list);
		request.setAttribute("paging", paging);
		request.setAttribute("id", id);
		
		request.setAttribute("url", "/views/admin/admin.jsp");
		return "/views/template/layout.jsp";
	}

}
