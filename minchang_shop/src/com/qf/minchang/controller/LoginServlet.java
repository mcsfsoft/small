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
	 *��¼ҳ���߼�
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
						
						  	//�ж��û���������ȷ�µ�Ȩ��	
							if(user.getRole()==1)
							{Boolean flag;
								if(flag=dao.password(username,password)){
										session.setAttribute("userInfo", user);
										req.getRequestDispatcher("index.jsp").forward(req, resp);
									}else
										resp.sendRedirect("login.jsp");
							}else {// �����û���
								Boolean flag;
									if(flag=dao.password(username,password)) {
										session.setAttribute("userInfo", user);
										System.out.println("admin��¼�ɹ�");
										req.getRequestDispatcher("/admin/admin.jsp").forward(req, resp);
									}else
										resp.sendRedirect("login.jsp");
								}
					}else {  //�û�������,���ص�¼ҳ��
						resp.sendRedirect("login.jsp");
					}
			}
}

/*	if(user!=null) {
			  if(session==null ) {
				  //TODO �ж��Ƿ�ѡ���¼
				  req.getRequestDispatcher("login.jsp").forward(req, resp); 
			  }	else if(session != null)
			  	{//�ж��û���������ȷ�µ�Ȩ��
											  	if(username.equals(user.getUsername())) {
											  		if(password.equals(user.getPassword())) {
													  	session.setAttribute("userInfo", username);
												  		req.getRequestDispatcher("index.jsp").forward(req, resp);
											  		}else {
											  			System.out.println("�û��������");
											  		}
											  	}else if("admin".equals(user.getUsername())) {	
											  		System.out.println(user.getUsername());
											  		if(password.equals(user.getPassword())) {
													  	session.setAttribute("userInfo", username);
												  		req.getRequestDispatcher("/admin/admin.jsp").forward(req, resp);
											  		}else {
											  			System.out.println("����Ա�������");
											  		}	
											  	}
			  	}
			}else {
				String mes="�û���������,����ע��";
				req.setAttribute("mess", mes);
				req.getRequestDispatcher("login.jsp").forward(req, resp);
			}
 * 
 * */