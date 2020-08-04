package com.qf.minchang.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.qf.minchang.dao.LoginDao;
import com.qf.minchang.dao.LoginDaoImpl;
import com.qf.minchang.entity.User;
 
public class LoginServlet extends HttpServlet{

	/***
	 *登录页面逻辑
	 * @author MinChang;
	 * 
	 */ 
	//
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub

			String username = req.getParameter("username");
			String password = req.getParameter("password");
			LoginDao dao=new  LoginDaoImpl();
			User user=dao.findUserNameById(username);
			System.out.println(username);
			System.out.println(password);
					if(user!=null) {
						HttpSession session = req.getSession();
						
						  	//判断用户名密码正确下的权限	
							if(user.getRole()==1)
							{Boolean flag;
								if(flag=dao.password(username,password)){
										session.setAttribute("userInfo", user);
										req.getRequestDispatcher("index.jsp").forward(req, resp);
									}else
										resp.sendRedirect("login.jsp");
							}else {// 正常用户名
								Boolean flag;
									if(flag=dao.password(username,password)) {
										session.setAttribute("userInfo", user);
										System.out.println("admin登录成功");
										req.getRequestDispatcher("/admin/admin.jsp").forward(req, resp);
									}else
										resp.sendRedirect("login.jsp");
								}
					}else {  //用户不存在,返回登录页面
						resp.sendRedirect("login.jsp");
					}
			}
}

/*	if(user!=null) {
			  if(session==null ) {
				  //TODO 判断是否勾选免登录
				  req.getRequestDispatcher("login.jsp").forward(req, resp); 
			  }	else if(session != null)
			  	{//判断用户名密码正确下的权限
											  	if(username.equals(user.getUsername())) {
											  		if(password.equals(user.getPassword())) {
													  	session.setAttribute("userInfo", username);
												  		req.getRequestDispatcher("index.jsp").forward(req, resp);
											  		}else {
											  			System.out.println("用户密码错误");
											  		}
											  	}else if("admin".equals(user.getUsername())) {	
											  		System.out.println(user.getUsername());
											  		if(password.equals(user.getPassword())) {
													  	session.setAttribute("userInfo", username);
												  		req.getRequestDispatcher("/admin/admin.jsp").forward(req, resp);
											  		}else {
											  			System.out.println("管理员密码错误");
											  		}	
											  	}
			  	}
			}else {
				String mes="用户名不存在,请先注册";
				req.setAttribute("mess", mes);
				req.getRequestDispatcher("login.jsp").forward(req, resp);
			}
 * 
 * */