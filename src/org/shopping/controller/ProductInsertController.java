package org.shopping.controller;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

import javax.jws.WebService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.shopping.model.ProductDAO;
import org.shopping.model.ProductVO;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@WebServlet("/productInsert")
public class ProductInsertController extends HttpServlet {

	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String path = request.getSession().getServletContext().getRealPath("/resources/img/product/main/");
		MultipartRequest multipartRequest = new MultipartRequest(request,path,10*1024*1024,"UTF-8",new DefaultFileRenamePolicy());
		String name = multipartRequest.getParameter("name");
		int price = Integer.parseInt(multipartRequest.getParameter("price"));
		int count = Integer.parseInt(multipartRequest.getParameter("count"));
		String kinds=multipartRequest.getParameter("kind");
		String content = multipartRequest.getParameter("content");
		File productImg = multipartRequest.getFile("imgPath");
		
		ProductVO pvo = new ProductVO();
		pvo.setProductName(name);
		pvo.setProductPrice(price);
		pvo.setProductPossesionCount(count);
		pvo.setKinds(kinds);
		pvo.setProductContent(content);
		pvo.setProductMainImg(productImg.getName());
		
		try {
			ProductDAO.getInstance().productInsert(pvo);
			response.sendRedirect("shopping?command=userList");		
		} catch (SQLException e) {
			e.printStackTrace();
			response.sendRedirect("/views/error.jsp");
		}
		
		System.out.println(name+" "+price+" "+count+" "+kinds+" "+content+productImg);
	}
	
	

}
