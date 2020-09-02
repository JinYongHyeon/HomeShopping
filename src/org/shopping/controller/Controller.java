package org.shopping.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Controller {
	public String exectue(HttpServletRequest request,HttpServletResponse response)throws Exception;
}
