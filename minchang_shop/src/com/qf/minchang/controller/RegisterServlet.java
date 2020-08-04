package com.qf.minchang.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.qf.minchang.dao.RegisterDao;
import com.qf.minchang.dao.RegisterDaoImpl;
import com.qf.minchang.entity.User;


@SuppressWarnings("all")
public class RegisterServlet  extends HttpServlet{
	
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username=req.getParameter("username");
		System.out.println("´«Öµ1:"+username);
		resp.setContentType("text/html;charset=UTF-8");
		RegisterDao  registerDao=new RegisterDaoImpl();
		List<User> list=registerDao.findUser(username);
			if(list!=null) {
				for(User lists:list) {
					System.out.println(lists.toString());
				}
				String jsonString=JSON.toJSONString(list);
				PrintWriter out =resp.getWriter();
				out.write(jsonString);
				out.flush();
				out.close();
			}else {
				System.out.println("´íÎó");
			}

	}
}
