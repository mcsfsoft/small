package com.qf.minchang.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qf.minchang.dao.UserInfoDao;
import com.qf.minchang.dao.UserInfoDaoImpl;
import com.qf.minchang.entity.User;


@SuppressWarnings("all")

@WebServlet(urlPatterns="/uinfo")
public class UserInfoServlet  extends HttpServlet{
		@Override
		protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			// TODO Auto-generated method stub
			
			String action=req.getParameter("action");
			System.out.println(action);
			if(action.equals("userList")) {//会员管理
				String username="";
				String gender = "";
				username = req.getParameter("username");
				String gender1 = req.getParameter("gender");
				
				if(gender1!=null) {
					 gender=new String(gender1.getBytes("ISO-8859-1"),"UTF-8");
				}
				System.out.println(username);
				System.out.println(gender);
				UserInfoDao user=new UserInfoDaoImpl();
				List<User> list=user.findAll(username,gender);
				req.setAttribute("lists", list);
				req.getRequestDispatcher("admin/userList.jsp").forward(req, resp);
			}else if(action.equals("invalidUser")) {//无效管理
				UserInfoDao user=new UserInfoDaoImpl();
				List<User> lists=user.findInvalidUser();
				req.setAttribute("inli", lists);
				req.getRequestDispatcher("admin/invalidUser.jsp").forward(req, resp);
			}else if(action.equals("delete")) {
				int id=0;
				String id2=req.getParameter("id");
				if(id2!=null) {
					 id=Integer.parseInt(id2);
				}

				System.out.println("id:"+id);
				UserInfoDao user=new UserInfoDaoImpl();
				int a=user.deleteById(id);
				if(a!=0) {
					System.out.println("删除成功");
				}else {
					System.out.println("删除失败");
				}
				req.getRequestDispatcher("admin/userList.jsp").forward(req, resp);
			}
		}
}
