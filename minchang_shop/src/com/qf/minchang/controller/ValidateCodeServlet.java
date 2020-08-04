package com.qf.minchang.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.dsna.util.images.ValidateCode;

public class ValidateCodeServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 ValidateCode vc=new ValidateCode(120,30,4,10);
		 String codeStr =vc.getCode();
		 HttpSession session=req.getSession();
		 session.setAttribute("vcode", codeStr);
		 vc.write(resp.getOutputStream());
		 
	}
}
