package com.qf.minchang.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.qf.minchang.dao.OrderDao;
import com.qf.minchang.dao.OrderDaoImpl;
import com.qf.minchang.entity.Detail;
import com.qf.minchang.entity.Orders;
import com.qf.minchang.entity.User;
import com.qf.minchang.entity.UserDetails;
import com.qf.minchang.entity.UserGoods;
import com.qf.minchang.service.OrderService;
import com.qf.minchang.service.OrderServiceImpl;


@WebServlet(urlPatterns="/orders")
public class OrderServlet extends HttpServlet{
		@Override
		protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			// TODO Auto-generated method stub
			HttpSession session = req.getSession();
			Object object = session.getAttribute("userInfo");			
			User user=(User)object;			
			String action=req.getParameter("action");			
			String aid1=req.getParameter("aid");
			
			int aid=0;			
			int uid=0;			
			if(object!=null) {//uid				
				uid=user.getId();				
			}
			if(aid1!=null) {//aid			
				 aid=Integer.parseInt(aid1);
			}
			Map cart=(Map) session.getAttribute("cart");
			if(action.equals("addOrder")) {
				
				OrderService dao=new OrderServiceImpl();				
				boolean b = dao.addOrder(uid, aid, cart);			
				if(b) {					
					System.out.println("添加成功");					
					OrderDao daos=new OrderDaoImpl();				
					List<Detail> list=daos.findOrdersByUid(uid);					
					req.setAttribute("ordes", list);//发送到order		
					cart.clear();
					req.getRequestDispatcher("orderList.jsp").forward(req, resp);					
	/*				resp.sendRedirect("orderList.jsp");*/
				}else {
					System.out.println("添加失败");					
					resp.sendRedirect("cart.jsp");
				}				
			}else if(action.equals("clear")) {
				cart.clear();
				resp.sendRedirect("cart.jsp");
			}
			
			
			else if(action.equals("getOrder")) {				
				req.getRequestDispatcher("orderList.jsp").forward(req, resp);
			//orderDetails.jsp  	
			}else if(action.equals("detail")) {
				//订单信息等
				System.out.println("我进入detail了");			
				String oid=req.getParameter("oid");	
				System.out.println("oid:"+oid);
				OrderDao daos=new OrderDaoImpl();				
				UserDetails us=daos.findDetailsByOId(oid);				
				req.setAttribute("details", us);
				//订单内商品信息
				List<UserGoods> list=daos.findGoodsByOId(oid);
				for(UserGoods list1:list) {
					System.out.println(list1);
				}
				req.setAttribute("ugoods", list);
				req.getRequestDispatcher("orderDetail.jsp").forward(req, resp);
			}
		}
		
}
