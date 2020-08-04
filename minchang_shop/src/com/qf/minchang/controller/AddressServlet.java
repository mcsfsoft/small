package com.qf.minchang.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.qf.minchang.dao.AddressDao;
import com.qf.minchang.dao.AddressDaoImpl;
import com.qf.minchang.entity.Address;
import com.qf.minchang.entity.Orders;
import com.qf.minchang.entity.User;


@WebServlet(urlPatterns="/address")
public class AddressServlet extends HttpServlet {
		@Override
		protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			// TODO Auto-generated method stub
			String action=req.getParameter("action");
			if(action.equals("getOrderView"))//跳转个人订单页面
			{
				HttpSession session=req.getSession();
				Object object = session.getAttribute("userInfo");
				if(object!=null) {
					User user=(User)object;
					AddressDao ad=new AddressDaoImpl();
					List<Address> list=ad.findAddressByUid(user.getId());
					req.setAttribute("adresses", list);

					req.getRequestDispatcher("order.jsp").forward(req, resp);
				}else {
					req.getRequestDispatcher("login.jsp").forward(req, resp);
				}

				
			}else if(action.equals("add")) {//添加地址信息
				String name = req.getParameter("name");
				String phone = req.getParameter("phone");
				String detail1=req.getParameter("detail");
				String detail = new String(detail1.getBytes("ISO-8859-1"),"UTF-8");				
				System.out.println("name:"+name);
				System.out.println("phone:"+phone);
				System.out.println("detail:"+detail);
				HttpSession session=req.getSession();
				Object userInfo=session.getAttribute("userInfo"); 
				User user=(User) userInfo;
				AddressDao ad=new AddressDaoImpl();
				int a=ad.updateAddressInfo(name,phone,detail,user.getId());
				if(a!=0) {
					System.out.println("添加成功");
				}else {
					System.out.println("添加失败");
				}
				req.getRequestDispatcher("address?action=getOrderView").forward(req, resp);
				
/*			}else if(action.equals("")) {//待用
				HttpSession session = req.getSession();
				Object userInfo = session.getAttribute("userInfo");
				if(userInfo!=null) {
					User user=(User) userInfo;
					AddressDao ad=new AddressDaoImpl();
				//	List<Orders>
					
				}*/
			}
		}
}
