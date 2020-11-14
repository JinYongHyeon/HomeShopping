package org.shopping.controller;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.shopping.model.ProductDAO;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

/**
 * Servlet implementation class ProductImgUpdateController
 */
@WebServlet("/productImgUpdate")
public class ProductImgUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String path = request.getSession().getServletContext().getRealPath("/resources/img/product/main/");
		MultipartRequest multipartRequest = new MultipartRequest(request,path,10*1024*1024,"UTF-8",new DefaultFileRenamePolicy());
		String productNo = multipartRequest.getParameter("productNo");
		File productImg = multipartRequest.getFile("productImg");
		
		try {
			ProductDAO.getInstance().productImgUpdate(productImg.getName(), productNo);
			request.setAttribute("responsebody", productImg.getName());
			request.getRequestDispatcher("/AjaxView").forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
			response.sendRedirect("/views/error.jsp");
		}
		
		
		
		
	}

}
