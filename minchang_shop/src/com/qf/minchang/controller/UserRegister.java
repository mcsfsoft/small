package com.qf.minchang.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qf.minchang.dao.RegisterDao;
import com.qf.minchang.dao.RegisterDaoImpl;


@WebServlet(urlPatterns="/userRegister")
public class UserRegister extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RegisterDao  registerDao=new RegisterDaoImpl();
		String username=req.getParameter("username");
		String password=req.getParameter("password");
		String email=req.getParameter("email");
		String gender=req.getParameter("gender");
		int i=registerDao.add(username,password,email,gender);
		if(i>0){
			System.out.println("×¢²á³É¹¦");
			resp.sendRedirect("login.jsp");
		}else {
			System.out.println("×¢²áÊ§°Ü");
			resp.sendRedirect("register.jsp");
		}
	}
}
